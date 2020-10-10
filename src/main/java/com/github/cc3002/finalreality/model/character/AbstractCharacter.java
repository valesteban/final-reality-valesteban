package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected  String characterClass;
  protected ScheduledExecutorService scheduledExecutor;
  protected  int healthPoints;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, int healthPoints, String characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.healthPoints = healthPoints;
    this.characterClass = characterClass;

  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getCharacterClass(){
    return  characterClass;
  }


  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public abstract void waitTurn();

  @Override
  public abstract int hashCode();
}
