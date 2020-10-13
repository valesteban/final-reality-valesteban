package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MagicCharactersTest {
    private WhiteMage whitetest;
    private BlackMage blackTest;

    protected BlockingQueue<ICharacter> turns;

    protected IWeapon testWeapon;

    @BeforeEach
    void setUp(){
        turns = new LinkedBlockingQueue<>();
        testWeapon = new Axe("Test", 15, 10);

        whitetest = new WhiteMage(turns,"gandalf",11);

        blackTest = new BlackMage(turns,"dumblurdoor",2);


    }


    @Test
    void constructor2(){

        assertEquals(new WhiteMage(turns,"gandalf",11).hashCode(), whitetest.hashCode());
        assertNotEquals(new WhiteMage(turns,"gndalf",7), whitetest);
        assertNotEquals(whitetest, new Thief(turns,"ron"));

        assertEquals(new BlackMage(turns,"dumblurdoor",2), blackTest);
        assertEquals(new BlackMage(turns,"dumblurdoor",2).hashCode(), blackTest.hashCode());
        assertNotEquals(new BlackMage(turns,"nomismodumburdoor",3), blackTest);
        assertNotEquals(blackTest, new Thief(turns,"ron"));


        assertNotEquals(whitetest,new WhiteMage(turns,"gandalf",88));
        assertNotEquals(blackTest, new BlackMage(turns,"dumblurdoor",1000));
    }
}
