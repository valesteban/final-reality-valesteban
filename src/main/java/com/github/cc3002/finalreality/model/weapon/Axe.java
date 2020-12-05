package com.github.cc3002.finalreality.model.weapon;


import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class that creates a specific type of weapon: Axe
 *
 *
 * @author Valentina Esteban
 */

public class Axe extends AbstractWeapon{

    /**
     * Creates a weapon Axe  with a name, a base damage, weight and it's type
     *which is Axe.
     *
     */
    public Axe(final String name, final int damage,
                          final int weight){
        super( name, damage, weight, "Axe");
    }
    /**
     * It will give the responsibility of equipped to teh character.
     */
    @Override
    public void equipFor(IPlayerCharacter character) {
        character.equipWithAxe(this);
    }
}
