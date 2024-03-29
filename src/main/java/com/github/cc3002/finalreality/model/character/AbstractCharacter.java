package com.github.cc3002.finalreality.model.character;

import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.cc3002.finalreality.Controller.handler.IEveventHandler;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import org.jetbrains.annotations.NotNull;
/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Valentina Esteban
 */
public abstract class AbstractCharacter implements ICharacter {

  private final BlockingQueue<ICharacter> turnsQueue;
  private final String name;
  private final String characterClass;
  private int healthPoints = 100;
  private int protection;
  protected ScheduledExecutorService scheduledExecutor;
  private boolean alive = true;
  protected PropertyChangeSupport characterAttackedEvent = new PropertyChangeSupport(this);
  /**
   * Creates a new player Character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   * @param protection
   *     value of defence when is attacked
   *
   */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, String characterClass, int protection) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.protection = protection;
  }
  @Override
  public abstract void waitTurn() ;
  /**
   * Adds this character to the turns queue.
   */
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown(); }
  /**
   * Returns the name of this character.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns true if a character is alive.
   */
  public boolean getAlive(){return alive;}

  /**
   * set false if a character is now dead.
   */
  public void setDead(){
    this.alive = false;
    characterAttackedEvent.firePropertyChange("is attacked",null, this); //manda mensaje a handler
  }

  /**
   * Returns the healthPoints of this character.
   */
  public int getHealthPoints(){ return healthPoints; }

  /**
   * Returns the protection of this character.
   */
  public int getProtection(){ return protection; }
  /**
   * set a new healthPoints of this character.
   */
  public void setHealthPoints(int newHealthPoints){
    this.healthPoints = newHealthPoints;
  }
  /**
   * Returns the type of this character.
   */
  @Override
  public String getCharacterClass() {
    return characterClass;
  }

  /**
   * it will run when a character is attacked by an enemy.
   */
  @Override
  public abstract void isAttackByEnemy(Enemy enemy);


  /**
   * it will run when a character is attacked by a player.
   */
  @Override
  public abstract void isAttackByPlayer(IPlayerCharacter playerCharacter);

  /**
   * it will add a listener handler to a character.
   */
  public void addListener(IEveventHandler handler){
    characterAttackedEvent.addPropertyChangeListener(handler);
  }
}
