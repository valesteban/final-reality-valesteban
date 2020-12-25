package com.github.cc3002.finalreality.Controller.phases;

public class SelectAttackTargetPhase extends AbstractPhase{


    /**
     * the enemy will atack a random player.
     */
    @Override
    public void turn() {

    }

    /**
     * it will change tha phase of the controller to PollAndWaitCharacterPhase.
     */
    @Override
    public void nextPhaseButton() {
        changePhase(new PollAndWaitCharacterPhase());
    }

    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "SelectAttackTargetPhase";
    }

}
