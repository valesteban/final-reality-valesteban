package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SwordTest {

    private static final String SWORD_NAME = "sword_name";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;
    protected BlockingQueue<ICharacter> turns;

    private IWeapon testSword;



    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        turns = new LinkedBlockingQueue<>();
    }

    @Test
    void constructorTest(){
        var expectedBow = new Sword(SWORD_NAME,DAMAGE,WEIGHT);

        assertEquals(expectedBow,testSword);
        assertEquals(expectedBow.hashCode(),testSword.hashCode());

        assertNotEquals(new Sword("nana",DAMAGE,WEIGHT),testSword);
        assertNotEquals(new Sword(SWORD_NAME,66,WEIGHT) ,testSword);
        assertNotEquals(new Sword(SWORD_NAME,DAMAGE,88), testSword);
        assertNotEquals(new Axe(SWORD_NAME,DAMAGE,WEIGHT),testSword);
        assertNotEquals(new Enemy(turns,"name",22),testSword);

    }

}
