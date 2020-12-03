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
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private BlockingQueue<ICharacter> turns ;
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
        controller = new GameController(turns);
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

    @Test
    public void equipPlayersTest(){

        controller.equipPlayer(controller.getPlayers().get(0), controller.getInventory().get(4));
        assertEquals(controller.getPlayers().get(0).getEquippedWeapon(),controller.getInventory().get(4));
        controller.equipPlayer(controller.getPlayerPosition(1),controller.getInventory().get(1));
        assertEquals(controller.getPlayers().get(1).getEquippedWeapon(),controller.getInventory().get(1));
    }

    @Test
    public void attackCharacter(){
        controller.attackPLayers(controller.getEnemies().get(0), controller.getPlayers().get(0));
        assertEquals(69,controller.getPlayers().get(0).getHealthPoints());
        controller.attackPLayers(controller.getEnemies().get(0), controller.getPlayers().get(1));
        assertEquals(69,controller.getPlayers().get(1).getHealthPoints());
        controller.attackPLayers(controller.getEnemies().get(0), controller.getPlayers().get(2));
        assertEquals(69,controller.getPlayers().get(2).getHealthPoints());
        controller.attackPLayers(controller.getEnemyPosition(0),controller.getPlayers().get(3));
        assertEquals(69,controller.getPlayers().get(3).getHealthPoints());
        assertEquals(69,controller.getPlayerPosition(3).getHealthPoints());
    }

    @Test
    public void enemyTurnTest(){
        Enemy e1 = controller.getEnemyPosition(1);
        controller.enemyTurn(e1);
        //al player que tiene menos vida se teste eue se le quita la vida esperada
        for (int i = 0;i <= 4; i++ ){
            if (controller.getPlayerPosition(i).getHealthPoints() < 100){
                assertEquals(80,controller.getPlayerPosition(i).getHealthPoints());
            }
        }
    }

    @Test
    public void WinerTest(){
        for (int i = 0; i < 5 ;i++){
            System.out.println(i);
            controller.getPlayerPosition(i).setHealthPoints(0);
            controller.getPlayerPosition(i).setDead();  //matamos a todos
        }
        //gano el enemigo porque hicimos que todos los players quedasen con vida 0
        assertTrue(controller.returnWinnerEnemy());

        for (int i = 0; i < 2 ;i++){
            System.out.println(i);
            controller.getEnemyPosition(i).setHealthPoints(0);
            controller.getEnemyPosition(i).setDead();  //matamos a todos enemy
        }
        //gano el enemigo porque hicimos que todos los players quedasen con vida 0
        assertTrue(controller.returnWinnerPlayer());
    }


    //@Test
    //public void TurnFirstPartEnemy(){
        //partimos provando al enemy que este en la cabeza de la cola
      //  assertTrue(controller.getTurnsQueue().isEmpty());
      //  controller.getEnemyPosition(1).waitTurn(); //agregamos al enemy a la cola
      //  try {
      //      Thread.sleep(1300);
      //      assertFalse(controller.getTurnsQueue().isEmpty());
      //  } catch (InterruptedException e) {
      //      e.printStackTrace();
      //  }
        //ahora checkeamos que al sacarlo atacke a alguien
      //  controller.firstCharacterQueue();

        //ocupamos lo mismos que en enemyTurnTest() aunque ya esta probado
      //  Enemy e1 = controller.getEnemyPosition(1);
      //  controller.enemyTurn(e1);
        //al player que tiene menos vida se teste eue se le quita la vida esperada
      //  for (int i = 0;i <= 4; i++ ){
      //      if (controller.getPlayerPosition(i).getHealthPoints() < 100){
      //          assertEquals(80,controller.getPlayerPosition(i).getHealthPoints());
      //      }
      //  }
   // }
    @Test
    public void TurnFirstPartPlayer(){
        assertTrue(controller.getTurnsQueue().isEmpty());
        equipPlayersTest();
        controller.timerCharacter(controller.getEnemyPosition(0)); //agregamos a un thief al la cola
        controller.timerCharacter(controller.getEnemyPosition(1)); //agregamos a un ingeniero a la ocla

        try {
            Thread.sleep(1300);
            assertFalse(controller.getTurnsQueue().isEmpty());
            controller.pullOutCharacter(); //
            controller.pullOutCharacter(); //sacamos a los elementos
            assertTrue(controller.getTurnsQueue().isEmpty());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}

