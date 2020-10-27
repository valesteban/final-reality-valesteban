package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
/**
 * A class that creates a character of type Thief
 *
 * @author Valentina Esteban
 */
public class Thief extends AbstractPlayerCharacter {
    /**
     * Creates a new Thief with a name and the queue with the characters ready to
     * play.
     *
     */
    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue,
                 @NotNull String name) {
        super(turnsQueue, name, "Thief");
    }


    @Override
    public void equipWithAxe(Axe axe) {
        setEquippedWeapon(null);
    }
    @Override
    public void equipWithBow(Bow bow) {
        setEquippedWeapon(bow);
    }
    @Override
    public void equipWithKnife(Knife knife) {
        setEquippedWeapon(null);
    }
    @Override
    public void equipWithStaff(Staff staff) {
        setEquippedWeapon(staff);
    }
    @Override
    public void equipWithSword(Sword sword) {
        setEquippedWeapon(sword);
    }

}