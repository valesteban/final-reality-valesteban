package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractWeapon {
    protected int magicDamage;


    public Staff(final String name, final int damage,
               final int weight,int magicDamage) {

        super(name, damage, weight, "Staff");
        this.magicDamage = magicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
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
                getDamage() == weapon.getDamage() &&

                getType().equals(weapon.getType());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getName(), getDamage(), getWeight(), getType(),getMagicDamage());
    }
}