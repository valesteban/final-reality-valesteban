package com.github.cc3002.finalreality.model.weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest {
    private static final String AXE_NAME = "bow_name";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;

    private IWeapon testAxe;

    @BeforeEach
    void setUp() {
        testAxe = new Bow(AXE_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest(){
        var expectedBow = new Bow(AXE_NAME,DAMAGE,WEIGHT);

        assertEquals(expectedBow,testAxe);
        assertEquals(expectedBow.hashCode(),testAxe.hashCode());
    }
}
