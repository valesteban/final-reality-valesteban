package com.github.cc3002.finalreality.model.character.player.NonMagic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends NonMagicPlayer{
    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue,
                  @NotNull String name, int healthPoints){
        super(turnsQueue, name ,healthPoints);
        this.characterClass ="Knight";

    }
    public void equipped(Sword weapon) {
        this.equippedWeapon = weapon ;
    }
    public void equipped(Axe weapon) {
        this.equippedWeapon = weapon ;
    }
    public void equipped(Knife weapon) {
        this.equippedWeapon = weapon ;
    }

}
