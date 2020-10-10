package com.github.cc3002.finalreality.model.weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnifeTest {
    private static final String KNIFE_NAME = "test name staff";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;

    private IWeapon testKnife;

    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME,DAMAGE,WEIGHT);
    }
    @Test
    void constructorTest() {
        var expectedStaff = new Knife(KNIFE_NAME,DAMAGE,WEIGHT);


        assertEquals(expectedStaff, testKnife );
        assertEquals(expectedStaff.hashCode(), testKnife.hashCode());

    }
}
