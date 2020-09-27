package com.github.cc3002.finalreality.model.weapon;

public class MagicWeapon extends Weapon{
    private final int magicDamage;

    public MagicWeapon( final String name, final int damage, final int weight, int magicDamage ){
        super(name, damage, weight, WeaponType.STAFF);
        this.magicDamage = magicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }
}
