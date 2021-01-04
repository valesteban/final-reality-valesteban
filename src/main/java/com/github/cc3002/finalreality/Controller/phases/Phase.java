package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * A class that creates states of the turns.
 *
 * @author Valentina Esteban
 */
public  class Phase {
    protected GameController controller;
    protected ICharacter character = null;


    /**
     * Sets the controller.
     */
    public void setController(GameController controller){
        this.controller = controller;
    }
    /**
     * it will change the actual phase to another one.
     */
    public void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    /**
     * it will do nothing.
     */
    public void turn(){
    }
    /**
     * it will throw an exceptionCreates with a message of why.
     */
    public void nextPhaseButton()throws InvalidActionException {
        throw new InvalidActionException("can´t use this in"+ this.toString());
    }
    /**
     * it will throw an exceptionCreates with a message of why.
     */
    public void selectWeapon(IWeapon weapon) throws InvalidActionException {
        throw new InvalidActionException("can´t choose a weapon to use in  "+ this.toString());
    }
    /**
     * it will throw an exceptionCreates with a message of why.
     */
    public void selectTarget(int i) throws  InvalidActionException{
        throw new InvalidActionException("can´t choose an Enemy to attack in" + this.toString());
    }
    /**
     * it will throw an exceptionCreates with a message of why.
     */
    public String instruction()throws  InvalidActionException{
        throw new InvalidActionException("can´t choose an Enemy to attack in" + this.toString());}
}

