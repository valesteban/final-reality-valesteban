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
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(enemyTest, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
