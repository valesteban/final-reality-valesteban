package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractPhase {
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
        controller.createEnemy("nameEnemy1", 10, 10, 12);
        controller.createEngineer( "nameEngineer", "Engineer",6);
        controller.createEnemy( "nameEnemy1", 10, 7,14);
        controller.createKnight( "nameKnight", "Knight",4);
        controller.createThief( "nameThief", "Thief",5);
        controller.createEnemy("nameEnemy3",8,11,15);
        controller.createWhiteMage( "nameWhiteMage", "WhiteMage",5, 14);
        controller.createBlackMage( "nameBlackMage", "BlackMage",8, 12);
    }


}
