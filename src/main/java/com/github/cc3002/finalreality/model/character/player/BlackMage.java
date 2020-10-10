package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends MagicCharacter {
    public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull String name, final String characterClass,int mana){
        super(turnsQueue,name,"BlackMage",mana);

    }
}
