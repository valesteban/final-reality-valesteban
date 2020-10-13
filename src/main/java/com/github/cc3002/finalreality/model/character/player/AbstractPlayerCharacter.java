package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter {

    protected IWeapon equippedWeapon ;

    public AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                           final String characterClass) {
        super(turnsQueue, name, characterClass);
        this.equippedWeapon = null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass());
    }
    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor
                .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IPlayerCharacter)) {
            return false;
        }
        final IPlayerCharacter that = (IPlayerCharacter) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }


    public void equip(IWeapon weapon) {
        this.equippedWeapon = weapon;
    }

    public IWeapon getEquippedWeapon(){
        return equippedWeapon;
    }
}
