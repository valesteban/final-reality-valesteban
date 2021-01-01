package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class SelectTargetPhase extends Phase {


    @Override
    public void turn() {

    }

    /**
     * it will change tha phase of the controller to CharacterAttackPhase.
     */
    @Override
    public void nextPhaseButton() {
        changePhase(new CharacterAttackPhase(this.character));
        controller.buttonNext();
    }
    public void selectTarget(int i){
        ICharacter c1 = controller.getEnemyPosition(i);
        this.character = c1;
    }


    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "SelectTargetPhase";
    }

}
