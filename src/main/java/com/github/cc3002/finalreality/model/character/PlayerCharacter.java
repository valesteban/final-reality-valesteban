package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

import org.jetbrains.annotations.NotNull;

public  class PlayerCharacter extends AbstractCharacter {

    protected IWeapon equippedWeapon = null;

    public PlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                           @NotNull String name, int healthPoints,String characterClass) {
        super(turnsQueue, name, healthPoints, characterClass);
        this.equippedWeapon = null ;
    }


    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        //if (this instanceof PlayerCharacter) {
        scheduledExecutor
                .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
        //}
    }

    @Override
    public int hashCode() {
        return Object.hashCode(getCharacterClass());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerCharacter)) {
            return false;
        }
        final PlayerCharacter that = (PlayerCharacter) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }
}
