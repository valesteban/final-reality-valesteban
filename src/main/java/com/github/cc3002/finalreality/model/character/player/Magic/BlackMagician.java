package com.github.cc3002.finalreality.model.character.player.Magic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class BlackMagician extends MagicPlayer {
    public BlackMagician(@NotNull BlockingQueue<ICharacter> turnsQueue,
                       @NotNull String name, int healthPoints, int mana){
        super(turnsQueue, name ,healthPoints,mana);
        this.characterClass = "BlackMagician";
    }
}
