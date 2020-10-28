package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Valentina Esteban
 */
public class Enemy extends AbstractCharacter {
  private final int weight;
  private int damage;
  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   *
   */
  public Enemy(@NotNull final BlockingQueue<ICharacter> turnsQueue,
               @NotNull final String name, final int weight, int protection, int damage) {
    super(turnsQueue, name, "Enemy", protection);
    this.weight = weight ;
    this.damage = damage ;
  }
  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }
  /**
   * Returns the damage of this enemy.
   */
  public int getDamage(){ return damage; }
  /**
   * makes this enemy waits (enemy.getWeight() / 10) seconds and then
   * ejecute the method addToQueue()
   */

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor.schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }



  /**
   * Compare this Enemy with the given Object o.
   */
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
  /**
   * returns a hash code to this Enemy.
   *
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

  /**
   * method that will call another method that will say what to do with the character
   * that is being attacked.
   */
  @Override
  public void attack(ICharacter character){
    character.isAttackByEnemy(this);
  }

  /**
   * it will change the value of HealthPoints of the enemy
   * whe is attacked by another enemy.
   */
  @Override
  public void isAttackByEnemy(Enemy enemy) {
    int dano = enemy.getDamage() - this.getprotection();
    int newHP = getHealthPoints() - dano;
    this.setHealthPoints(newHP);
  }

  /**
   * it will change the value of HealthPoints of the enemy
   * when is attacked by a player.
   */
  @Override
  public void isAttackByPlayer(AbstractPlayerCharacter playerCharacter) {
    int dano = playerCharacter.getEquippedWeapon().getDamage() - this.getprotection();
    int newHP = this.getHealthPoints()-dano;
    this.setHealthPoints(newHP);
  }

}