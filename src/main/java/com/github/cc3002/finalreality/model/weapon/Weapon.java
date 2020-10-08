package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

public  class Weapon implements IWeapon{
    private final String name;
    private final int damage;
    private final int weight;
        ////protected String weaponType;

    public Weapon(String name,int damage, int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
            //this.type = "None";
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
        public  String getType(){
            return type;
        }
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof com.github.cc3002.finalreality.model.weapon.Weapon)) {
                return false;
            }
            final com.github.cc3002.finalreality.model.weapon.Weapon weapon = (com.github.cc3002.finalreality.model.weapon.Weapon) o;
            return getDamage() == weapon.getDamage() &&
                    getWeight() == weapon.getWeight() &&
                    getName().equals(weapon.getName()) &&
                    //getType() == weapon.getType();
                    getType().equals( weapon.getType());
        }
        @Override
        public int hashCode() {
            return Objects.hash(getName(), getDamage(), getWeight(), getType());
        }

}
