package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.Controller.CharacterHandler;
import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.Controller.IEveventHandler;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ControllerTest {
    private BlockingQueue<ICharacter> turns;
    private GameController controller;
    private IEveventHandler handler ;
    private Axe axeTest;
    private Sword swordTest;
    private Knife knifeTest;
    private Staff staffTest;
    private Bow bowTest;


    @BeforeEach
    void setUp(){
        turns = new LinkedBlockingQueue<>();
        controller = new GameController();
        handler = new CharacterHandler(controller);
        controller.createThief(turns, "player1Thief", "Thief", 2);
        controller.createEngineer(turns, "player2Engineer", "Engineer", 2);
        controller.createKnight(turns, "player3Knight", "Knight", 2);
        controller.createBlackMage(turns, "player4BlackMageThief", "BlackMage", 2, 20);
        controller.createWhiteMage(turns, "player5WhiteMage", "WhiteMage", 2, 22);
        controller.createEnemy(turns,"enemy1",12,1,33);
        controller.createEnemy(turns,"enemy2",12,2,22);

        controller.createAxe("axeName",34,2);
        controller.createBow("bowName",44,20);
        controller.createKnife("knifeName",44,14);
        controller.createStaff("staffName",45,13,2);
        controller.createSword("swordName",55,10);

    }


    @Test
    public void createPlayersAndEnemy() {
        Assertions.assertFalse(controller.getPlayers().isEmpty());
        assertEquals("player1Thief",controller.getPlayers().get(0).getName());
        assertEquals("player2Engineer",controller.getPlayers().get(1).getName());
        assertEquals("player3Knight",controller.getPlayers().get(2).getName());
        assertEquals("player4BlackMageThief",controller.getPlayers().get(3).getName());
        assertEquals("player5WhiteMage",controller.getPlayers().get(4).getName());
        Assertions.assertFalse(controller.getEnemies().isEmpty());
        assertEquals("enemy1",controller.getEnemies().get(0).getName());
        assertEquals("enemy2",controller.getEnemies().get(1).getName());
    }

    @Test
    public void createWeapons(){
        Assertions.assertFalse(controller.getInventory().isEmpty());
        assertEquals("axeName",controller.getInventory().get(0).getName());
        assertEquals("bowName",controller.getInventory().get(1).getName());
        assertEquals("knifeName",controller.getInventory().get(2).getName());
        assertEquals("staffName",controller.getInventory().get(3).getName());
        assertEquals("swordName",controller.getInventory().get(4).getName());
    }

   // @Test
//    public void equipPlayers(){
      //  IPlayerCharacter t1 = controller.getPlayers().get(0);
      //  Sword s1 = new Sword("sword",22,3);
      //  controller.equipPlayer(t1,s1);
     //   controller.attackCharacter();

  //  }

    //@Test
    //public void atacar(){
    //    controller.createEnemy(turns,"enemy1",6,2,22);
    //    controller.createEnemy(turns,"enemy2",2,3,33);
    //    assertEquals("enemy1",controller.getEnemies().get(0).getName());
    //    assertEquals("enemy2",controller.getEnemies().get(1).getName());
    //}



}
