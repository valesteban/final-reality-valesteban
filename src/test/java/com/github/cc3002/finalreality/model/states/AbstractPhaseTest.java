package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.Controller.phases.InvalidActionException;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractPhaseTest {
    protected GameController controller;

    public void equipWeaponTest(int inventoryWeapon , GameController controller,int playerPosition) throws InvalidActionException {
        assertEquals("ChoseWeaponPhase",controller.getNamePhase());
        assertEquals("Choose a weapon",controller.getPhase().instruction());
        controller.thisWeaponButton(controller.getInventory().get(inventoryWeapon)); //esto es como si se apreta el boton
        assertEquals(controller.getInventory().get(inventoryWeapon),controller.getPlayerPosition(playerPosition).getEquippedWeapon());

    }
    public void equipWeaponNullTest(int inventoryWeapon , GameController controller,int playerPosition) throws InvalidActionException {
        assertEquals("ChoseWeaponPhase",controller.getNamePhase());
        assertEquals("Choose a weapon",controller.getPhase().instruction());
        controller.thisWeaponButton(controller.getInventory().get(inventoryWeapon)); //esto es como si se apreta el boton
        assertEquals(null,controller.getPlayerPosition(playerPosition).getEquippedWeapon());
        assertEquals("SelectTargetPhase",controller.getNamePhase());
        assertEquals("Choose a Enemy to attack",controller.getPhase().instruction());


    }

    public void attackEnemyTest(int positionEnemy) throws InvalidActionException {
        assertEquals(10,controller.getTurnsQueue().size()); //antes de atacar hay 10 en la cola de turnos
        assertEquals("SelectTargetPhase",controller.getNamePhase());
        assertEquals("Choose a Enemy to attack",controller.getPhase().instruction());
        controller.selectingEnemy(positionEnemy);
        assertEquals(9,controller.getTurnsQueue().size()); //se saca de la cola de turnos
        try {   //luego de esperar un poco se vuelve a meter a la cola al player
            Thread.sleep(1100);
            assertEquals(10,controller.getTurnsQueue().size());  //is back in the turns queue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("FirstCharacterPhase",controller.getNamePhase());

    }
    public void attackEnemyButNotTest(int positionEnemy) throws InvalidActionException {
        assertEquals(10,controller.getTurnsQueue().size()); //antes de atacar hay 10 en la cola de turnos
        assertEquals("SelectTargetPhase",controller.getNamePhase());
        assertEquals("Choose a Enemy to attack",controller.getPhase().instruction());
        controller.selectingEnemy(positionEnemy);
        assertEquals(9,controller.getTurnsQueue().size()); //se saca de la cola de turnos
        assertEquals("FirstCharacterPhase",controller.getNamePhase());
        try {   //luego de esperar un poco se vuelve a meter a la cola al player
            Thread.sleep(1100);
            assertEquals(10,controller.getTurnsQueue().size());  //is back in the turns queue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void basicSetUp(){
        controller = new GameController();
        //crearmos y agregamos las armas al inventario
        controller.createSword("SwordName",15,10);
        controller.createStaff("StaffName",13,9,3);
        controller.createKnife("KnifeName",8,2);
        controller.createAxe("AxeName",11,6);
        controller.createBow("BowName",12,4);

        //creamos players y enemies y los agregamos a sus respectivas listas y a la cola de turnos
        controller.createEnemy("nameEnemy1", 15, 4, 12);
        controller.createEngineer( "nameEngineer", "Engineer",3);
        controller.createEnemy( "nameEnemy1", 16, 3,14);
        controller.createKnight( "nameKnight", "Knight",2);
        controller.createEnemy("nameEnemy3", 15, 2, 10);
        controller.createThief( "nameThief", "Thief",5);
        controller.createEnemy("nameEnemy4",12,4,15);
        controller.createWhiteMage( "nameWhiteMage", "WhiteMage",1, 14);
        controller.createEnemy("nameEnemy5", 13, 1, 7);
        controller.createBlackMage( "nameBlackMage", "BlackMage",2, 12);

    }


}
