package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
/**
 * A class that creates the state where the characters will be equip with weapon.
 *
 * @author Valentina Esteban
 */
public class ChoseWeaponPhase extends Phase {
    private IWeapon weapon  = null;

    /**
     * it will change tha phase of the controller to SelectTargetPhase.
     */
    @Override
    public void nextPhaseButton() {
        changePhase(new SelectTargetPhase());
    }
    /**
     * it will return a string with the instruction of the phase.
     */
    @Override
    public String instruction(){
        return "Choose a weapon";
    }
    /**
     * the controller will give a weapon will it tell to equipped the player.
     */
    @Override
    public void selectWeapon(IWeapon weapon) {
        if (controller.getInventory().contains(weapon))
            controller.equipPlayer( controller.getFirstCharacterQueue(),weapon);
    }
    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "ChoseWeaponPhase";
    }

}
