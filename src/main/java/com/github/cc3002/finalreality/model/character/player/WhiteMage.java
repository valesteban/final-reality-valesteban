package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends MagicCharacter {
    public WhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull String name, final String characterClass, int mana) {
        super(turnsQueue, name, "WhiteMage",mana);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WhiteMage)) {
            return false;
        }
        final PlayerCharacter that = (PlayerCharacter) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName());
    }
}