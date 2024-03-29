package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;


/**
 * A class that creates a specific type of weapon: Sword
 *
 *
 * @author Valentina Esteban
 */
public class Sword extends AbstractWeapon {
    /**
     * Creates a weapon Sword  with a name, a base damage, weight and it's type
     *which is Sword.
     *
     */
    public Sword(final String name, final int damage,
                 final int weight) {
        super(name, damage, weight, "Sword");
    }
    /**
     * It will equipped a Knight with a sword.
     */
    public void equipFor(Knight character) {
        character.setEquippedWeapon(this);
    }

    /**
     * It will equipped a thief with a sword.
     */
    public void equipFor(Thief character) {
        character.setEquippedWeapon(this);
    }
}

