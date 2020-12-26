package com.github.cc3002.finalreality.Controller.phases;

public class CheckTurnQueuePhase extends Phase {

    /**
     *
     */
    @Override
    public void turn() {
        //no hace nad apor ahora
    }

    /**
     * it will change tha phase of the controller to pullOutCharacter.  ---------creo q esto se activara cuando se aprete un boton
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
        return "CheckTurnQueuePhase";
    }

}
