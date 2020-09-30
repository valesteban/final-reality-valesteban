package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import org.jetbrains.annotations.NotNull;

public class PlayerCharacter extends AbstractCharacter {

  protected AbstractWeapon equippedWeapon = null;

  public PlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                         @NotNull String name, int healthPoints) {
    super(turnsQueue, name, healthPoints);
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    //if (this instanceof PlayerCharacter) {
      scheduledExecutor
              .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    //}
  }

  //quiero cambiar esta clase a un aabstracta asi cada player podra equiparse segun la tabal
  //no estoy segura de que hacer con esto
  public void equipped(AbstractWeapon weapon){
    this.equippedWeapon = weapon;
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
}
