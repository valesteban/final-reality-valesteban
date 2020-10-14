package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class MagicCharacter extends AbstractPlayerCharacter {
    protected int mana;
    /**
     * Creates a new MagicCharacter with a name ,mana ,the queue and the class of mage that this is.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param characterClass
     *     the class of mage
     * @param mana
     *     mana of the magicCharacter
     */
    public MagicCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                          @NotNull String name, final String characterClass, int mana) {
        super(turnsQueue, name, characterClass);
        this.mana = mana;
    }
    /**
     * returns this MagicCharacter´s mana.
     */
    public int getMana() {
        return mana;
    }
    /**
     * Compare this MagicCharacter with the given Object o.
     */
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
    /**
     * gives a hash code to this MagicCharacter.
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(),getMana(),getName());
    }
}