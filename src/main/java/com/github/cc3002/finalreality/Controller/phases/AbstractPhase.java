package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.Controller.GameController;
/**
 * A class that creates states of the turns.
 *
 * @author Valentina Esteban
 */
public abstract class AbstractPhase {
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
    public void changePhase(AbstractPhase phase){
        controller.setPhase(phase);
    }


    public void Turn(){

    }


}
