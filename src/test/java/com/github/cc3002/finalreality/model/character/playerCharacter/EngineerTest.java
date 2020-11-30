package com.github.cc3002.finalreality.model.character.playerCharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.PayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerTest extends PayerCharacterTest {


    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    void constructorTestEngineer(){
        constructorTest(new Engineer(turns,"nameEngineer",10),
                engineerTest,
                new Engineer(turns,"name2Engineer",10),
                new Engineer(turns,"nameEngineer",11),
                thiefTest,
                new Engineer(turns,"nameEngineer",11));
    }
    @Test
    void equipEngineerTest(){
        //estoy no equipan a el ingeniero : queda nulo
        equipNullTest(engineerTest,swordTest);
        equipNullTest(engineerTest,knifeTest);
        equipNullTest(engineerTest,staffTest);

        //estoy si equipan al ingeniero
        equipTest(engineerTest, axeTest);
        equipTest(engineerTest,bowTest );
    }

    @Test
    void waitTurnEngineerTest() {
        Assertions.assertTrue(turns.isEmpty());
        WaitTurnTest(engineerTest,axeTest,0);
        WaitTurnTest(engineerTest,bowTest,1);
    }

    @Test
    void attackEngineerTest() {
        //ataca a un enemigo
        PlayerAttack(engineerTest, enemyTest, axeTest);
        engineerTest.setHealthPoints(0);
        PlayerAttack(engineerTest, enemyTest, axeTest);

        //ataca a otro player
        PlayerAttack(engineerTest, whiteMageTest, bowTest);
        engineerTest.setHealthPoints(0);
        PlayerAttack(engineerTest, whiteMageTest, bowTest);
    }


}
