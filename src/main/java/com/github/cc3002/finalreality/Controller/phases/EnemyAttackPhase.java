package com.github.cc3002.finalreality.Controller.phases;


import com.github.cc3002.finalreality.model.character.ICharacter;

/**
 * A class that creates the state where the enemy will attack a random player.
 *
 * @author Valentina Esteban
 */
public class EnemyAttackPhase extends AbstractPhase {
    private ICharacter attacker ;

    public EnemyAttackPhase(ICharacter enemy){
        this.attacker = enemy;
    }

    /**
     * the enemy will atack a random player.
     */
    @Override
    public void turn() {
        controller.enemyTurn(attacker);
    }

    /**
     * it will change tha phase of the controller to pullOutCharacter.  ---------creo q esto se activara cuando se aprete un boton
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
        return "EnemyAttackPhase";
    }

}
