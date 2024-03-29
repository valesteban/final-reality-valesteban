package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * @author Valentina Estean
 * This is an interface for all the basic for a weapon
 */
public interface IWeapon {
    String getName();
    int getDamage();
    int getWeight();
    String getType();


    void equipFor(Engineer character);
    void equipFor(BlackMage character);
    void equipFor(WhiteMage character);
    void equipFor(Thief character);
    void equipFor(Knight character);

}



