package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class MagicCharactersTest {
    private WhiteMage whitetest;
    private BlackMage blackTest;
    private Enemy enemyTest;
    private Engineer engineerTest;

    protected BlockingQueue<ICharacter> turns;

    protected IWeapon testWeapon;
    protected Staff testWeaponStaff;

    @BeforeEach
    void setUp(){
        turns = new LinkedBlockingQueue<>();
        testWeapon = new Axe("Test", 15, 10);

        whitetest = new WhiteMage(turns,"gandalf",11,1);
        blackTest = new BlackMage(turns,"dumblurdoor",2,1);
        enemyTest = new Enemy(turns,"naem",11,0,2);
        engineerTest = new Engineer(turns,"namee",1);
        testWeaponStaff = new Staff("Test", 15, 10,1);

    }


    @Test
    void constructorTest(){

        assertEquals(new WhiteMage(turns,"gandalf",11,1).hashCode(), whitetest.hashCode());
        assertNotEquals(new WhiteMage(turns,"gndalf",7,1), whitetest);
        assertNotEquals(whitetest, new Thief(turns,"ron",1));

        assertEquals(new BlackMage(turns,"dumblurdoor",2,1), blackTest);
        assertEquals(new BlackMage(turns,"dumblurdoor",2,1).hashCode(), blackTest.hashCode());
        assertNotEquals(new BlackMage(turns,"nomismodumburdoor",3,1), blackTest);
        assertNotEquals(blackTest, new Thief(turns,"ron",1));


        assertNotEquals(whitetest,new WhiteMage(turns,"gandalf",88,1));
        assertNotEquals(blackTest, new BlackMage(turns,"dumblurdoor",1000,1));
    }

    @Test
    void attackTestM(){
        whitetest.equipWithStaff(testWeaponStaff);
        blackTest.equipWithStaff(testWeaponStaff);
        assertEquals(100, enemyTest.getHealthPoints());
        whitetest.attack(enemyTest);
        assertEquals(85,enemyTest.getHealthPoints());
        blackTest.attack(enemyTest);
        assertEquals(70,enemyTest.getHealthPoints());
        blackTest.attack(whitetest);
        assertEquals(86,whitetest.getHealthPoints());
        whitetest.attack(blackTest);
        assertEquals(86,blackTest.getHealthPoints());
    }

}
