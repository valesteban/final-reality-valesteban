package com.github.cc3002.finalreality.model.character.player.NonMagic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends NonMagicPlayer {
    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, int healthPoints){
        super(turnsQueue, name ,healthPoints,"Thief");
    }

    public void equipped(Sword weapon) {
        this.equippedWeapon = weapon ;
    }
    public void equipped(Staff weapon) {
        this.equippedWeapon = weapon ;
    }
    public void equipped(Bow weapon) {
        this.equippedWeapon = weapon ;
    }
}
