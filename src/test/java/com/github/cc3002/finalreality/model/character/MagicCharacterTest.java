package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MagicCharacterTest extends PayerCharacterTest{

    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    void constrTest(){
        //blackMage constructor test
        constructorTest( new BlackMage(turns,"nameBlackMage",10,10),
                blackMageTest,
                new BlackMage(turns,"name2BlackMage",10,10),
                new BlackMage(turns,"nameBlackMage",10,11),
                enemyTest,
                new BlackMage(turns,"nameBlackMage",11,10));

        //whiteMage constructor Test
        constructorTest( new WhiteMage(turns,"nameWhiteMage",10,10),
                whiteMageTest,
                new WhiteMage(turns,"name2WhiteMage",10,10),
                new WhiteMage(turns,"nameWhiteMage",10,11),
                enemyTest,
                new WhiteMage(turns,"nameWhiteMage",11,10));

    }

}
