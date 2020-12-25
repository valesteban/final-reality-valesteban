package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class PlayerAttackPhase extends AbstractPhase{


    /**
     * the enemy will atack a random player.
     */
    @Override
    public void turn() {
        attackEnemy();
    }
    /**
     * por ahora siempre va a atacar al enemigo que venga primero en la lista de enemigos del controllwe
     *  arrrrrrrrreeeeggglarr.
     */
    private void attackEnemy() {
        ICharacter player = controller.getPlayerPosition(0);
        ICharacter enemy = controller.getEnemyPosition(0);
        controller.attackPlayers(player,enemy);
    }

    /**
     * it will change tha phase of the controller to PollAndWaitCharacterPhase.
     */
    @Override
    public void nextPhaseButton() {
        changePhase(new PollAndWaitCharacterPhase());
    }

    /**
     * returns a string with the name of the phase.
     */
    @Override
    public String toString() {
        return "SelectAttackTargetPhase";
    }

}
