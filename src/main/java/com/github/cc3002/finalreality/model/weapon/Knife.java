package com.github.cc3002.finalreality.model.weapon;

public class Knife extends AbstractWeapon{
    private final String type = "Knife";

    public Knife( String name, int damage, int weight){
        super(name ,damage ,weight);
    }

    @Override
    public String getType() {
        return type;
    }
}
