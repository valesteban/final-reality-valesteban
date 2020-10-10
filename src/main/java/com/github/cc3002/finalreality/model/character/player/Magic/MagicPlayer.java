package com.github.cc3002.finalreality.model.character.player.Magic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class MagicPlayer extends PlayerCharacter {
    protected int mana;
    public MagicPlayer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                          @NotNull String name, int healthPoints, String characterClass ,int mana){
        super(turnsQueue, name ,healthPoints, characterClass);
        this.mana = mana;
    }

    public void equipped(Staff weapon) {
        this.equippedWeapon = weapon ;
    }


    //@Override
    //public void equipped(IWeapon weapon) { //despues se supone q va  acambiar especifica para estos
    //    this.equippedWeapon = weapon;
   // }

    protected int getMana() {
        return mana;
    }
}
