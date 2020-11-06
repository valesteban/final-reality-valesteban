package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PayerCharacterTest extends AbstractCharacterTest {
    public Axe axeTest;
    public Bow bowTest;
    public Knife knifeTest;
    public Staff staffTest;
    public Sword swordTest;

    public void basicSetUp(){
        super.basicSetUp();
        axeTest = new Axe("nameAxe",15,13);
        bowTest = new Bow("nameBow",15,13);
        knifeTest = new Knife("nameKnife",15,13);
        staffTest= new Staff("nameStaff",15,15,6);
        swordTest = new Sword("nameSword",15,13);
    }


    public void equipNullTest(IPlayerCharacter character, IWeapon weapon){
        character.equip(weapon);
        assertNull(character.getEquippedWeapon());
    }
    public void equipTest(IPlayerCharacter character, IWeapon weapon){
        character.equip(weapon);
        assertEquals(weapon,character.getEquippedWeapon());
    }

    public void WaitTurnTest(IPlayerCharacter character, IWeapon weapon,int n){
            //Assertions.assertTrue(turns.isEmpty());
            character.equip(weapon);
            character.waitTurn();

            try {
                // Thread.sleep is not accurate so this values may be changed to adjust the
                // acceptable error margin.
                // We're testing that the character waits approximately 1 second.
                Thread.sleep(500);
                Assertions.assertEquals(n, turns.size());
                Thread.sleep(900);
                Assertions.assertEquals(n+1, turns.size());
                Assertions.assertEquals(character, turns.peek());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public void attackWith(IPlayerCharacter character,ICharacter character2, IWeapon weapon){
        character.equip(weapon);
        if (character.getHealthPoints() == 0){
            assertNull(character.getEquippedWeapon());
        }
        else {
            while (character2.getHealthPoints() != 0){
                character.attack(character2);
            }
            assertEquals(0,character2.getHealthPoints());
            character.attack(character2);
            assertEquals(0,character2.getHealthPoints());
        }


    }


}
