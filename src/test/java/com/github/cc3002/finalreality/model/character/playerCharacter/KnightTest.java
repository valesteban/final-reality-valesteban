package com.github.cc3002.finalreality.model.character.playerCharacter;
import com.github.cc3002.finalreality.model.character.PayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class KnightTest extends PayerCharacterTest {
    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    void constructorTestKnight(){
        constructorTest(new Knight(turns,"nameKnight",10),
                knightTest,
                new Knight(turns,"name2Knight",10),
                new Knight(turns,"nameKnight",11),
                engineerTest,
                new Knight(turns,"nameKnight",11));
    }
    @Test
    void equipKnightTest(){
        //estos si equipan a el caballero
        equipTest(knightTest,swordTest);
        equipTest(knightTest,axeTest);
        equipTest(knightTest,knifeTest);

        //estos no equipan al caballero
        equipNullTest(knightTest, staffTest);
        equipNullTest(knightTest,bowTest );
    }

    @Test
    void waitTurnKnightTest() {
        Assertions.assertTrue(turns.isEmpty());
        WaitTurnTest(knightTest,swordTest,0);
        WaitTurnTest(knightTest,axeTest,1);
        WaitTurnTest(knightTest,knifeTest,2);
    }

    @Test
    void attackKnightTest() {
        //ataca a enemigo
        attackWith(knightTest, enemyTest, knifeTest);
        knightTest.setHealthPoints(0);
        attackWith(knightTest, enemyTest, knifeTest);

        //ataca a otro player
        attackWith(knightTest, engineerTest, axeTest);
        knightTest.setHealthPoints(0);
        attackWith(knightTest, engineerTest, axeTest);
    }

}
