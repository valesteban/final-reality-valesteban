package com.github.cc3002.finalreality.model.character.playerCharacter;

import com.github.cc3002.finalreality.model.character.PayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WhiteMageTest extends PayerCharacterTest {


    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    void constructorTestWhiteMage(){
        constructorTest( new WhiteMage(turns,"nameWhiteMage",10,10),
                whiteMageTest,
                new WhiteMage(turns,"name2WhiteMage",10,10),
                new WhiteMage(turns,"nameWhiteMage",10,11),
                enemyTest,
                new WhiteMage(turns,"nameWhiteMage",11,10));
    }
    @Test
    void equipWhiteMageTest(){
        //estos no equipan a el whiteMage
        equipNullTest(whiteMageTest,swordTest);
        equipNullTest(whiteMageTest,axeTest);
        equipNullTest(whiteMageTest,knifeTest);
        equipNullTest(whiteMageTest,bowTest);

        //estos si equipan al whiteMage
        equipTest(whiteMageTest,staffTest );
    }
    @Test
    void waitTurnWhiteMageTest() {
        Assertions.assertTrue(turns.isEmpty());
        WaitTurnTest(whiteMageTest,staffTest,0);
    }

    @Test
    void attackWhiteMageTest() {
        //ataca a un enemigo
        PlayerAttack(whiteMageTest, enemyTest, staffTest);
        whiteMageTest.setHealthPoints(0);
        PlayerAttack(whiteMageTest, enemyTest, staffTest);

        //ataca a otro player
        PlayerAttack(whiteMageTest, thiefTest, staffTest);
        whiteMageTest.setHealthPoints(0);
        PlayerAttack(whiteMageTest, thiefTest, staffTest);
    }
}
