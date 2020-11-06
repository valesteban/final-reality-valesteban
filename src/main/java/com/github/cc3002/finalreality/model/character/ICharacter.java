package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * This is an interface for Character (Enemy and player)
 */
public interface ICharacter {
  void waitTurn();
  String getName();
  String getCharacterClass();
  int getHealthPoints();
  int getProtection();
  void addToQueue();
  void attack(ICharacter character);
  void isAttackByEnemy(Enemy enemy);
  void isAttackByPlayer(AbstractPlayerCharacter playerCharacter);


  //void isAttackByKnight(Knight knight);
  //void isAttackByEngineer(Engineer engineer);
  //void isAttackByThief(Thief thief);
  //void isAttackByBlackMage(BlackMage blackMage);
  //void isAttackByWhiteMage(WhiteMage whiteMage);
}
