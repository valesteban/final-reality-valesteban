package com.github.cc3002.finalreality.model.weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowTest {
    private static final String BOW_NAME = "bow_name";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;

    private IWeapon testBow;

    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest(){
        var expectedBow = new Bow(BOW_NAME,DAMAGE,WEIGHT);

        assertEquals(expectedBow,testBow);
        assertEquals(expectedBow.hashCode(),testBow.hashCode());

    }

}
