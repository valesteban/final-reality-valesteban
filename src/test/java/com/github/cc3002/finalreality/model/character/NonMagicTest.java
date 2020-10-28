package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NonMagicTest {

    private static final String ENEMY_NAME = "juan";
    private Engineer engTest;
    private Thief thiefTest;
    private Knight KnightTest;

    protected BlockingQueue<ICharacter> turns;
    protected List<ICharacter> testCharacters;
    protected IWeapon testWeapon;

    @BeforeEach
    void setUp(){
        turns = new LinkedBlockingQueue<>();
        testWeapon = new Axe("Test", 15, 10);
        testCharacters = new ArrayList<>();

        engTest = new Engineer(turns,"name1",2);
        testCharacters.add(engTest);

        thiefTest = new Thief(turns,"name2",3);
        testCharacters.add(thiefTest);

        KnightTest = new Knight(turns,"name3",1);
        testCharacters.add(KnightTest);

        testCharacters.add(new Enemy(turns,ENEMY_NAME,11,1,2));
    }


    @Test
    void constructorTest(){
        assertEquals(new Engineer(turns,"name1",2), testCharacters.get(0));
        assertEquals(new Engineer(turns,"name1",2).hashCode(), testCharacters.get(0).hashCode());
        assertNotEquals(new Engineer(turns,"noname1",2), testCharacters.get(0));
        assertNotEquals(testCharacters.get(0), new Enemy(turns,"ron",22,2,2));

        assertEquals( new Thief(turns,"name2",3), testCharacters.get(1));
        assertEquals( new Thief(turns,"name2",3).hashCode(), testCharacters.get(1).hashCode());
        assertNotEquals( new Thief(turns,"noname2",3), testCharacters.get(1));
        assertNotEquals(testCharacters.get(1), new Enemy(turns,"ron",22,3,2));

        assertEquals(new Knight(turns,"name3",1), testCharacters.get(2));
        assertEquals(new Knight(turns,"name3",1).hashCode(), testCharacters.get(2).hashCode());
        assertNotEquals(new Knight(turns,"noname3",1), testCharacters.get(2));
        assertNotEquals(testCharacters.get(2), new Enemy(turns,"ron",22,1,2));
    }
}


