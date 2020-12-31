package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractPhaseTest {
    protected GameController controller;


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
