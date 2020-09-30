package com.github.cc3002.finalreality.model.character.player.NonMagic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends NonMagicPlayer {
    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, int healthPoints){
        super(turnsQueue, name ,healthPoints);
        this.characterClass ="Thief";
    }
}
