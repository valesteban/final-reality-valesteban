package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * A class that creates the state where the characters will attack and then they will
 * be taken out of the turn queue and start the timer to come back.
 *
 * @author Valentina Esteban
 */
public class CharacterAttackPhase extends Phase {
    /**
     * Creates a new player CharacterAttackPhase.
     *
     * @param attacked
     *     the enemy that will be attacked.
     */
    public CharacterAttackPhase(ICharacter attacked){
        this.character = attacked;
    }
    /**
     * it make that the first player in the turnQueue attack the enemy choosen,then it will take aout
     * the player of the queue of turn and make it wait.
     */
    @Override
    public void turn() {

        ICharacter c1 = controller.getFirstCharacterQueue();
        if (controller.getPlayers().contains(c1)){  // if it is a player
            controller.attackPlayers(c1,character);
        }
        else {                                      //if it is an enemy
            controller.enemyTurn(c1);
        }
        controller.pullOutCharacter();
        controller.timerCharacter(c1);
    }
    /**
     * it will change tha phase of the controller to FirstCharacterPhase.
     */
    @Override
    public void nextPhaseButton() {
        changePhase(new FirstCharacterPhase());
    }
}
