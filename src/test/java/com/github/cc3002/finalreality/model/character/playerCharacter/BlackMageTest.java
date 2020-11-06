package com.github.cc3002.finalreality.model.character.playerCharacter;

import com.github.cc3002.finalreality.model.character.PayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlackMageTest extends PayerCharacterTest {


    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    void constructorTestKnight(){
        constructorTest( new BlackMage(turns,"nameBlackMage",10,10),
                blackMageTest,
                new BlackMage(turns,"name2BlackMage",10,10),
                new BlackMage(turns,"nameBlackMage",10,11),
                enemyTest,
                new BlackMage(turns,"nameBlackMage",11,10));
    }

    @Test
    void equipBlackMageTest(){
        //estos no equipan a el whiteMage
        equipNullTest(blackMageTest,swordTest);
        equipNullTest(blackMageTest,axeTest);
        equipNullTest(blackMageTest,bowTest);

        //estos si equipan al whiteMage
        equipTest(blackMageTest,staffTest );
        equipTest(blackMageTest,knifeTest);
    }

    @Test
    void waitTurnKnightTest() {
        Assertions.assertTrue(turns.isEmpty());
        WaitTurnTest(blackMageTest,staffTest,0);
        WaitTurnTest(blackMageTest,knifeTest,1);
    }

    @Test
    void attackBlackMageTest() {
        //ataca a un enemigo
        attackWith(blackMageTest, enemyTest, staffTest);
        blackMageTest.setHealthPoints(0);
        attackWith(blackMageTest, enemyTest, staffTest);

        //ataca a otro player
        attackWith(blackMageTest, knightTest, knifeTest);
        blackMageTest.setHealthPoints(0);
        attackWith(blackMageTest, knightTest, knifeTest);


    }
    }
