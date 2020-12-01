package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.Controller.IEveventHandler;
import com.github.cc3002.finalreality.model.character.player.*;

import java.util.LinkedList;

/**
 * This is an interface for Character (Enemy and player)
 */
public interface ICharacter {
  void waitTurn();
  String getName();
  String getCharacterClass();
  int getHealthPoints();
  int getProtection();
  boolean getAlive();
  void addToQueue();

  void attack(ICharacter character);
  void isAttackByEnemy(Enemy enemy);
  void isAttackByPlayer(IPlayerCharacter playerCharacter);
  void addListener(IEveventHandler handler);

}
