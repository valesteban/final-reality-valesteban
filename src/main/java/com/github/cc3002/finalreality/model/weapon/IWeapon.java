package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * This is an interface for all the basic for a weapon
 */
public interface IWeapon {
    String getName();
    int getDamage();
    int getWeight();
    String getType();

    void equipFor(IPlayerCharacter character);

}
