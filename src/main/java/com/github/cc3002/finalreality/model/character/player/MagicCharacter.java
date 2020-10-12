package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class MagicCharacter extends AbstractPlayerCharacter {
    protected int mana;

    public MagicCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                          @NotNull String name, final String characterClass, int mana) {
        super(turnsQueue, name, characterClass);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlackMage)) {
            return false;
        }
        final MagicCharacter that = (MagicCharacter) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName()) &&
                getMana() == that.getMana();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(),getMana());
    }


}