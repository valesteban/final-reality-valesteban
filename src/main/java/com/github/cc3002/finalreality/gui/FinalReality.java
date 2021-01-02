package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.Controller.phases.InvalidActionException;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
  private static final String RESOURCE_PATH = "src/main/resources/";
  private GameController controller = new GameController();


  private final Group root = new Group();
  private Label phaseLabel;  //muestra la phase en que estamos
  private Label listTurns;  //muestra la phase en que estamos
  private Label listEnemies;  //lisa de enemigos
  private Label listHPEnemies;  //lista ded players
  private Label listPlayers;  //lista ded players
  private Label listHPPlayers;  //lista ded players
  private Label listWeapons;  //lista de weapons

  private Label HPlost;
  private Label whatToDo; //le dira al usuario que hacer


  private Button reStartGame;
  Button start;// = createButton("start",500,500);
  Scene scene;



  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    createWeaponAndCharacters();
    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);
    scene = new Scene(root, 1000,625);
    var background =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "k2.jpg")));
    root.getChildren().add(background);
    start = createButton("start",500,500);

    start.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          scene = createScene1();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }
    });
    primaryStage.setScene(scene);
    if (controller.getWinnerPlayer()||controller.getWinnerEnemy()){
      scene = createWinnerLoserScene();
    }
    primaryStage.show();
  }

  private @NotNull Scene createScene1() throws FileNotFoundException {
    var background =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo.jpg")));
    root.getChildren().add(background);

    //this are the labels that will be changing
    listTurns = createLabel(0,0);
    listWeapons = createLabel(0,25);
    HPlost = createLabel(500,300);
    whatToDo  = createLabel(300,230);

     //we create the button and its position
     Button axeButton = createButton("Axe",600,560);
     Button bowButton = createButton("Bow",650,560);
     Button knifeButton = createButton("Knife",700,560);
     Button staffButton = createButton("Staff",752,560);
     Button swordButton = createButton("Sword",800,560);

     Button enemy1Button = createButton("Enemy 1",575,520);
     Button enemy2Button = createButton("Enemy 2",650,520);
     Button enemy3Button = createButton("Enemy 3",725,520);
     Button enemy4Button = createButton("Enemy 4",800,520);
     Button enemy5Button = createButton("Enemy 5",875,520);

     Button starGame = createButton("Start Turn",50,540);
     Button buttonAttack = createButton("attack",150,540);

    listEnemies = createLabel(0,75);
    listHPEnemies = createLabel(0, 100);
    listPlayers = createLabel(500,75);
    listHPPlayers = createLabel(500,100);
    phaseLabel = createLabel(0,150);
    starGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.startPlaying();
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    reStartGame = createButton("reStart Game",325,540);

    listWeapons.setText("Weapons : "+ controller.showWeapons());
    buttonAttack.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.buttonNext();
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    //acciones de los botones para armar
    swordButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.thisWeaponButton(controller.getInventory().get(0));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    staffButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.thisWeaponButton(controller.getInventory().get(1));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    knifeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.thisWeaponButton(controller.getInventory().get(2));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    axeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.thisWeaponButton(controller.getInventory().get(3));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    bowButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.thisWeaponButton(controller.getInventory().get(4));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });

    //buttons for who I´m going to attack
    enemy1Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.selectingEnemy(0);
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    enemy2Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.selectingEnemy(1);
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    enemy3Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.selectingEnemy(2);
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    enemy4Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.selectingEnemy(3);
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    enemy5Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.selectingEnemy(4);
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });

    Button endGame;
    endGame = createButton("End Game",425,540);
    endGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        ImageView background =
                null;
        try {
          background = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "k2.jpg")));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        root.getChildren().add(background);

        Label END = createLabel(500,500);
        END.setText("END");
      }
    });
    reStartGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        resetGame();
      }
    });
    startAnimator();
    return scene;
  }
  private void resetGame() {
    controller.reStart();
    createWeaponAndCharacters();
  }
  private void startAnimator(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        //aqui tienen que ri las cosas que se van a ir actualizando

        listEnemies.setText("Enemies : "+ controller.showEnemies());
        listHPEnemies.setText("Enemies HP : "+ controller.showHpEnemies());
        listPlayers.setText("Players : "+ controller.showPlayers());
        listHPPlayers.setText("Players HP : "+ controller.showHpPlayer());
        listTurns.setText("turns : " + controller.showTurns() );

        try {
          whatToDo.setText("Instructions: "+controller.showInstrucction());
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }

        //  HPlost.setText("HP lost : " + controller.HPlost());


        phaseLabel.setText("Phase : " + controller.getCurrentPhase() );
        }

    };
    timer.start();
  }
  private @NotNull Scene createWinnerLoserScene() throws FileNotFoundException {
    var background =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "kirby.jpg")));
    return scene;
  }
  private @NotNull Label createLabel(int xPos,int yPos){
    Label label = new Label();
    label.setLayoutX(xPos);
    label.setLayoutY(yPos);
    root.getChildren().add(label);
    return label;

  }
  private @NotNull Button createButton(String name,int xPos,int yPos){
    Button button = new Button(name);
    button.setLayoutY(yPos);
    button.setLayoutX(xPos);
    root.getChildren().add(button);
    return button;
  }
  private void createWeaponAndCharacters(){
    Random r = new Random();

    //damage will be between 20-40
    //weight will be between 30-50
    //protection will be between 8-10

    //we set the controller
    //we create weapons
    controller.createSword("SwordName",r.nextInt(40)+20,r.nextInt(50)+30);
    controller.createStaff("StaffName",r.nextInt(40)+20,r.nextInt(50)+30,3);
    controller.createKnife("KnifeName",r.nextInt(40)+20,r.nextInt(50)+30);
    controller.createAxe("AxeName",r.nextInt(40)+20,r.nextInt(50)+30);
    controller.createBow("BowName",r.nextInt(40)+20,r.nextInt(50)+30);

    //we create players and enemies and add it to its list and the queue of turns
    controller.createKnight( "nameKnight", "Knight",r.nextInt(10)+8);
    controller.createEnemy("nameEnemy1", r.nextInt(50)+30, r.nextInt(10)+8, r.nextInt(40)+20);
    controller.createEngineer( "nameEngineer", "Engineer",r.nextInt(10)+8);
    controller.createEnemy( "nameEnemy2", r.nextInt(50)+30, r.nextInt(10)+8,r.nextInt(40)+20);
    controller.createEnemy("nameEnemy3", r.nextInt(50)+30, r.nextInt(10)+8, r.nextInt(40)+20);
    controller.createThief( "nameThief", "Thief",r.nextInt(10)+8);
    controller.createEnemy("nameEnemy4",r.nextInt(50)+30,r.nextInt(10)+8,r.nextInt(40)+20);
    controller.createWhiteMage( "nameWhiteMage", "WhiteMage",r.nextInt(10)+8, 14);
    controller.createEnemy("nameEnemy5", r.nextInt(50)+30, r.nextInt(10)+8, r.nextInt(40)+20);
    controller.createBlackMage( "nameBlackMage", "BlackMage",r.nextInt(10)+8, 12);
  }
}