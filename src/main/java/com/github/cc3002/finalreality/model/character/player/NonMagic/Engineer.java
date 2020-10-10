package com.github.cc3002.finalreality.model.character.player.NonMagic;

import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Bow;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Engineer extends NonMagicPlayer {
    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, int healthPoints){
        super(turnsQueue, name ,healthPoints,"Engineer");

    }

    public void equipped(Axe weapon) {
        this.equippedWeapon = weapon ;
    }
    public void equipped(Bow weapon) {
        this.equippedWeapon = weapon ;
    }
}
