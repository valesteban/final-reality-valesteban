package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.player.*;

import java.util.Objects;

/**
 * A class that creates a specific type of weapon: Staff
 * and its variables
 *
 * @author Valentina Esteban
 */

public class Staff extends AbstractWeapon {
    protected int magicDamage;
    /**
     * Creates a weapon Staff with a name, a base damage, weight and it's type
     *which is Staff.
     *
     */
    public Staff(final String name, final int damage,
               final int weight,int magicDamage) {

        super(name, damage, weight, "Staff");
       this.magicDamage = magicDamage;
    }
    /**
     * Returns the magicDamage of the staff.
     */
    public int getMagicDamage() {
        return magicDamage;
    }
    /**
     * It will compare an object with this staff.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IWeapon)) {
            return false;
        }
        final IWeapon weapon = (IWeapon) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName()) &&
                getDamage() == weapon.getDamage() &&
                getType().equals(weapon.getType());
    }


    /**
     * gives a specific int for each different staff.
     */
    @Override
    public int hashCode(){
        return Objects.hash(getName(), getDamage(), getWeight(), getType(),getMagicDamage());
    }

    /**
     * It will equipped thief character with the staff.
     */
    public void equipFor(Thief character) {
        character.setEquippedWeapon(this);
    }
    /**
     * It will equipped  black mage character with the staff.
     */
    public void equipFor(BlackMage character) {
        character.setEquippedWeapon(this);
    }
    /**
     * It will equipped  white mage character with the staff.
     */
    public void equipFor(WhiteMage character) {
        character.setEquippedWeapon(this);
    }
}


