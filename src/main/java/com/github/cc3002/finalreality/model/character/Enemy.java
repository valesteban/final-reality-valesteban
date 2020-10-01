package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Your name>
 */
public class Enemy extends AbstractCharacter {

  protected final int weight;



  public Enemy(@NotNull BlockingQueue<ICharacter> turnsQueue,
               @NotNull String name, int healthPoints ,int weight) {
    super(turnsQueue, name,healthPoints);
    this.weight = weight;
    this.characterClass = "Enemy";
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    //if (this instanceof Enemy) {
      var enemy = (Enemy) this;
      scheduledExecutor
              .schedule(this::addToQueue, enemy.weight / 10, TimeUnit.SECONDS);
    //}
  }

  public int getWeight(){
    return weight;
  }
  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight();
  }
}
