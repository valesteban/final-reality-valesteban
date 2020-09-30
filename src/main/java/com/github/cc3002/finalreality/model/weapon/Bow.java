package com.github.cc3002.finalreality.model.weapon;

public class Bow extends AbstractWeapon{

    public Bow(String name, int damage, final int weight){
        super(name , damage ,weight);
        this.type = "Bow";

    }
}
