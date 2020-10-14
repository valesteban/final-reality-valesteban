package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
/**
 * This is an interface for PLayerCharacter
 */
public interface IPlayerCharacter {
    String getName();
    String getCharacterClass();
    void equip(IWeapon weapon) ;
    IWeapon getEquippedWeapon();
    void waitTurn();
}
