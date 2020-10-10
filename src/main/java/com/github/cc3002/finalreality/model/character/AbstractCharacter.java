package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final String characterClass;
  protected ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, String characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

  @Override
  public abstract void waitTurn() ;

  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getCharacterClass() {
    return characterClass;
  }
}
