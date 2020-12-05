package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;
/**
 * A class that create a handler/listener for characters.
 *
 * @author Valentina Esteban
 */
public class CharacterHandler implements IEveventHandler {
    private final GameController controller;

    /**
     * Creates a handler.
     * @param controller
     *     object controller
     */
    public CharacterHandler(GameController controller){
        this.controller = controller;
    }

    /**
     * It will run when a character is dead.
     *
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.isAttackedCharacter((ICharacter) evt.getNewValue());
    }
}

