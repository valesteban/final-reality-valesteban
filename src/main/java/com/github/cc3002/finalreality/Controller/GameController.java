package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class GameController {
    private final IEveventHandler characterDeadHandler = new CharacterHandler(this);
    private LinkedList<IPlayerCharacter> players;
    private LinkedList<Enemy> enemies;


    public GameController( ){
        players = new LinkedList<>();
        enemies = new LinkedList<>();
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
     * Creates a player, add it to the player list and add a listener
     */
    public void createPlayer(BlockingQueue<ICharacter> turnsQueue,String name,String characterClass,
                             int protection, int mana){
        if (characterClass == "Thief"){
            Thief t = new Thief(turnsQueue,name,protection);
            t.addListener(characterDeadHandler);
            players.add(t);
        }
        else if (characterClass =="Knight") {
            Knight k = new Knight(turnsQueue,name,protection);
            k.addListener(characterDeadHandler);
            players.add(k);
        }
        else if (characterClass =="Engineer"){
            Engineer e = new Engineer(turnsQueue,name,protection);
            e.addListener(characterDeadHandler);
            players.add(e);
        }
        else if (characterClass =="BlackMage"){
            BlackMage b = new BlackMage(turnsQueue,name,mana,protection);
            b.addListener(characterDeadHandler);
            players.add(b);
        }
        else if (characterClass =="WhiteMage"){
            WhiteMage w = new WhiteMage(turnsQueue,name,mana,protection);
            w.addListener(characterDeadHandler);
            players.add(w);
        }
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
