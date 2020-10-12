package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Engineer  extends AbstractPlayerCharacter {
    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name) {
        super(turnsQueue, name, "Engineer");
    }

}