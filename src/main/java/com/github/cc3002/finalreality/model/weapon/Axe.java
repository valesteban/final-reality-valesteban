package com.github.cc3002.finalreality.model.weapon;


import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.MagicCharacter;

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
     * It will equipped a knight with an axe.
     */
    public void equipFor(Knight character) {
        character.setEquippedWeapon(this);
    }
    /**
     * It will equipped a engineer with an axe.
     */
    public void equipFor(Engineer character) {
        character.setEquippedWeapon(this);
    }

}
