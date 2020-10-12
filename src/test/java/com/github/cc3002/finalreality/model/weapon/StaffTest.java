package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class StaffTest {
    private static final String STAFF_NAME = "test name staff";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;
    protected static final int MAGIC_DAMAGE = 10;

    private IWeapon testStaff;

    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME,DAMAGE,WEIGHT,MAGIC_DAMAGE);
    }
    @Test
    void constructorTest() {
        var expectedStaff = new Staff(STAFF_NAME,DAMAGE,WEIGHT,MAGIC_DAMAGE);


        assertEquals(expectedStaff, testStaff );
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
        //assertNotEquals();

    }
}

