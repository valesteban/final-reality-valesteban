package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemyTest {
    private static final String ENEMY_NAME = "juan";
    private Enemy teste ;

    protected BlockingQueue<ICharacter> turns;
    protected List<ICharacter> testCharacters;
    protected IWeapon testWeapon;

    @BeforeEach
    void setUp(){
        turns = new LinkedBlockingQueue<>();
        testWeapon = new Axe("Test", 15, 10);
        testCharacters = new ArrayList<>();
        teste = new Enemy(turns,ENEMY_NAME,11);
        testCharacters.add(new Enemy(turns,ENEMY_NAME,11));
    }

    @Test
    void constructor(){
        assertEquals(new Enemy(turns,ENEMY_NAME,11), testCharacters.get(0));
        assertEquals(new Enemy(turns,ENEMY_NAME,11).hashCode(), testCharacters.get(0).hashCode());
        assertNotEquals(new Enemy(turns,ENEMY_NAME,1), testCharacters.get(0));
        assertNotEquals(testCharacters.get(0), new Thief(turns,"ron"));
        assertNotEquals(new Enemy(turns,ENEMY_NAME,19), testCharacters.get(0));

    }
    @Test
    void waitTurnT(){
        Assertions.assertTrue(turns.isEmpty());
        teste.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(teste, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}






