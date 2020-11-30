package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.Controller.CharacterHandler;
import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.Controller.IEveventHandler;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ControllerTest {
    public BlockingQueue<ICharacter> turns;
    public GameController controller;
    public IEveventHandler handler ;

    public void basicSetUpController() {
        turns = new LinkedBlockingQueue<>();
        controller = new GameController();
        handler = new CharacterHandler(controller);

        controller.createEnemy( turns, "nameEnemy1", 10, 10, 40);
        controller.createEnemy(turns, "nameEnemy2", 10, 10, 40);
        controller.createPlayer(turns,"thief","Thief",2,0);
        controller.createPlayer(turns,"knight","Knight",2,0);
        controller.createPlayer(turns,"engineer","Engineer",2,0);
        controller.createPlayer(turns,"blackMage","BlackMage",2,22);
        controller.createPlayer(turns,"whiteMage","WhiteMage",2,33);

    }
    @BeforeEach
    void setUp(){
        this.basicSetUpController();
    }


    @Test
    public void createPlayers() {
        controller.createPlayer(turns, "player1Thief", "Thief", 2, 0);
        controller.createPlayer(turns, "player2Engineer", "Engineer", 2, 0);
        controller.createPlayer(turns, "player3Knight", "Knight", 2, 0);
        controller.createPlayer(turns, "player4BlackMageThief", "BlackMage", 2, 20);
        controller.createPlayer(turns, "player5WhiteMage", "WhiteMage", 2, 22);

        assertEquals("player1Thief",controller.getPlayers().get(0).getName());
        assertEquals("player2Engineer",controller.getPlayers().get(1).getName());
        assertEquals("player3Knight",controller.getPlayers().get(2).getName());
        assertEquals("player4BlackMageThief",controller.getPlayers().get(3).getName());
        assertEquals("player5WhiteMage",controller.getPlayers().get(4).getName());
    }
    @Test
    public void atacar(){
        controller.createEnemy(turns,"enemy1",6,2,22);
        controller.createEnemy(turns,"enemy2",2,3,33);
        assertEquals("enemy1",controller.getEnemies().get(0).getName());
        assertEquals("enemy2",controller.getEnemies().get(1).getName());


    }
    @Test
    public void equipPlayers(){
        Thief t1 = new Thief(turns, "player1Thief",  2);
        Sword s1 = new Sword("sword",22,3);
        controller.equipPlayer(t1,s1);
        controller.attackCharacter();

    }



}
