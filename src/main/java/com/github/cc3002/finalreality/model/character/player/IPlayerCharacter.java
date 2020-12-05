package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.Controller.IEveventHandler;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.LinkedList;

/**
 * This is an interface for PLayerCharacter
 */
public interface IPlayerCharacter extends ICharacter{
    void addToQueue();

    String getName();
    int getProtection();
    String getCharacterClass();
    IWeapon getEquippedWeapon();
    void setEquippedWeapon(IWeapon equippedWeapon);
    void waitTurn();
    int getHealthPoints();
    boolean getAlive();

    void equip(IWeapon weapon) ;
    void attack(ICharacter character);
    void isAttackByEnemy(Enemy enemy);
    void isAttackByPlayer(IPlayerCharacter playerCharacter);
    void addListener(IEveventHandler handler);
}
