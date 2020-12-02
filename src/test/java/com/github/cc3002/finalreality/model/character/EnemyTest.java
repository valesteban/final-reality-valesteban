package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemyTest extends AbstractCharacterTest{


    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    void constructTest(){
        constructorTest(new Enemy(turns,"nameEnemy",10,10,10),
                enemyTest,
                new Enemy(turns,"name2Enemy",10,10,10),
                new Enemy(turns,"nameEnemy",10,11,10),
                thiefTest,
                new Enemy(turns,"nameEnemy",10,10,11));
    }

    @Test
    void waitTurnTest(){
        Assertions.assertTrue(turns.isEmpty());
        enemyTest.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(800);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(500);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(enemyTest, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void enemyAttack(){
        //enemyTest ataca enemyTest2
        Enemy enemyTest2 = new Enemy(turns,"nameEnemy2",10,2,20);
        assertEquals(100,enemyTest2.getHealthPoints());
        while (enemyTest2.getHealthPoints()!=0){
            enemyTest.attack(enemyTest2);
        }
        enemyTest.attack(enemyTest2);
        assertEquals(0,enemyTest2.getHealthPoints());

       // enemyTest2 no tiene vidas y por tanto no puede atacar
        enemyTest2.attack(enemyTest);
        assertEquals(100,enemyTest.getHealthPoints());

        //ataca a un player
        Thief thiefTest2 = new Thief(turns,"nameThief2",5);
        assertEquals(100,thiefTest2.getHealthPoints());
        enemyTest.attack(thiefTest2);
        while (thiefTest2.getHealthPoints()!=0){
            enemyTest.attack(thiefTest2);
        }
        assertEquals(0,thiefTest2.getHealthPoints());
    }


}
