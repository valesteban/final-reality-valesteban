package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
/**
 * A class that creates a character of type BlackMage
 *
 * @author Valentina Esteban
 */
public class BlackMage extends MagicCharacter {
    /**
     * Creates a new BlackMage with a name, mana  and the queue with the characters ready to
     * play..
     *
     */
    public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull String name ,int mana){
        super(turnsQueue,name,"BlackMage",mana);
    }
}
