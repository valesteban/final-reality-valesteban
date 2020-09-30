package com.github.cc3002.finalreality.model.character.player.NonMagic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends NonMagicPlayer{
    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue,
                  @NotNull String name, int healthPoints){
        super(turnsQueue, name ,healthPoints);
        this.characterClass ="Knight";

    }

}
