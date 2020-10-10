package com.github.cc3002.finalreality.model.weapon;

public class Axe extends Weapon {
    protected final String type ;

    public Axe( String name, int damage, final int weight){
        super(name ,damage ,weight);
        this.type = "Sword";
    }

    @Override
    public String getType() {
         return type;
    }
}

