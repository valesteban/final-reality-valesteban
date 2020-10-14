package com.github.cc3002.finalreality.model.character;
/**
 * This is an interface for Character (Enemy and player)
 */
public interface ICharacter {
  void waitTurn();
  String getName();
  String getCharacterClass();
  void addToQueue();
}
