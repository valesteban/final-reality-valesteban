package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PayerCharacterTest extends AbstractCharacterTest {


    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }


    public void equipTest(IPlayerCharacter character , Axe axeTest, Bow bowTest,
                          Knife knifeTest, Staff staffTest){
        character.equip(axeTest);
        character.equip(bowTest);
        character.equip(knifeTest);
        character.equip(staffTest);
    }

    @Test
    void constructTest(){
        //contructor de thief
        constructorTest( new Thief(turns,"nameThief",10),
                thiefTest,
                new Thief(turns,"name2Thief",10),
                new Thief(turns,"nameThief",11),
                enemyTest,
                new Thief(turns,"nameThief",11));
        //constructor de engineer
        constructorTest(new Engineer(turns,"nameEngineer",10),
                engineerTest,
                new Engineer(turns,"name2Engineer",10),
                new Engineer(turns,"nameEngineer",11),
                thiefTest,
                new Engineer(turns,"nameEngineer",11));

        //constructor de knight
        constructorTest(new Knight(turns,"nameKnight",10),
                knightTest,
                new Knight(turns,"name2Knight",10),
                new Knight(turns,"nameKnight",11),
                engineerTest,
                new Knight(turns,"nameKnight",11));
}}
