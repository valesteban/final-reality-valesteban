package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;


public class PlayerCharacter extends AbstractCharacter {
  protected IWeapon equippedWeapon = null;

  public PlayerCharacter( @NotNull BlockingQueue<ICharacter> turnsQueue,@NotNull String name,
                         final String characterClass) {
    super(turnsQueue, name, characterClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof PlayerCharacter) {
      scheduledExecutor
              .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    }
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
    return getCharacterClass() == that.getCharacterClass()
        && getName().equals(that.getName());
  }

  public void equip(IWeapon weapon) {
    if (this instanceof PlayerCharacter) {
      this.equippedWeapon = weapon;
    }
  }


}
