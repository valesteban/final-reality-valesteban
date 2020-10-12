package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MagicCharactersTest {
    private static final String ENEMY_NAME = "juan";
    private WhiteMage whitetest;
    private BlackMage blackTest;

    protected BlockingQueue<ICharacter> turns;
    protected List<ICharacter> testCharacters;
    protected IWeapon testWeapon;

    @BeforeEach
    void setUp(){
        turns = new LinkedBlockingQueue<>();
        testWeapon = new Axe("Test", 15, 10);
        testCharacters = new ArrayList<>();
        whitetest = new WhiteMage(turns,"gandalf",11);
        testCharacters.add(whitetest);
        blackTest = new BlackMage(turns,"dumblurdoor",2);
        testCharacters.add(blackTest);
        testCharacters.add(new Enemy(turns,ENEMY_NAME,11));
    }


    @Test
    void constructor2(){
        assertEquals(new WhiteMage(turns,"gandalf",11), testCharacters.get(0));
        assertEquals(new WhiteMage(turns,"gandalf",11).hashCode(), testCharacters.get(0).hashCode());
        assertNotEquals(new WhiteMage(turns,"gndalf",7), testCharacters.get(0));
        assertNotEquals(testCharacters.get(0), new Thief(turns,"ron"));

        assertEquals(new BlackMage(turns,"dumblurdoor",2), testCharacters.get(1));
        assertEquals(new BlackMage(turns,"dumblurdoor",2).hashCode(), testCharacters.get(1).hashCode());
        assertNotEquals(new BlackMage(turns,"nomismodumburdoor",3), testCharacters.get(1));
        assertNotEquals(testCharacters.get(1), new Thief(turns,"ron"));
    }
}
