package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * An abstract class that holds all the information of a single character of the game
 * and its methods
 *
 * @author Ignacio Slater Muñoz.
 * @author Valentina Esteban
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter {
    protected IWeapon equippedWeapon ;

    /**
     * Creates a new player PlayetCharacter.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param characterClass
     *     the class of this character
     * @param protection
     *     the value of defence when is attacked
     */
    public AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                           final String characterClass, int protection) {
        super(turnsQueue, name, characterClass, protection);
        this.equippedWeapon = null;
    }
    /**
     * returns a hash code to this PlayerCharacter.
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass());
    }
    /**
     * makes this PlayerCharacter waits (equippedWeapon.getWeight() / 10) seconds and then
     * ejecute the method addToQueue()
     */
    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor
                .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    }
    /**
     * Compare this PlayerCharacter with the given Object o.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IPlayerCharacter)) {
            return false;
        }
        final IPlayerCharacter that = (IPlayerCharacter) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }
    /**
     * gives a weapon to the variable equippedWeapon
     * of this PlayerCharacter.
     **/
    public  void equip(IWeapon weapon) {
        weapon.equipFor(this);
    }


    /**
     * Returns the equippedWeapon of this PlayerCharacter.
     */
    public IWeapon getEquippedWeapon(){
        return equippedWeapon;
    }

    /**
     * they will equiped the character.
     */
    public abstract void equipWithAxe(Axe axe);
    public abstract void equipWithBow(Bow bow);
    public abstract void equipWithKnife(Knife knife);
    public abstract void equipWithStaff(Staff staff);
    public abstract void equipWithSword(Sword sword);

    /**
     * change the object in the value equippedWeapon.
     */
    public void setEquippedWeapon(IWeapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    /**
     * method that will call another method that will say what to do with the character
     * that is being attacked.
     */
    @Override
    public void attack(ICharacter character){
        character.isAttackByPlayer(this);
    }

    /**
     * it will change the value of HealthPoints of the player
     * whe is attacked by a enemy.
     */
    @Override
    public void isAttackByEnemy(Enemy enemy) {
        int dano = enemy.getDamage() - this.getprotection();
        int newHP;
        if (this.getHealthPoints() < dano){
            newHP = 0;
        }else {
        newHP = getHealthPoints() - dano;
        }
        this.setHealthPoints(newHP);
    }


    /**
     * it will change the value of HealthPoints of the player
     * when is attacked by another player.
     */
    @Override
    public void isAttackByPlayer(AbstractPlayerCharacter playerCharacter) {
        int dano = playerCharacter.getEquippedWeapon().getDamage() - this.getprotection();
        int newHP;
        if (this.getHealthPoints() < dano){
            newHP = 0;
        } else{
            newHP = this.getHealthPoints()-dano;
        }
        this.setHealthPoints(newHP);
    }
}

