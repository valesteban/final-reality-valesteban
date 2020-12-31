package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class ChoseWeaponPhase extends Phase {
    private IWeapon weapon  = null;


    /**
     * the enemy will atack a random player.
     */
    @Override
    public void turn() {
        //don do anything in here
    }

    /**
     * it will change tha phase of the controller to SelectTargetPhase.
     */
    @Override
    public void nextPhaseButton() {
        System.out.println(controller.getFirstCharacterQueue().getName());
        IPlayerCharacter i =(IPlayerCharacter)controller.getFirstCharacterQueue();
        System.out.println(i.getEquippedWeapon());
        changePhase(new SelectTargetPhase());
    }



    @Override
    public void thisWeapon(IWeapon weapon) {
        //we check that the weapon is in the inventory arrrrreeeee
        ///
        if (controller.getInventory().contains(weapon))
            controller.equipPlayer((IPlayerCharacter) controller.getFirstCharacterQueue(),weapon);
    }

    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "ChoseWeaponPhase";
    }

}
