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

    @Override
    public void equipWithAxe(Axe axe) {
        setEquippedWeapon(axe);
    }

    @Override
    public void equipWithBow(Bow bow) {
        setEquippedWeapon(null);
    }

    @Override
    public void equipWithKnife(Knife knife) {
        setEquippedWeapon(knife);
    }

    @Override
    public void equipWithStaff(Staff staff) {
        setEquippedWeapon(null);
    }

    @Override
    public void equipWithSword(Sword sword) {
        setEquippedWeapon(sword);
    }

}