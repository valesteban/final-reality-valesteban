package com.github.cc3002.finalreality.model.states;

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
    public void pollCharacterPhaseTest(){
        enemyAttackPhaseTest();
        controller.getPhase().nextPhaseButton();
        assertEquals("pullOutCharacterPhase",controller.getNamePhase());
    }

}
