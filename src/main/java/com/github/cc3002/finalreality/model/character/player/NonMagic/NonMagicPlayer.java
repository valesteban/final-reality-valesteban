package com.github.cc3002.finalreality.model.character.player.NonMagic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class NonMagicPlayer extends PlayerCharacter {
    public NonMagicPlayer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                          @NotNull String name, int healthPoints){
        super(turnsQueue, name ,healthPoints);
    }

    @Override
    public void equipped(IWeapon weapon) { //combiara en el futuro
        this.equippedWeapon = weapon;
    }
}
