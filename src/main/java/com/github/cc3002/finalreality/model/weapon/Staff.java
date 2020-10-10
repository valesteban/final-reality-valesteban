package com.github.cc3002.finalreality.model.weapon;

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
}