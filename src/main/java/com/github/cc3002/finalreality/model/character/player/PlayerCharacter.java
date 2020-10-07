package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

import org.jetbrains.annotations.NotNull;

public abstract class PlayerCharacter extends AbstractCharacter {

  protected IWeapon equippedWeapon = null;

  public PlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                         @NotNull String name, int healthPoints) {
    super(turnsQueue, name, healthPoints);
    this.equippedWeapon = null ;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    //if (this instanceof PlayerCharacter) {
      scheduledExecutor
              .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    //}
  }

  @Override
  public int hashCode() {
    return Object.hashCode(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return getCharacterClass().equals(that.getCharacterClass())
            && getName().equals(that.getName());
  }

  //voy a asumir que en el futuro voy a tener aqui un metodo  abstracto para atacar y esas cosas
}
