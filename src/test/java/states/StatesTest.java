package states;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.Controller.handler.CharacterHandler;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

abstract class AbstractStatesTest {
    public BlockingQueue<ICharacter> turns;
    private GameController controller;

    public void basicSetUp(){

        turns = new LinkedBlockingQueue<>();

        controller = new GameController();

        controller.createSword("SwordName",15,10);
        controller.createStaff("StaffName",13,9,3);
        controller.createKnife("KnifeName",8,2);
        controller.createAxe("AxeName",11,6);
        controller.createBow("BowName",12,4);

        controller.createEnemy("nameEnemy1", 10, 10, 12);
        controller.createEngineer( "nameEngineer", "Engineer",6);
        controller.createEnemy( "nameEnemy1", 10, 7,14);
        controller.createKnight( "nameKnight", "Knight",4);
        controller.createThief( "nameThief", "Thief",5);
        controller.createEnemy("nameEnemy3",8,11,15);
        controller.createWhiteMage( "nameWhiteMage", "WhiteMage",5, 14);
        controller.createBlackMage( "nameBlackMage", "BlackMage",8, 12);

    }

}
