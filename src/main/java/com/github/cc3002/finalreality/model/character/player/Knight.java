package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
/**
 * A class that creates a character of type Knight
 *
 * @author Valentina Esteban
 */
public class Knight extends AbstractPlayerCharacter {
    /**
     * Creates a new Thief with a name and the queue with the characters ready to
     * play.
     *
     */
    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue,
                  @NotNull String name , int protection) {
        super(turnsQueue, name, "Knight", protection);
    }
    /**
     * It will equipped the this player with an axe.
     */
    @Override
    public void equipWithAxe(Axe axe) {
        setEquippedWeapon(axe);
    }
    /**
     * It wont equipped the this player with a bow so it will put a null.
     */
    @Override
    public void equipWithBow(Bow bow) {
        setEquippedWeapon(null);
    }
    /**
     * It will equipped  this player with a knife.
     */
    @Override
    public void equipWithKnife(Knife knife) {
        setEquippedWeapon(knife);
    }
    /**
     * It wont equipped the this player with a staff so it will put a null.
     */
    @Override
    public void equipWithStaff(Staff staff) {
        setEquippedWeapon(null);
    }
    /**
     * It will equipped this player with a sword.
     */
    @Override
    public void equipWithSword(Sword sword) {
        setEquippedWeapon(sword);
    }
}