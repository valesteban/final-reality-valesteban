package com.github.cc3002.finalreality.model.weapon;

public class Sword extends AbstractWeapon {

    public Sword( String name,  int damage,  int weight){
        super(name ,damage ,weight);
        this.type = "Sword";

    }
}
