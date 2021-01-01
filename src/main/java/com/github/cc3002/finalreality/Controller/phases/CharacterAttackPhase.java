package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * A class that creates the state where the characters will attack and then they will be taken out
 * of the turn queue and start the timer to come back.
 *
 * @author Valentina Esteban
 */
public class CharacterAttackPhase extends Phase {


    public CharacterAttackPhase(ICharacter attacked){

        this.character = attacked;
    }

    @Override
    public void turn() {

        ICharacter c1 = controller.getFirstCharacterQueue();
        if (controller.getPlayers().contains(c1)){  // if it is a player
            controller.attackPlayers(c1,character);
        }
        else {                                      //if it is an enemy
            controller.enemyTurn(c1);
        }
      //  controller.hpLost(hp);

        //then we will take out the character of the turn queue and start the timer

        controller.pullOutCharacter();
        controller.timerCharacter(c1);
      //  controller.buttonNext();
    }
  //  public void hp(int oldHP){
  //      int attack = oldHP - character.getHealthPoints();
  //          return attack;
  //      }




    /**
     * it will change tha phase of the controller to FirstCharacterPhase.
     */
    @Override
    public void nextPhaseButton() {
        changePhase(new FirstCharacterPhase());
    }

    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "CharacterAttackPhase";
    }
}
