package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;

/**
 * A class that creates the state of taking the first character of the queue.
 *
 * @author Valentina Esteban
 */
public class FirstCharacterPhase extends Phase {
    /**
     * it will take the first character of the queue and add it as a variable and the
     * change the phase of the controller.
     */
    @Override
    public void turn() throws InvalidActionException {
        ICharacter c1 =  controller.getFirstCharacterQueue();
        nextTo(c1);
    }
    /**
     * it will decided the next phase for the controller depending on the character
     * that the queue has.
     */
    public void nextTo(ICharacter character) throws InvalidActionException {
        ICharacter i = controller.getFirstCharacterQueue();

        if (controller.getPlayers().contains(character)){
            changePhase(new ChoseWeaponPhase());
        } else {
            changePhase(new CharacterAttackPhase(null));//changePhase();
            controller.buttonNext();
        }
    }
    /**
     * returns a string with the instruction of the phase.
     */
    @Override
    public String instruction(){
        return "To start the turn press the button start Turn";
    }
    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString(){
        return "FirstCharacterPhase";
    }
}
