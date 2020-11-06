package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

/**
 * This is an interface for PLayerCharacter
 */
public interface IPlayerCharacter {
    String getName();
    int getProtection();
    String getCharacterClass();
    IWeapon getEquippedWeapon();
    void waitTurn();

    void equip(IWeapon weapon) ;
    void equipWithAxe(Axe axe);
    void equipWithBow(Bow bow);
    void equipWithKnife(Knife knife);
    void equipWithStaff(Staff staff);
    void equipWithSword(Sword sword);
 //   int getHealthPoints();
    void attack(ICharacter character);
}
