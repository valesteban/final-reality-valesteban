package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class StaffTest {
    private static final String STAFF_NAME = "test name staff";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;
    protected static final int MAGIC_DAMAGE = 10;
    protected BlockingQueue<ICharacter> turns;

    private IWeapon testStaff;

    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME,DAMAGE,WEIGHT,MAGIC_DAMAGE);
        turns = new LinkedBlockingQueue<>();
    }
    @Test
    void constructorTest() {
        var expectedStaff = new Staff(STAFF_NAME,DAMAGE,WEIGHT,MAGIC_DAMAGE);

        assertEquals(expectedStaff, testStaff );
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());

        assertNotEquals(new Staff("nn",DAMAGE,WEIGHT,MAGIC_DAMAGE),testStaff);
        assertNotEquals(new Staff(STAFF_NAME,1111,WEIGHT,MAGIC_DAMAGE),testStaff);
        assertNotEquals(new Staff(STAFF_NAME,DAMAGE,77,MAGIC_DAMAGE),testStaff);
        assertNotEquals(testStaff,new Knife(STAFF_NAME,DAMAGE,WEIGHT));
        assertNotEquals(new Enemy(turns,"juan",22,1),testStaff);


    }
}

