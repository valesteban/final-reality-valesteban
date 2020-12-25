package com.github.cc3002.finalreality.Controller.phases;

import com.github.cc3002.finalreality.Controller.GameController;

public interface IPhase {
    void changePhase(IPhase phase);
    void setController(GameController controller);
    void turn();

}
