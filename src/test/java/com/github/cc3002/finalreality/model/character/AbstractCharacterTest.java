package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AbstractCharacterTest {
    public BlockingQueue<ICharacter> turns;
    public Enemy enemyTest;
    public Thief thiefTest;
    public Knight knightTest;
    public Engineer engineerTest;
    public BlackMage blackMageTest;
    public WhiteMage whiteMageTest;
    public IWeapon testWeapon;

    protected void constructorTest(ICharacter expectedCharacter,
                                   ICharacter testCharacter,
                                   ICharacter sameClassDifferentName,
                                   ICharacter sameClassDifferentProtection,
                                   ICharacter differentClass,
                                   ICharacter different) {

        assertEquals(expectedCharacter, testCharacter);
        assertEquals(expectedCharacter.hashCode(), testCharacter.hashCode());
        assertNotEquals(testCharacter, sameClassDifferentName);
        assertNotEquals(testCharacter, sameClassDifferentProtection);
        assertNotEquals(testCharacter, different);
        assertNotEquals(testCharacter, differentClass);
    }


    public void basicSetUp() {
        turns = new LinkedBlockingQueue<>();
        enemyTest = new Enemy(turns, "nameEnemy", 10, 10, 10);
        thiefTest = new Thief(turns, "nameThief", 10);
        knightTest = new Knight(turns, "nameKnight", 10);
        engineerTest = new Engineer(turns, "nameEngineer", 10);
        blackMageTest = new BlackMage(turns, "nameBlackMage", 10, 10);
        whiteMageTest = new WhiteMage(turns, "nameWhiteMage", 10, 10);
    }
}
