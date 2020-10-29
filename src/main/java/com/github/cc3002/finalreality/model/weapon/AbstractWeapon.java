package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Objects;
/**
 * An Abstract class that holds all the information that all the weapon share.
 *
 * @author Ignacio Slater Muñoz.
 * @author Valentina Esteban
 */
public abstract class AbstractWeapon implements IWeapon {
    private final String name;
    private final int damage;
    private final int weight;
    private final String type;
    /**
     * Creates a weapon with a name, a base damage, weight and it's type.
     *which is given by the constructor of the subclass
     *
     * @see Axe
     * @see Bow
     * @see Knife
     * @see Sword
     * @see Staff
     * 
     */
    protected AbstractWeapon(final String name, final int damage,
                          final int weight, final String type){
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.type = type;
    }
    /**
     * Returns the name of this weapon.
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Returns the damage of the weapon.
     */
    @Override
    public int getDamage() {
        return damage;
    }
    /**
     * Returns the weight of the weapon.
     */
    @Override
    public int getWeight() {
        return weight;
    }
    /**
     * Returns the type of the weapon.
     */
    @Override
    public String getType() {
        return type;
    }

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
                getType().equals(weapon.getType());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getType());
    }

    public abstract void equipFor(IPlayerCharacter character);


}
