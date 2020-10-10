package com.github.cc3002.finalreality.model.character;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public interface ICharacter {

  void waitTurn();
  String getName();
  //void equip(Weapon weapon);
  //Weapon getEquippedWeapon();
  String getCharacterClass();
}
