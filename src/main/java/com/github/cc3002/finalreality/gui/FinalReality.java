package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.Controller.phases.InvalidActionException;
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

  private Button buttonNextPhase; //boton para pasar a la siguiente fase
  private Button starGame; //boton para pasar a la siguiente fase

  private Button axeButton;
  private Button bowButton;
  private Button knifeButton;
  private Button staffButton;
  private Button swordButton;

  private Button enemy1Button;
  private Button enemy2Button;
  private Button enemy3Button;
  private Button enemy4Button;
  private Button enemy5Button;

  private Button start;
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
    buttonNextPhase = createButton("attack",150,540);
    starGame = createButton("Start Turn",50,540);
    listTurns = createLabel(0,0);
    listWeapons = createLabel(0,25);

    HPlost = createLabel(500,300);

    whatToDo  = createLabel(300,230);





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



    axeButton = createButton("Axe",600,560);
    bowButton = createButton("Bow",650,560);;
    knifeButton = createButton("Knife",700,560);;
    staffButton = createButton("Staff",752,560);;
    swordButton = createButton("Sword",800,560);;

    enemy1Button = createButton("Enemy 1",575,520);;
    enemy2Button = createButton("Enemy 2",650,520);;
    enemy3Button = createButton("Enemy 3",725,520);;
    enemy4Button = createButton("Enemy 4",800,520);;
    enemy5Button = createButton("Enemy 5",875,520);;

    listWeapons.setText("Weapons : "+ controller.showWeapons());
    buttonNextPhase.setOnAction(new EventHandler<ActionEvent>() {
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

    //acciones para elegir a  quien voy a atacar
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

    startAnimator();
    return scene;
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
        //listTurns.setText("turns : " + controller.showTurns() );

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

    //setiando el controller
    //crearmos y agregamos las armas al inventario
    controller.createSword("SwordName",25,30);
    controller.createStaff("StaffName",23,29,3);
    controller.createKnife("KnifeName",18,32);
    controller.createAxe("AxeName",21,26);
    controller.createBow("BowName",22,34);

    //creamos players y enemies y los agregamos a sus respectivas listas y a la cola de turnos
    controller.createKnight( "nameKnight", "Knight",2);
    controller.createEnemy("nameEnemy1", 30, 4, 12);

    controller.createEngineer( "nameEngineer", "Engineer",3);
    controller.createEnemy( "nameEnemy2", 40, 3,14);
    controller.createEnemy("nameEnemy3", 39, 2, 10);
    controller.createThief( "nameThief", "Thief",5);
    controller.createEnemy("nameEnemy4",48,4,15);
    controller.createWhiteMage( "nameWhiteMage", "WhiteMage",1, 14);
    controller.createEnemy("nameEnemy5", 38, 1, 7);
    controller.createBlackMage( "nameBlackMage", "BlackMage",2, 12);

  }
}