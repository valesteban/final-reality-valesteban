package com.github.cc3002.finalreality.model.weapon;

public class Knife extends Weapon{
    protected final String type ;

    public Knife( String name, int damage, int weight){
        super(name ,damage ,weight);
        this.type= "Knife";
    }

    @Override
    public String getType() {
        return type;
    }
}
