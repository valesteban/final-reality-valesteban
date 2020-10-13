package com.github.cc3002.finalreality.model.weapon;
/**
 * A class that creates a specific type of weapon: Knife
 *
 *
 * @author Valentina Esteban
 */

public class Knife extends AbstractWeapon {

    /**
     * Creates a weapon Knife  with a name, a base damage, weight and it's type
     *which is Knife.
     *
     */

    public Knife(final String name, final int damage,
               final int weight){

        super( name, damage, weight, "Knife");
}
    }

