package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Engineer  extends PlayerCharacter {
    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, String characterClass) {
        super(turnsQueue, name, "Engineer");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engineer)) {
            return false;
        }
        final PlayerCharacter that = (PlayerCharacter) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }
}