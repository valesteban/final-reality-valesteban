package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
/**
 * A class that creates a character of type WhiteMage
 *
 * @author Valentina Esteban
 */
public class WhiteMage extends MagicCharacter {
    /**
     * Creates a new WhiteMage with a name, mana  and the queue with the characters ready to
     * play..
     *
     */
    public WhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull String name, int mana) {
        super(turnsQueue, name, "WhiteMage",mana);
    }

    @Override
    public void equipWithKnife(Knife knife) {
        setEquippedWeapon(null);
    }

}