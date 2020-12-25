package com.github.cc3002.finalreality.model.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PhasesTest extends AbstractPhaseTest {

    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    public void initialPhaseTest(){
        System.out.println(controller.getTurnsQueue());
        assertEquals(controller.getNamePhase(),"FirstCharacterPhase");
    }

    @Test
    public void enemyAttackPhaseTest(){
        assertFalse(controller.getTurnsQueue().isEmpty());

        controller.startPlaying();
        assertEquals("EnemyAttackPhase",controller.getNamePhase());

        //ahora revisamos que el enemigo si halla atacado a alguien
        //entonces un  player tiene que tener vida 80
        for (int i = 0;i <= 4; i++ ){
            if (controller.getPlayerPosition(i).getHealthPoints() < 100){
                assertEquals(80,controller.getPlayerPosition(i).getHealthPoints());
            }
        }
    }
    @Test
    public void pollAndWaitCharacterPhaseTest(){
        enemyAttackPhaseTest();  // until here we are in the phase enemyAttackPhase
        assertEquals(8,controller.getTurnsQueue().size());

        //we make as if it a button that changes tothe nest phase
        controller.buttonNext();
        assertEquals(7,controller.getTurnsQueue().size());
        assertEquals("pullOutCharacterPhase",controller.getNamePhase());

        try {
            // we wait for a while until the chracater is put back on the turns queue
            Thread.sleep(1100);
            assertEquals(8,controller.getTurnsQueue().size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void oneFullTurn(){
        pollAndWaitCharacterPhaseTest();
        controller.buttonNext();
        assertEquals("CheckTurnQueuePhase",controller.getNamePhase());
        controller.buttonNext();
        assertEquals("ChoseWeaponPhase",controller.getNamePhase()); //como el siguiente es un player va directo a esa fase
    }

    @Test
    public void ChoseWeaponAndAttackPhaseTest(){
        oneFullTurn();  //we are in the phase FirstCharacterPhase with an engineer
        assertEquals("ChoseWeaponPhase",controller.getNamePhase());
        // esto es como q se elige armas al ingeniiero con una hacha
        controller.ThisWeaponButton(controller.getInventory().get(3)); //este sera un boton para una arma
        assertEquals(controller.getInventory().get(3),controller.getPlayerPosition(0).getEquippedWeapon());

        //antes de que sea atacado tiene toda la vida
        assertEquals(100,controller.getEnemyPosition(0).getHealthPoints());
        //apretamos el boton para pasar a la siguiente fase que es elegir al target
        controller.buttonNext();
        assertEquals("SelectAttackTargetPhase",controller.getNamePhase());
        //como fue atacado tiene menos vida
        assertEquals(99,controller.getEnemyPosition(0).getHealthPoints());
    }
    @Test
    public void pollOutAndBackAgain(){
        ChoseWeaponAndAttackPhaseTest();
        assertEquals("SelectAttackTargetPhase",controller.getNamePhase());
        controller.buttonNext();
        assertEquals(7,controller.getTurnsQueue().size());
        assertEquals("pullOutCharacterPhase",controller.getNamePhase());
        try {
            // we wait for a while until the chracater is put back on the turns queue
            Thread.sleep(1100);
            assertEquals(8,controller.getTurnsQueue().size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        controller.buttonNext();
        assertEquals("CheckTurnQueuePhase",controller.getNamePhase());
        controller.buttonNext();
        assertEquals("EnemyAttackPhase",controller.getNamePhase());




    }




}
