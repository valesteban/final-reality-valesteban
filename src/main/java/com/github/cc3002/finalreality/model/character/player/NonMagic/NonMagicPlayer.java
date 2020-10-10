package com.github.cc3002.finalreality.model.character.player.NonMagic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class NonMagicPlayer extends PlayerCharacter {
    public NonMagicPlayer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                          @NotNull String name, int healthPoints, String characterClass){
        super(turnsQueue, name ,healthPoints, characterClass);
    }



    public void equipped(Staff weapon) { //combiara en el futuro
        this.equippedWeapon = weapon;
    }

}
