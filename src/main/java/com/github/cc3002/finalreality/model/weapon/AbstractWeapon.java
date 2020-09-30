package com.github.cc3002.finalreality.model.weapon;
import java.util.Objects;

public abstract class AbstractWeapon implements IWeapon{
        private  String name;
        private  int damage;
        private  int weight;
        protected String type;
        //protected String weaponType;

        public AbstractWeapon(String name,int damage, int weight) {
            this.name = name;
            this.damage = damage;
            this.weight = weight;
          //  this.type = "None";
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
        public String getType() {
            return null;
        }
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof AbstractWeapon)) {
                return false;
            }
            final AbstractWeapon weapon = (AbstractWeapon) o;
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