package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.Controller.phases.InvalidActionException;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhasesTest extends AbstractPhaseTest {

    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    public void initialPhaseTest(){
        assertEquals("FirstCharacterPhase" ,controller.getNamePhase());
        //whe the button start Game is push it will change to the next phase
        controller.startPlaying();
        //the first character in the queue is an enemy then we move to the CharacterAttackPhase
        assertEquals("CharacterAttackPhase",controller.getNamePhase());
    }

    @Test
    public void EnemyAttackAndPullANdTimerTest(){
        assertEquals(5,controller.getEnemies().size());
        initialPhaseTest();
        assertEquals(controller.getNamePhase(),"CharacterAttackPhase");
        //whe the button start Game is push it will change to the next phase
        assertEquals(10,controller.getTurnsQueue().size()); //turns queue before is pull out
        controller.buttonNext();
        assertEquals(9,controller.getTurnsQueue().size()); //turns queue is taken out
        //we check that the enemy was pull of the queue and the put back

        try {
            Thread.sleep(1100);
            assertEquals(10,controller.getTurnsQueue().size());  //is back in the turns queue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //we check that some player was attacked
        for (int i = 0;i <= 4; i++ ){
            if (controller.getPlayerPosition(i).getHealthPoints() < 100){
                assertTrue(controller.getPlayerPosition(i).getHealthPoints()<100);

        assertEquals(controller.getNamePhase(),"FirstCharacterPhase");
            }
        }
    }

    @Test
    public void firstCharacterPhaseIsEnemy() throws InvalidActionException {
        EnemyAttackAndPullANdTimerTest();
        assertEquals(controller.getNamePhase(),"FirstCharacterPhase");

        controller.startPlaying();
        //we have an engineer first in the turn queue
        assertEquals("ChoseWeaponPhase",controller.getNamePhase());
        controller.thisWeaponButton(controller.getInventory().get(3)); //we equipped the player with an axe
        assertEquals(controller.getInventory().get(3),controller.getPlayerPosition(0).getEquippedWeapon());
        controller.buttonNext();
        assertEquals("SelectTargetPhase",controller.getNamePhase());
    }
    @Test
    public void selectTargetTest() throws InvalidActionException {
        firstCharacterPhaseIsEnemy();
        assertEquals("SelectTargetPhase",controller.getNamePhase());
       // seleccionamos al tercer e nemy
        //controller.getPhase().selectTarget(2);
        controller.selectingEnemy(2);
        assertEquals("nameEnemy3",controller.getPhase().getCharacter().getName());
        controller.buttonNext();
        assertEquals("CharacterAttackPhase",controller.getNamePhase());
        System.out.println(controller.showHpEnemies());
        System.out.println(controller.showHpPlayer());
        controller.buttonNext();
        //assertEquals(93,controller.getEnemyPosition(0).getHealthPoints());
        //controller.getPhase().setCharacter(controller.getEnemyPosition(0));
        //controller.buttonNext();
        //en este caso eligio atacar al primer enemigo
        //assertEquals(93,controller.getEnemyPosition(0).getHealthPoints());
        //System.out.println(controller.showHpEnemies());

        controller.equipPlayer(controller.getPlayerPosition(1),controller.getInventory().get(0));
        System.out.println(controller.getPlayerPosition(1));
        System.out.println(controller.getPlayerPosition(1).getEquippedWeapon());



    }
}


