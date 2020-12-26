package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * A class that creates states of the turns.
 *
 * @author Valentina Esteban
 */
public  class Phase {
    protected GameController controller;

    /**
     * Sets the controller.
     */
    public void setController(GameController controller){
        this.controller = controller;
    }
    /**
     * Change the actual phase to another one.
     */
    public void changePhase(Phase phase){
        controller.setPhase(phase);
    }


    public void turn(){
        System.out.println("algo fue malo llegamos al turno de la clase abstracta de las fases");
    }


    /**
     * botones activaran esta funcion para cambiar de fase en el caso de las
     * primeras fases no hara nada
     */
    public void nextPhaseButton(){
        //botones
    }

    public void ThisWeapon(IWeapon weapon) throws InvalidActionException {
        throw new InvalidActionException("can´t use this in "+ this.toString());
    }


}
