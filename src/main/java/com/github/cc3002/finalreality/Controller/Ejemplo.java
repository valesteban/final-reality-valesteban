package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Ejemplo {



    public Knight knightTest;
    public Engineer engineerTest;
    public BlackMage blackMageTest;
    public WhiteMage whiteMageTest;
    public IWeapon testWeapon;

    public static void main(String [ ] args ){
        BlockingQueue<ICharacter> turns =new LinkedBlockingQueue<>();;
        Enemy enemyTest = new Enemy(turns,"enemy ",5,2,33);
        Thief thiefTest = new Thief(turns,"thief ",2);
        Sword swordTest = new Sword("nide",12,5);
        thiefTest.equip(swordTest);
        enemyTest.attack(thiefTest);
        enemyTest.attack(thiefTest);
        enemyTest.attack(thiefTest);
        enemyTest.attack(thiefTest);
        enemyTest.attack(thiefTest);
        enemyTest.attack(thiefTest);
        enemyTest.attack(thiefTest);
        System.out.println("vide del ladron " + thiefTest.getHealthPoints());



    }
}
