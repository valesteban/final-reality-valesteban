package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class GameController {
    private final IEveventHandler characterDeadHandler = new CharacterHandler(this);
    private LinkedList<IPlayerCharacter> players;
    private LinkedList<Enemy> enemies;
    private LinkedList<IWeapon> inventory;


    public GameController( ){
        players = new LinkedList<>();
        enemies = new LinkedList<>();
        inventory = new LinkedList<>();
    }
    /**
     * Creates an enemy, add it to the enemies list and add a listener
     */
    public void createEnemy(BlockingQueue<ICharacter> turnsQueue,String name,int weight,
                            int protection, int damage){
        Enemy e = new Enemy(turnsQueue,name,weight,protection,damage);
        e.addListener(characterDeadHandler);
        enemies.add(e);
    }
    /**
     * returns the list of enemies.
     */
    public LinkedList<Enemy> getEnemies(){return enemies;}
    /**
     * returns the list of players.
     */
    public LinkedList<IPlayerCharacter> getPlayers(){return players;}
    /**
     * returns the inventory.
     */
    public LinkedList<IWeapon> getInventory(){return inventory;}
    /**
     * Controller creates a axe and add it to the inventory
     */
    public void createAxe(String name, int damage, int weight){
        Axe a = new Axe(name, damage, weight);
        inventory.add(a);
    }
    /**
     * Controller creates a bow and add it to the inventory
     */
    public void createBow(String name, int damage, int weight){
        Bow b = new Bow(name, damage, weight);
        inventory.add(b);
    }
    /**
     * Controller creates a knife and add it to the inventory
     */
    public void createKnife(String name, int damage, int weight){
        Knife k = new Knife(name, damage, weight);
        inventory.add(k);
    }
    /**
     * Controller creates a staff and add it to the inventory
     */
    public void createStaff(String name, int damage, int weight, int magicDamage){
        Staff s = new Staff(name, damage, weight,magicDamage);
        inventory.add(s);
    }
    /**
     * Controller creates a sword and add it to the inventory
     */
    public void createSword(String name, int damage, int weight){
        Sword s = new Sword(name, damage, weight);
        inventory.add(s);
    }


    /**
     * Controller creates a thief, add it to the player list and add a listener
     */
    public void createThief(BlockingQueue<ICharacter> turnsQueue,String name,String characterClass,
                            int protection){
        Thief t = new Thief(turnsQueue,name,protection);
        t.addListener(characterDeadHandler);
        players.add(t);
    }
    /**
     * Controller creates a knight, add it to the player list and add a listener
     */
    public void createKnight(BlockingQueue<ICharacter> turnsQueue,String name,String characterClass,
                             int protection){
        Knight k = new Knight(turnsQueue,name,protection);
        k.addListener(characterDeadHandler);
        players.add(k);
    }
    /**
     * Controller creates a engineer, add it to the player list and add a listener
     */
    public void createEngineer(BlockingQueue<ICharacter> turnsQueue,String name,String characterClass,
                               int protection){
        Engineer e = new Engineer(turnsQueue,name,protection);
        e.addListener(characterDeadHandler);
        players.add(e);
    }
    /**
     * Controller creates a blackMage, add it to the player list and add a listener
     */
    public void createBlackMage(BlockingQueue<ICharacter> turnsQueue,String name,String characterClass,
                                int protection, int mana){
        BlackMage b = new BlackMage(turnsQueue,name,mana,protection);
        b.addListener(characterDeadHandler);
        players.add(b);
    }
    /**
     * Controller creates a whiteMage, add it to the player list and add a listener
     */
    public void createWhiteMage(BlockingQueue<ICharacter> turnsQueue,String name,String characterClass,
                                int protection, int mana){
        WhiteMage w = new WhiteMage(turnsQueue,name,mana,protection);
        w.addListener(characterDeadHandler);
        players.add(w);
    }


    public void equipPlayer(IPlayerCharacter player, IWeapon weapon){
        for (IPlayerCharacter p : players){
            if (p.equals(player)){
                p.equip(weapon);
            }
        }
    }

    public void attackCharacter(ICharacter attacker, ICharacter attacked){
        attacker.attack(attacked);
    }

    public void isAttackedCharacter(ICharacter character){
        //aqui lo eliminamos de la lista
        System.out.println("fue matado atacado \n");


    }
}
