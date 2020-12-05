package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
/**
 * A class that creates a character of type WhiteMage
 *
 * @author Valentina Esteban
 */
public class WhiteMage extends MagicCharacter {
    /**
     * Creates a new WhiteMage with a name, mana  and the queue with the characters ready to
     * play..
     *
     */
    public WhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull String name, int mana, int protection) {
        super(turnsQueue, name, "WhiteMage",mana, protection);
    }
    /**
     * gives a weapon to the variable equippedWeapon
     * of this PlayerCharacter ane every weapon will see if they can or not equipped the player.
     **/
    public  void equip(IWeapon weapon) {
        if (this.getHealthPoints() != 0){
            weapon.equipFor(this);
        } else {
            this.setEquippedWeapon(null);
        }
    }

}