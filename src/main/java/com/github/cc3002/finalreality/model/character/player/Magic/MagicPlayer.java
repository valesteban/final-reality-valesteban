package com.github.cc3002.finalreality.model.character.player.Magic;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class MagicPlayer extends PlayerCharacter {
    protected int mana;
    public MagicPlayer(@NotNull BlockingQueue<ICharacter> turnsQueue,
                          @NotNull String name, int healthPoints,int mana){
        super(turnsQueue, name ,healthPoints);
        this.mana = mana;
    }

    protected int getMana(){
        return mana;
    }
}
