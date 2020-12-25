package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

public interface IPhase {
    void changePhase(IPhase phase);
    void setController(GameController controller);
    void turn();
    void nextPhaseButton();


}
