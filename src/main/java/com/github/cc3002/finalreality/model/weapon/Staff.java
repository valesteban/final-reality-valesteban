package com.github.cc3002.finalreality.model.weapon;

public class Staff extends AbstractWeapon {
    private int magicDamage;
    private final String type = "Staff";

    public Staff( String name, int damage, int weight, int magicDamage ){
        super(name, damage, weight);
        this.magicDamage = magicDamage;
    }

    @Override
    public String getType() {
        return type;
    }

    public int getMagicDamage() {
        return magicDamage;
    }
}
