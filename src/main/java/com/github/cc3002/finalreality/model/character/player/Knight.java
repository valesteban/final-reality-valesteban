package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
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
                  @NotNull String name) {
        super(turnsQueue, name, "Knight");
    }

}