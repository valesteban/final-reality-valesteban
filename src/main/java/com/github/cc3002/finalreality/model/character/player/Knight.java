package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {
    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue,
                  @NotNull String name, String characterClass) {
        super(turnsQueue, name, "Knight");
    }
}