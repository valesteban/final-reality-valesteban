package com.github.cc3002.finalreality.model.character.playerCharacter;
import com.github.cc3002.finalreality.model.character.PayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThiefTest  extends PayerCharacterTest  {


    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    void constructorTestThief(){
        constructorTest( new Thief(turns,"nameThief",10),
                thiefTest,
                new Thief(turns,"name2Thief",10),
                new Thief(turns,"nameThief",11),
                enemyTest,
                new Thief(turns,"nameThief",11));
    }

    @Test
    void equipThiefTest() {
        //estos no equipan a el ladron
        equipNullTest(thiefTest, axeTest);
        equipNullTest(thiefTest, knifeTest);

        //estos si equipan al ladron
        equipTest(thiefTest, swordTest);
        equipTest(thiefTest, staffTest);
        equipTest(thiefTest, bowTest);

    }

    @Test
    void waitTurnThiefTest() {
        Assertions.assertTrue(turns.isEmpty());
        WaitTurnTest(thiefTest,swordTest,0);
        WaitTurnTest(thiefTest,staffTest,1);
        WaitTurnTest(thiefTest,bowTest,2);
    }

    @Test
    void attackThiefTest() {
        //ataca a un enemigo
        PlayerAttack(thiefTest, enemyTest, swordTest);
        thiefTest.setHealthPoints(0);
        PlayerAttack(thiefTest, enemyTest, swordTest);

        //ataca a otro player
        PlayerAttack(thiefTest, blackMageTest, staffTest);
        thiefTest.setHealthPoints(0);
        PlayerAttack(thiefTest, blackMageTest, staffTest);
    }

}
