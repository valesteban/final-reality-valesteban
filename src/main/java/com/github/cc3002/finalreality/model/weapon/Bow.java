package com.github.cc3002.finalreality.model.weapon;

public class Bow extends AbstractWeapon{
    private final String type = "Bow";

    public Bow(String name, int damage, final int weight){
        super(name , damage ,weight);
    }

    @Override
    public String getType() {
        return type;
    }
}
