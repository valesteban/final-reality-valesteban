package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private BlockingQueue<ICharacter> turns ;
    private GameController controller;

    private BlockingQueue<ICharacter> turnsQueueTest;
    private Thief thiefTest;
    private Engineer engineerTest;
    private Knight knightTest;
    private BlackMage blackMageTest;
    private WhiteMage whiteMageTest;
    private Enemy enemy1;
    private Enemy enemy2;
    private Axe axeTest;
    private Bow bowTest;
    private Knife knifeTest;
    private Staff staffTest;
    private Sword swordTest;


    @BeforeEach
    void setUp(){
        //turns = new LinkedBlockingQueue<>();
        controller = new GameController();
        controller.createThief("player1Thief", "Thief", 2);
        controller.createEngineer("player2Engineer", "Engineer", 2);
        controller.createKnight("player3Knight", "Knight", 2);
        controller.createBlackMage( "player4BlackMageThief", "BlackMage", 2, 20);
        controller.createWhiteMage( "player5WhiteMage", "WhiteMage", 2, 22);
        controller.createEnemy("enemy1",12,1,33);
        controller.createEnemy("enemy2",12,2,22);

        controller.createAxe("axeName",34,2);
        controller.createBow("bowName",44,20);
        controller.createKnife("knifeName",44,14);
        controller.createStaff("staffName",45,13,2);
        controller.createSword("swordName",55,10);

        axeTest = new Axe("axeName",34,2);
        bowTest = new Bow("bowName",44,20);
        knifeTest =  new Knife("knifeName",44,14);
        staffTest = new Staff("staffName",45,13,2);
        swordTest = new Sword("swordName",55,10);

        thiefTest = new Thief(turnsQueueTest,"player1Thief", 2);
        engineerTest = new Engineer(turnsQueueTest,"player2Engineer", 2);
        knightTest = new Knight(turnsQueueTest,"player3Knight", 2);
        blackMageTest = new BlackMage(turnsQueueTest, "player4BlackMageThief", 20, 2);
        whiteMageTest = new WhiteMage(turnsQueueTest,"player5WhiteMage", 22, 2);
        enemy1 = new Enemy(turnsQueueTest,"enemy1",12,1,33);
        enemy2 = new Enemy(turnsQueueTest,"enemy2",12,2,22);
    }


    @Test
    public void GameControllerConstructorTest() {
        Assertions.assertFalse(controller.getPlayers().isEmpty());
        Assertions.assertFalse(controller.getEnemies().isEmpty());

        //comprovamos a los players
        assertEquals(controller.getPlayerPosition(0),thiefTest);
        assertEquals(controller.getPlayerPosition(1),engineerTest);
        assertEquals(controller.getPlayerPosition(2),knightTest);
        assertEquals(controller.getPlayerPosition(3),blackMageTest);
        assertEquals(controller.getPlayerPosition(4),whiteMageTest);

        //comprobamos que esten lso enemigos
        assertEquals(controller.getEnemyPosition(0),enemy1);
        assertEquals(controller.getEnemyPosition(1),enemy2);

        //vemos que si estan en la cola
        assertTrue(controller.getTurnsQueue().contains(thiefTest));
        assertTrue(controller.getTurnsQueue().contains(engineerTest));
        assertTrue(controller.getTurnsQueue().contains(knightTest));
        assertTrue(controller.getTurnsQueue().contains(blackMageTest));
        assertTrue(controller.getTurnsQueue().contains(whiteMageTest));
        assertTrue(controller.getTurnsQueue().contains(enemy1));
        assertTrue(controller.getTurnsQueue().contains(enemy2));

        //comprobamos a las armas
        assertEquals(controller.getInventory().get(0),axeTest);
        assertEquals(controller.getInventory().get(1),bowTest);
        assertEquals(controller.getInventory().get(2),knifeTest);
        assertEquals(controller.getInventory().get(3),staffTest);
        assertEquals(controller.getInventory().get(4),swordTest);

    }
    @Test
    public void createWeapons(){
        //ya lo probamos arriba pero una ves mas que mas da
        Assertions.assertFalse(controller.getInventory().isEmpty());
        assertTrue(controller.getInventory().contains(axeTest));
        assertTrue(controller.getInventory().contains(bowTest));
        assertTrue(controller.getInventory().contains(knifeTest));
        assertTrue(controller.getInventory().contains(staffTest));
        assertTrue(controller.getInventory().contains(swordTest));

    }

    @Test
    public void equipPlayersTest(){
        //equipamos a un thief con una espada
        controller.equipPlayer(controller.getPlayers().get(0), controller.getInventory().get(4));
        assertEquals(controller.getPlayers().get(0).getEquippedWeapon(),controller.getInventory().get(4));

        //equipamos a un ingeniero con arco
        controller.equipPlayer(controller.getPlayerPosition(1),controller.getInventory().get(1));
        assertEquals(controller.getPlayers().get(1).getEquippedWeapon(),controller.getInventory().get(1));

        //equipamos a un caballero con una hacha
        controller.equipPlayer(controller.getPlayers().get(2), controller.getInventory().get(0));
        assertEquals(controller.getPlayers().get(2).getEquippedWeapon(),controller.getInventory().get(0));

        //equipamos a un mago negro con un cuchillo
        controller.equipPlayer(controller.getPlayers().get(3), controller.getInventory().get(2));
        assertEquals(controller.getPlayers().get(3).getEquippedWeapon(),controller.getInventory().get(2));

        //equipamos a un mago blanco con baston
        controller.equipPlayer(controller.getPlayers().get(4), controller.getInventory().get(3));
        assertEquals(controller.getPlayerPosition(4).getEquippedWeapon(),controller.getInventory().get(3));
    }

    @Test
    public void attackCharacter(){
        controller.attackPlayers(controller.getEnemies().get(0), controller.getPlayers().get(0));
        assertEquals(69,controller.getPlayers().get(0).getHealthPoints());
        controller.attackPlayers(controller.getEnemies().get(0), controller.getPlayers().get(1));
        assertEquals(69,controller.getPlayers().get(1).getHealthPoints());
        controller.attackPlayers(controller.getEnemies().get(0), controller.getPlayers().get(2));
        assertEquals(69,controller.getPlayers().get(2).getHealthPoints());
        controller.attackPlayers(controller.getEnemyPosition(0),controller.getPlayers().get(3));
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
    public void WinnerTest(){
        //matamos a todos los players
        for (int i = 0; i < 5 ;i++){
            controller.getPlayerPosition(i).setHealthPoints(0); //quitandoles la vida
            controller.getPlayerPosition(i).setDead();          //seteando que estan muertos
        }
        //gano el enemigo porque hicimos que todos los players quedasen con vida 0
        assertTrue(controller.getWinnerEnemy());

        for (int i = 0; i < 2 ;i++){
            controller.getEnemyPosition(i).setHealthPoints(0);
            controller.getEnemyPosition(i).setDead();  //matamos a todos enemy
        }
        //gano el enemigo porque hicimos que todos los players quedasen con vida 0
        assertTrue(controller.getWinnerPlayer());
    }

    @Test
    public void firstCharacterQueueAndPullOutCharacterTest(){
        assertFalse(controller.getTurnsQueue().isEmpty());
        ICharacter c1 = controller.getFirstCharacterQueue();
        assertEquals(c1,thiefTest);
        controller.pullOutCharacter();  //lo sacamos

        c1 = controller.getFirstCharacterQueue();
        assertEquals(c1,engineerTest);
        controller.pullOutCharacter();

        c1 = controller.getFirstCharacterQueue();
        assertEquals(c1,knightTest);
        controller.pullOutCharacter();

        c1 = controller.getFirstCharacterQueue();
        assertEquals(c1,blackMageTest);
        controller.pullOutCharacter();

        c1 = controller.getFirstCharacterQueue();
        assertEquals(c1,whiteMageTest);
        controller.pullOutCharacter();
    }


}

