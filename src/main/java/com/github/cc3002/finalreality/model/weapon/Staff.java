package com.github.cc3002.finalreality.model.weapon;

public class Staff extends AbstractWeapon {
    private int magicDamage;

    public Staff( String name, int damage, int weight, int magicDamage ){
        super(name, damage, weight);
        this.magicDamage = magicDamage;
        this.type = "Staff";
    }

    public int getMagicDamage() {
        return magicDamage;
    }
}
