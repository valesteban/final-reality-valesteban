package com.github.cc3002.finalreality.model.weapon;

public class AbstractWeapon implements IWeapon {
    private final String name;
    private final int damage;
    private final int weight;
    private final String type;
    public AbstractWeapon(final String name, final int damage,
                          final int weight, final String type){
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.type = type;

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getType() {
        return type;
    }
}
