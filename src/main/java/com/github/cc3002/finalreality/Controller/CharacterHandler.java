package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;

public class CharacterHandler implements IEveventHandler {
    private final GameController controller;

    public CharacterHandler(GameController controller){
        this.controller = controller;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.isAttackedCharacter((ICharacter) evt.getNewValue());
    }
}

