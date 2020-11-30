package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class GameController {
    private final IEveventHandler characterAttackedHandler = new CharacterHandler(this);

    public GameController(){

    }

    public void isAttackedCharacter(ICharacter character){
        //aqui lo eliminamos de la lista

    }
}
