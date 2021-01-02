package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class SelectTargetPhase extends Phase {

    /**
     * it will change tha phase of the controller to CharacterAttackPhase.
     */
    @Override
    public void nextPhaseButton() throws InvalidActionException {
        changePhase(new CharacterAttackPhase(this.character));
        controller.buttonNext();
    }
    /**
     * the controller will give the number in the list of enemy of the enemy that will be attacked
     * and it will save him in the variable.
     */
    public void selectTarget(int i){
        ICharacter c1 = controller.getEnemyPosition(i);
        this.character = c1;
    }
    /**
     * returns a string with the instruction of the phase.
     */
    @Override
    public String instruction(){
        return "Choose a Enemy to attack";
    }
    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "SelectTargetPhase";
    }

}
