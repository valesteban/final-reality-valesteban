package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class PollAndWaitCharacterPhase extends Phase {


    /**
     * it will remove the character from the turn queue.
     */
    @Override
    public void turn() {
        ICharacter c1 = controller.getFirstCharacterQueue();
        controller.pullOutCharacter();
        controller.timerCharacter(c1); //here we will wait th time of the weight of the character
    }

    /**
     * it will change tha phase of the controller when a button is clicked.
     */
    @Override
    public void nextPhaseButton(){
        changePhase(new CheckTurnQueuePhase());
    }

    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "pullOutCharacterPhase";
    }
}
