package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.assertNull;


public class AbstractPlayerCharacterTest {
    private BlackMage blackTest;
    private Engineer engineerTest;
    private Thief thiefTest;
    private WhiteMage whiteTest;
    private Knight knightTest;

    protected BlockingQueue<ICharacter> turns;
    protected List<IPlayerCharacter> testCharacters;
    protected IWeapon testWeaponAxe;
    protected IWeapon testWeaponBow;
    protected IWeapon testWeaponKnife;
    protected IWeapon testWeaponStaff;
    protected IWeapon testWeaponSword;

    protected IWeapon testWeapon2;

    @BeforeEach
    void setUp() {
        turns = new LinkedBlockingQueue<>();
        testWeaponAxe = new Axe("Test", 15, 10);
        testWeaponBow = new Bow("Test", 15, 10);
        testWeaponKnife = new Knife("nameKnife",12,12);
        testWeaponStaff = new Staff("nameStaff",11,11,22);
        testWeaponSword = new Sword("nameSword",13,13);

        testWeapon2 = new Staff("dibidibadidibum", 12, 1, 100);

        testCharacters = new ArrayList<>();


        engineerTest = new Engineer(turns, "name2",1);
        testCharacters.add(engineerTest);
        blackTest = new BlackMage(turns, "name3", 11,1);
        testCharacters.add(blackTest);
        whiteTest = new WhiteMage(turns,"nameMageWhite",12,1);
        testCharacters.add(whiteTest);
        knightTest = new Knight(turns,"nameKnight",1);
        testCharacters.add(knightTest);
        thiefTest = new Thief(turns,"nameThief",1);
        testCharacters.add(thiefTest);
    }

    @Test
    void equipWeaponTest() {

        assertNull(knightTest.getEquippedWeapon());
        knightTest.equip(testWeaponSword);
        assertEquals(testWeaponSword,knightTest.getEquippedWeapon());
        knightTest.equip(testWeaponAxe);
        assertEquals(testWeaponAxe,knightTest.getEquippedWeapon());
        knightTest.equip(testWeaponKnife);
        assertEquals(testWeaponKnife,knightTest.getEquippedWeapon());
        knightTest.equip(testWeaponStaff);
        assertEquals(null,knightTest.getEquippedWeapon());
        knightTest.equip(testWeaponBow);
        assertEquals(null,knightTest.getEquippedWeapon());

        assertNull(engineerTest.getEquippedWeapon());
        engineerTest.equip(testWeaponSword);
        assertEquals(null,engineerTest.getEquippedWeapon());
        engineerTest.equip(testWeaponAxe);
        assertEquals(testWeaponAxe,engineerTest.getEquippedWeapon());
        engineerTest.equip(testWeaponKnife);
        assertEquals(null,engineerTest.getEquippedWeapon());
        engineerTest.equip(testWeaponStaff);
        assertEquals(null,engineerTest.getEquippedWeapon());
        engineerTest.equip(testWeaponBow);
        assertEquals(testWeaponBow,engineerTest.getEquippedWeapon());



        assertNull(thiefTest.getEquippedWeapon());
        thiefTest.equip(testWeaponSword);
        assertEquals(testWeaponSword,thiefTest.getEquippedWeapon());
        thiefTest.equip(testWeaponAxe);
        assertEquals(null,thiefTest.getEquippedWeapon());
        thiefTest.equip(testWeaponKnife);
        assertEquals(null,thiefTest.getEquippedWeapon());
        thiefTest.equip(testWeaponStaff);
        assertEquals(testWeaponStaff,thiefTest.getEquippedWeapon());
        thiefTest.equip(testWeaponBow);
        assertEquals(testWeaponBow,thiefTest.getEquippedWeapon());

        assertNull(blackTest.getEquippedWeapon());
        blackTest.equip(testWeaponSword);
        assertEquals(null,blackTest.getEquippedWeapon());
        blackTest.equip(testWeaponAxe);
        assertEquals(null,blackTest.getEquippedWeapon());
        blackTest.equip(testWeaponKnife);
        assertEquals(testWeaponKnife,blackTest.getEquippedWeapon());
        blackTest.equip(testWeaponStaff);
        assertEquals(testWeaponStaff,blackTest.getEquippedWeapon());
        blackTest.equip(testWeaponBow);
        assertEquals(null,blackTest.getEquippedWeapon());


        assertNull(whiteTest.getEquippedWeapon());
        whiteTest.equip(testWeaponSword);
        assertEquals(null,whiteTest.getEquippedWeapon());
        whiteTest.equip(testWeaponAxe);
        assertEquals(null,whiteTest.getEquippedWeapon());
        whiteTest.equip(testWeaponKnife);
        assertEquals(null,whiteTest.getEquippedWeapon());
        whiteTest.equip(testWeaponStaff);
        assertEquals(testWeaponStaff,whiteTest.getEquippedWeapon());
        whiteTest.equip(testWeaponBow);
        assertEquals(null,whiteTest.getEquippedWeapon());


        thiefTest.attack(whiteTest);
        while (whiteTest.getHealthPoints() != 0 ){
            thiefTest.attack(whiteTest);
        }
       assertEquals(0,whiteTest.getHealthPoints());
        whiteTest.equip(testWeaponStaff);
        assertEquals(null,whiteTest.getEquippedWeapon());
        whiteTest.attack(blackTest);

        assertEquals(100,blackTest.getHealthPoints());
        knightTest.equip(testWeaponKnife);
        while (blackTest.getHealthPoints() != 0 ){
            knightTest.attack(blackTest);
        }
        assertEquals(0,blackTest.getHealthPoints());
        knightTest.attack(blackTest);
        assertEquals(0,blackTest.getHealthPoints());
    }

    @Test
    void testWaitTurn() {
        Assertions.assertTrue(turns.isEmpty());
        testCharacters.get(0).equip(testWeaponAxe);

        // tryToEquip(testCharacters.get(0));
        testCharacters.get(0).waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(500);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testCharacters.get(0), turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }}


