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


    /**
     * it will take the first character unn the queue and add it as a variable and the
     * change the phase of the controller.
     */
    @Override
    public void turn() {
        ICharacter c1 =  controller.getFirstCharacterQueue();  //sacamos el peronaje inicial en la cola
        nextTo(c1);                       //cambiara  ala siguiente phase
    }

    /**
     * it will decided the next phase for the controller depending on the character
     * that the queue has.
     */
    public void nextTo(ICharacter character){
        ICharacter i = controller.getFirstCharacterQueue();

        if (controller.getPlayers().contains(character)){
            changePhase(new ChoseWeaponPhase());
        } else {
            changePhase(new CharacterAttackPhase(null));//changePhase();
            controller.buttonNext();
        }
    }

    @Override
    public String instruction(){
        return " To start the turn press the button start Turn";
    }
    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString(){
        return "FirstCharacterPhase";
    }




}
