package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

/**
 * A class that creates states of the turns.
 *
 * @author Valentina Esteban
 */
public abstract class AbstractPhase implements IPhase{
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
    public void changePhase(IPhase phase){
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


}
