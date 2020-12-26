package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Random;

/**
 * A class that creates the state of taking the first character of the queue.
 *
 * @author Valentina Esteban
 */
public class FirstCharacterPhase extends Phase {


    @Override
    public void turn() {
        ICharacter c1 =  controller.getFirstCharacterQueue();
        changeTo(c1);
    }

    /**
     * it will decided the next phase for the controller depending on the character
     * that the queue has.
     */
    public void changeTo(ICharacter character){

        if (controller.getPlayers().contains(character)){
            changePhase(new ChoseWeaponPhase());
        } else {
            changePhase(new EnemyAttackPhase(character));//changePhase();
        }
    }



    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString(){
        return "FirstCharacterPhase";
    }



}
