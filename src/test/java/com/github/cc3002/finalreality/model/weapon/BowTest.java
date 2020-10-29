package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BowTest {
    private static final String BOW_NAME = "bow_name";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;
    protected BlockingQueue<ICharacter> turns;

    private IWeapon testBow;

    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        turns = new LinkedBlockingQueue<>();
    }

    @Test
    void constructorTest(){
        var expectedBow = new Bow(BOW_NAME,DAMAGE,WEIGHT);

        assertEquals(expectedBow,testBow);
        assertEquals(expectedBow.hashCode(),testBow.hashCode());

        assertNotEquals(new Bow("name",DAMAGE,WEIGHT),testBow);
        assertNotEquals(new Bow(BOW_NAME,44,WEIGHT),testBow);
        assertNotEquals(new Bow(BOW_NAME,DAMAGE,33),testBow);
        assertNotEquals(new Knife(BOW_NAME,DAMAGE,WEIGHT),testBow);
        assertNotEquals(new Enemy(turns,"name",22,1,2),testBow);

    }

}
