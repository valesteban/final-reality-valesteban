package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnifeTest   {
    private static final String KNIFE_NAME = "test name staff";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;
    protected BlockingQueue<ICharacter> turns;

    private IWeapon testKnife;

    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME,DAMAGE,WEIGHT);
        turns = new LinkedBlockingQueue<>();
    }
    @Test
    void constructorTest() {
        var expectedKnife = new Knife(KNIFE_NAME,DAMAGE,WEIGHT);


        assertEquals(expectedKnife, testKnife );
        assertEquals(expectedKnife.hashCode(), testKnife.hashCode());

        assertNotEquals(new Knife("named",DAMAGE,WEIGHT),testKnife);
        assertNotEquals(new Knife(KNIFE_NAME,77,WEIGHT),testKnife);
        assertNotEquals(new Knife(KNIFE_NAME,DAMAGE,99),testKnife);
        assertNotEquals(new Axe(KNIFE_NAME,DAMAGE,WEIGHT),testKnife);
        assertNotEquals(new Enemy(turns,"name",22),testKnife);


    }
}
