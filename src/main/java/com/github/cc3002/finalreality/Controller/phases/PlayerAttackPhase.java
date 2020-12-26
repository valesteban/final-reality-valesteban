package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Random;

public class PlayerAttackPhase extends Phase {


    /**
     * the enemy will atack a random player.
     */
    @Override
    public void turn() {
        ICharacter player = controller.getPlayerPosition(0);
        playerAttack(player);
    }


    private void playerAttack(ICharacter player){
        Random r = new Random();
        int i = r.nextInt(controller.getEnemies().size());     //elegimos un numero random
        ICharacter playerThatWillBeAttacked = controller.getEnemyPosition(i);
        player.attack(playerThatWillBeAttacked);
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
        return "PlayerAttackPhase";
    }

}
