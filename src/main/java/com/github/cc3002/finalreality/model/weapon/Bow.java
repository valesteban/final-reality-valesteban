package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class that creates a specific type of weapon: Bow
 *
 *
 * @author Valentina Esteban
 */

public class Bow extends AbstractWeapon {

    /**
     * Creates a weapon Bow  with a name, a base damage, weight and it's type
     *which is Bow.
     *
     */
    public Bow(final String name, final int damage,
               final int weight) {
        super(name, damage, weight, "Bow");
    }

    /**
     * It will give the responsibility of equipped to teh character.
     */
    @Override
    public void equipFor(IPlayerCharacter character) {
        character.equipWithBow(this);
    }
}

