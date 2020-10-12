package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
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
    private Engineer engTest;
    private Enemy teste ;

    protected BlockingQueue<ICharacter> turns;
    protected List<ICharacter> testCharacters;
    protected IWeapon testWeapon;
    protected IWeapon testWeapon2;

    @BeforeEach

    void setUp(){
        turns = new LinkedBlockingQueue<>();
        testWeapon = new Axe("Test", 15, 10);
        testWeapon2 = new Staff("dibidibadidibum",12,1,100);

        testCharacters = new ArrayList<>();

        teste = new Enemy(turns,"name1",11);
        testCharacters.add(teste);

        engTest = new Engineer(turns,"name2");
        testCharacters.add(engTest);

        blackTest = new BlackMage(turns,"name3",11);
        testCharacters.add( blackTest);
    }
    @Test
    void equipWeaponTest() {
        assertNull(blackTest.getEquippedWeapon());
        blackTest.equip(testWeapon2);
        assertEquals(testWeapon2, blackTest.getEquippedWeapon());

        assertNull(engTest.getEquippedWeapon());
        engTest.equip(testWeapon);
        assertEquals(testWeapon, engTest.getEquippedWeapon());
    }
    @Test
    void testwaitTyrn(){
            Assertions.assertTrue(turns.isEmpty());
            blackTest.equip(testWeapon);
          //  tryToEquip(testCharacters.get(0));
            testCharacters.get(0).waitTurn();
            try {
                // Thread.sleep is not accurate so this values may be changed to adjust the
                // acceptable error margin.
                // We're testing that the character waits approximately 1 second.
                Thread.sleep(900);
                Assertions.assertEquals(0, turns.size());
                Thread.sleep(200);
                Assertions.assertEquals(1, turns.size());
                Assertions.assertEquals(testCharacters.get(0), turns.peek());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




}