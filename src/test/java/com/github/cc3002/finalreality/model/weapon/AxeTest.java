package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class AxeTest {
    private static final String AXE_NAME = "bow_name";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;
    protected BlockingQueue<ICharacter> turns;

    private IWeapon testAxe;

    @BeforeEach
    void setUp() {
        turns = new LinkedBlockingQueue<>();
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);

    }

    @Test
    void constructorTest(){
        var expectedAxe = new Axe(AXE_NAME,DAMAGE,WEIGHT);

        assertEquals(expectedAxe,testAxe);
        assertEquals(expectedAxe.hashCode(),testAxe.hashCode());

        assertNotEquals(new Axe("ddd",DAMAGE,WEIGHT),testAxe);
        assertNotEquals(new Axe(AXE_NAME,99,WEIGHT),testAxe);
        assertNotEquals(new Axe(AXE_NAME,DAMAGE,100),testAxe);
        assertNotEquals(new Knife(AXE_NAME,DAMAGE,WEIGHT),testAxe);
        assertNotSame(new Enemy(turns,"name",22),testAxe);


    }
}
