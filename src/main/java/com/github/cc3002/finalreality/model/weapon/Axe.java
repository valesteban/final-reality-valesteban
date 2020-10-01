package com.github.cc3002.finalreality.model.weapon;

public class Axe  extends AbstractWeapon{
    private final String type = "Axe";

    public Axe( String name,  int damage,  int weight){
        super(name ,damage ,weight);
    }

    @Override
    public String getType() {
        return type;
    }
}
