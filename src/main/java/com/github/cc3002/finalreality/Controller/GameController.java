package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * A class that communicate with the model  of the game.
 *
 * @author Valentina Esteban
 */
public class GameController {
    private final IEveventHandler characterDeadHandler = new CharacterHandler(this);
    private LinkedList<IPlayerCharacter> players;
    private LinkedList<Enemy> enemies;
    private LinkedList<IWeapon> inventory;
    private boolean winnerPlayer = false;
    private boolean winnerEnemy = false;
    private BlockingQueue<ICharacter> turnsQueue;

    /**
     * Creates a new GameController.
     *
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    public GameController( BlockingQueue<ICharacter> turnsQueue){
        players = new LinkedList<>();
        enemies = new LinkedList<>();
        inventory = new LinkedList<>();
        this.turnsQueue = turnsQueue;
    }
    /**
     * return true if the player is the winner.
     */
    public boolean getWinnerPlayer(){
            return winnerPlayer;
    }
    /**
     * return true if the Enemy is the winner.
     */
    public boolean getWinnerEnemy(){
        return winnerEnemy;
    }
    /**
     * returns the player in the position i of the list of players.
     */
    public IPlayerCharacter getPlayerPosition(int i){return players.get(i);}
    /**
     * returns the BlockingQueue.
     */
    public BlockingQueue<ICharacter>  getTurnsQueue(){return  turnsQueue;}
    /**
     * returns the enemy in the position i of the list of enemies.
     */
    public Enemy getEnemyPosition(int i){return enemies.get(i);}
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
     * Creates an enemy, add it to the enemies list and add a listener
     */
    public void createEnemy(BlockingQueue<ICharacter> turnsQueue,String name,int weight,
                            int protection, int damage){
        Enemy e = new Enemy(turnsQueue,name,weight,protection,damage);
        e.addListener(characterDeadHandler);
        enemies.add(e);
    }



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
        IPlayerCharacter k = new Knight(turnsQueue,name,protection);
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

    /**
     *  Equip a player with a weapon.
     */
    public void equipPlayer(IPlayerCharacter player, IWeapon weapon){
        for (IPlayerCharacter p : players){
            if (p.equals(player)){
                p.equip(weapon);
            }
        }
    }

    /**
     *  Character attack another character.
     */
    public void attackPLayers(ICharacter attacker,ICharacter attacked){
        attacker.attack(attacked);
    }

    /**
     *  Take the firs object of the BlockingQueue if it is an enemy it will take to the method enemyTurn and
     *  if it is a player for now it won´t do anything.
     */
    public void firstCharacterQueue(){
        ICharacter c1 = turnsQueue.element();                             //toma el primer elemento
        if (players.contains(c1)){
            //aqui pondremos la implementacion de la interaccion
            //con el jugardor
        }
        else {                                                          //entonces el objeto sacado es un enemigo
            System.out.println("toma el elementoq se llama \n"+ c1.getName());
            this.enemyTurn(c1);
        } }
    /**
     *  pulls out the first element in the BlockingQueue.
     */
    public void pullOutCharacter(){
        turnsQueue.poll();
    }

    /**
     *  waits depending on its weight to be add it to the BlockingQueue .
     */
    public void timerCharacter(ICharacter character){
        character.waitTurn();
    }

    /**
     *  Enemy choose a random player of tle list players and attak it.
     */
    public void enemyTurn(ICharacter character){
            Random r = new Random();
            int i = r.nextInt(players.size());     //elegimos un numero random
            IPlayerCharacter playerThatWillBeAttacked = players.get(i);
            character.attack(playerThatWillBeAttacked);
        }

    /**
     * When someone dies check if all in  the list of the one that died is dead
     * also, if thats the case the othe is the winner.
     */
    public void isAttackedCharacter(ICharacter character) {
        //aqui resvisamos si todos los demas entan muertos si es asi gana sino sigue
        //como e el personaje se murio vamos a eliminarlo de la lista y despues revisar
        // si esque la lista esta vacia y asi decimos q alguno gano
        System.out.println("fue matado \n");
        if (players.contains(character)) {
            int j = players.size();
            for (int i = 0; i < j; i++) {
                if (players.get(i).getAlive() == true) {  //si hay alguno vivo se sige jugando
                    break;
                }
            }
            this.winnerEnemy = true;
        } else {   //character es enemigo
            if (enemies.contains(character)) {
                int j = enemies.size();
                for (int i = 0; i < j; i++) {
                    if (enemies.get(i).getAlive() == true) {  //si hay alguno vivo se sige jugando
                        break;
                    }
                }
                this.winnerPlayer = true;
            }
        }
    }
}


