package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
/**
 * A class that creates a character of type Engineer
 *
 * @author Valentina Esteban
 */
public class Engineer  extends AbstractPlayerCharacter {
    /**
     * Creates a new Thief with a name and the queue with the characters ready to
     * play.
     *
     */
    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, int protection) {
        super(turnsQueue, name, "Engineer",protection);
    }


    /**
     * It will equipped the this player with a axe.
     */
    @Override
    public void equipWithAxe(Axe axe) {
        setEquippedWeapon(axe);
    }
    /**
     * It will equipped the this player with a bow.
     */
    @Override
    public void equipWithBow(Bow bow) {
        setEquippedWeapon(bow);
    }
    /**
     * It wont equipped the this player with a knife so it will put a null.
     */
    @Override
    public void equipWithKnife(Knife knife) {
        setEquippedWeapon(null);
    }
    /**
     * It wont equipped the this player with a staff so it will put a null.
     */
    @Override
    public void equipWithStaff(Staff staff) {
        setEquippedWeapon(null);
    }
    /**
     * It wont equipped the this player with a sword so it will put a null.
     */
    @Override
    public void equipWithSword(Sword sword) {
        setEquippedWeapon(null);
    }
}