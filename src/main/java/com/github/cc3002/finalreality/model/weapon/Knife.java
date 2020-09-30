package com.github.cc3002.finalreality.model.weapon;

public class Knife extends AbstractWeapon{

    public Knife( String name, int damage, int weight){
        super(name ,damage ,weight);
        this.type = "Knife";
    }
}
