package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends PlayerCharacter {
    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue,
                 @NotNull String name, String characterClass) {
        super(turnsQueue, name, "Thief");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thief)) {
            return false;
        }
        final PlayerCharacter that = (PlayerCharacter) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }
}