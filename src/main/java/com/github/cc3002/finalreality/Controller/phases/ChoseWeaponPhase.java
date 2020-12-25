package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class ChoseWeaponPhase extends AbstractPhase{


    /**
     * the enemy will atack a random player.
     */
    @Override
    public void turn() {
        //equippingTheCharacter();

    }

    public void equippingTheCharacter(IWeapon weapon) {
        controller.equipPlayer(controller.getPlayerPosition(0),weapon);
    }

    /**
     * it will change tha phase of the controller to pullOutCharacter.  ---------creo q esto se activara cuando se aprete un boton
     */
    @Override
    public void nextPhaseButton() {
        changePhase(new PlayerAttackPhase());
    }

    @Override
    public void ThisWeapon(IWeapon weapon) {
        controller.equipPlayer(controller.getPlayerPosition(0),weapon);
    }

    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "ChoseWeaponPhase";
    }

}
