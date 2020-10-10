package com.github.cc3002.finalreality.model.weapon;

public class Sword extends Weapon {
    protected final String type ;
    public Sword( String name,  int damage,  int weight){
        super(name ,damage ,weight);
        this.type = "Sword";

    }

    @Override
    public String getType() {
        return type;
    }
}
