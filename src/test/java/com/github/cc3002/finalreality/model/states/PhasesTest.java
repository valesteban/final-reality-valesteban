package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.Controller.phases.InvalidActionException;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.AxeTest;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
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
    public void initialPhaseTest() throws InvalidActionException {
        assertEquals("FirstCharacterPhase" ,controller.getNamePhase());
        assertEquals("To start the turn press the button start Turn",controller.getPhase().instruction());


        //whe the button start Game is push it will change to the next phase
        assertEquals(10,controller.getTurnsQueue().size()); //tenemos 10 characters
        controller.startPlaying();
        //com oel primer character en la fila de turnos es un nemy attaca y vuelve al inicio

        assertEquals(9,controller.getTurnsQueue().size()); // ataco el enemigo s esaco de la cola de turnos
        assertEquals("FirstCharacterPhase",controller.getNamePhase());
        try {   //luego de esperar un poco se vuelve a meter a la cola al enemigo
            Thread.sleep(1100);
            assertEquals(10,controller.getTurnsQueue().size());  //is back in the turns queue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // y un player quedo con menos vida
        for (int i = 0;i <= 4; i++ ){
            if (controller.getPlayerPosition(i).getHealthPoints() < 100){
                assertTrue(controller.getPlayerPosition(i).getHealthPoints()<100);
                assertEquals(controller.getNamePhase(),"FirstCharacterPhase");
            }
        }


    }

    @Test
    public void characterChooseWeapon0AndEnemy0() throws InvalidActionException {
        initialPhaseTest();
        controller.startPlaying(); //tenemoa a un ingeniero primero en la cola de turnos
        equipWeaponNullTest( 0,controller,0); //tratamos de equipar al ingenieron con una espada  pero no se puede
        attackEnemyButNotTest(4);

    }
    @Test
    public void characterChooseWeapon1AndEnemy1() throws InvalidActionException {
        initialPhaseTest();
        controller.startPlaying();  //tenemoa a un ingeniero primero en la cola de turnos
        equipWeaponNullTest(1,controller,0); //tratamos de equipar al ingenieron con un bastón pero no se puede
        attackEnemyButNotTest(1);

    }
    @Test
    public void characterChooseWeapon2AndEnemy2() throws InvalidActionException {
        initialPhaseTest();
        controller.startPlaying();  //tenemoa a un ingeniero primero en la cola de turnos
        equipWeaponNullTest( 2,controller,0); //tratamos de equipar al ingenieron con un cuchillo pero no se puede
        attackEnemyButNotTest(2);
    }
    @Test
    public void characterChooseWeapon3AndEnemy3() throws InvalidActionException {
        initialPhaseTest();
        controller.startPlaying(); //tenemoa a un ingeniero primero en la cola de turnos
        equipWeaponTest( 3,controller,0); //equipamos al ingenieron con una hacha
        attackEnemyTest(3);
    }

    @Test
    public void characterChooseWeapon4AndEnemy4() throws InvalidActionException {
        initialPhaseTest();
        controller.startPlaying();  //tenemos a un ingeniero primero en la cola de turnos
        equipWeaponTest( 4,controller,0); //equipamos al ingenieron con un arco
        attackEnemyTest(4);
    }
    @Test
    public void errorTest() throws InvalidActionException {
        assertEquals("FirstCharacterPhase" ,controller.getNamePhase());
        //si tratamos de selccionar a un enemigo en otra fase
        assertThrows(InvalidActionException.class,()->controller.selectingEnemy(0));
        //si tratamos de selccionar una arma en otra fase
        assertThrows(InvalidActionException.class,()->controller.thisWeaponButton(controller.getInventory().get(0)));

        //lo mismo con el metodo nextPhaseButton si lo llamamos cuando estamos en la fase FirstCharacterPhase
        assertThrows(InvalidActionException.class,()->controller.getPhase().nextPhaseButton());

        controller.startPlaying();
        assertEquals("FirstCharacterPhase" ,controller.getNamePhase());
        controller.startPlaying();
        assertEquals("ChoseWeaponPhase" ,controller.getNamePhase());
      //  assertThrows(InvalidActionException.class,()->controller.getPhase().instruction());
    }

}



