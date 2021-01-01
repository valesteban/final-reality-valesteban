package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.Controller.handler.CharacterHandler;
import com.github.cc3002.finalreality.Controller.handler.IEveventHandler;
import com.github.cc3002.finalreality.Controller.phases.FirstCharacterPhase;
import com.github.cc3002.finalreality.Controller.phases.InvalidActionException;
import com.github.cc3002.finalreality.Controller.phases.Phase;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
    private BlockingQueue<ICharacter> turnsQueue = new LinkedBlockingQueue<>() ;
    private Phase phase ;

    /**
     * Creates a new GameController.
     *
     *     the queue with the characters waiting for their turn
     */
    public GameController( ){
        players = new LinkedList<>();
        enemies = new LinkedList<>();
        inventory = new LinkedList<>();
        setPhase( new FirstCharacterPhase());
    }

    /**
     * set the phase to the controller and add the controller tothe phase.
     */
    public void setPhase(final @NotNull Phase phase){
        this.phase = phase;
        phase.setController(this);
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
     * returns the name of the phase that we are in.
     */
    public String getNamePhase(){
        return phase.toString();
    }
    /**
     * returns  the phase that we are in.
     */
    public Phase getPhase(){return phase;}



    /**
     * Creates an enemy, add it to the enemies list and add a listener
     */
    public void createEnemy(String name,int weight,
                            int protection, int damage){
        Enemy e = new Enemy(turnsQueue,name,weight,protection,damage);
        turnsQueue.add(e);
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
    public void createThief(String name,String characterClass,
                            int protection){
        Thief t = new Thief(turnsQueue,name,protection);
        turnsQueue.add(t);
        t.addListener(characterDeadHandler);
        players.add(t);
    }
    /**
     * Controller creates a knight, add it to the player list and add a listener
     */
    public void createKnight(String name,String characterClass,
                             int protection){
        IPlayerCharacter k = new Knight(turnsQueue,name,protection);
        turnsQueue.add(k);
        k.addListener(characterDeadHandler);
        players.add(k);
    }
    /**
     * Controller creates a engineer, add it to the player list and add a listener
     */
    public void createEngineer(String name,String characterClass,
                               int protection){
        Engineer e = new Engineer(turnsQueue,name,protection);
        turnsQueue.add(e);
        e.addListener(characterDeadHandler);
        players.add(e);
    }
    /**
     * Controller creates a blackMage, add it to the player list and add a listener
     */
    public void createBlackMage(String name,String characterClass,
                                int protection, int mana){
        BlackMage b = new BlackMage(turnsQueue,name,mana,protection);
        turnsQueue.add(b);
        b.addListener(characterDeadHandler);
        players.add(b);
    }
    /**
     * Controller creates a whiteMage, add it to the player list and add a listener
     */
    public void createWhiteMage(String name,String characterClass,
                                int protection, int mana){
        WhiteMage w = new WhiteMage(turnsQueue,name,mana,protection);
        turnsQueue.add(w);
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
//                System.out.println(p.getEquippedWeapon().getName());
            }
        }
    }

    /**
     *  Character attack another character.
     */
    public void attackPlayers(ICharacter attacker, ICharacter attacked){
        attacker.attack(attacked);
    }


    /**
     *  returns the firs character of the BlockingQueue.
     */
    public ICharacter getFirstCharacterQueue(){
        ICharacter c1 = turnsQueue.element();
        return c1;
    }

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
    public int isAttackedCharacter(ICharacter character) {
        //aqui resvisamos si todos los demas entan muertos si es asi gana sino sigue
        //como e el personaje se murio vamos a eliminarlo de la lista y despues revisar
        // si esque la lista esta vacia y asi decimos q alguno gano
        System.out.println("alguien murio sique revisamos si todo murieron");
        System.out.println("este personaje murio : "+character.getName());
        if (players.contains(character)) {
            System.out.println("era un player");
            int j = players.size();
            for (int i = 0; i < j; i++) {
                if (players.get(i).getAlive() == true) {  //si hay alguno vivo se sige jugando
                    return 0;
                }
            }
            this.winnerEnemy = true;
        } else {   //character es enemigo
            if (enemies.contains(character)) {
                System.out.println("era un enemigo");
                int j = enemies.size();
                for (int i = 0; i < j; i++) {
                    if (enemies.get(i).getAlive() == true) {  //si hay alguno vivo se sige jugando
                        return 0;
                    }
                }
                this.winnerPlayer = true;

            }
        }
        return 1;
    }


    //despues arreglar esto se supone q el jugador va  aelegir un aarma de las que hay en el inventario
    public void thisWeaponButton(IWeapon weapon) throws InvalidActionException {// throws InvalidActionException {
        phase.selectWeapon(weapon);
        buttonNext();
    }

    public void selectingEnemy(int i) throws InvalidActionException {// throws InvalidActionException {
        phase.selectTarget(i);
        buttonNext();
    }
    //despues arreglar esto se supone q el jugador va  aelegir un aarma de las que hay en el inventario
    public void startPlaying(){
        phase.setController(this);
        phase.turn();
      //  phase.nextPhaseButton();
    }
    public void buttonNext(){
        if(getWinnerEnemy()||getWinnerPlayer()){
            //paramos
            System.out.println("hay un winner si que paramos");

        }
        else {
            System.out.println("no hay un winner si que continuamos al siguiente turno \n");
            phase.turn();
            phase.nextPhaseButton(); //comabia a la siguiente fase
            //Activa lo q sea q tiene  q hacer en ese  turno

        }
    }
    public void loop(){
        while (true){
            phase.turn();
            phase.nextPhaseButton();
        }
    }

    public List showEnemies() {
        LinkedList l = new LinkedList<>();
        for (Enemy e : enemies){
            l.add(e.getName());
        }
        return l;
    }

    public List showPlayers() {
        LinkedList l = new LinkedList<>();
        for (IPlayerCharacter e : players){
            l.add(e.getName());
        }
        return l;
    }

    public String getCurrentPhase() {
        return phase.toString();
    }

    public List showHpEnemies() {
        LinkedList l = new LinkedList<>();
        for (Enemy e : enemies){
            l.add(e.getHealthPoints());
        }
        return l;
    }
    public List showHpPlayer() {
        LinkedList l = new LinkedList<>();
        for (IPlayerCharacter e : players ){
            l.add(e.getHealthPoints());
        }
        return l;
    }

    public List showWeapons() {
        LinkedList l = new LinkedList<>();
        for (IWeapon e : inventory ){
            l.add(e.getName());
        }
        return l;
    }

    public List showTurns() {
        LinkedList l = new LinkedList<>();
        for (ICharacter e : turnsQueue ){
            l.add(e.getName());
        }
        return l;
    }


    public String showInstrucction() throws InvalidActionException {
       return phase.instruction();
    }
}


