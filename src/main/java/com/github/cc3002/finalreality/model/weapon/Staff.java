package com.github.cc3002.finalreality.model.weapon;

public class Staff extends Weapon {
    private int magicDamage;
    protected final String type ;

    public Staff( String name, int damage, int weight, int magicDamage ){
        super(name, damage, weight);
        this.magicDamage = magicDamage;
        this.type = "Staff";
    }

    @Override
    public String getType() {
        return type;
    }

    public int getMagicDamage() {
        return magicDamage;
    }
}
