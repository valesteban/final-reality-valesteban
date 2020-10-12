package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordTest {

    private static final String SWORD_NAME = "sword_name";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;

    private IWeapon testSword;



    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest(){
        var expectedBow = new Sword(SWORD_NAME,DAMAGE,WEIGHT);

        assertEquals(expectedBow,testSword);
        assertEquals(expectedBow.hashCode(),testSword.hashCode());

    }

}
