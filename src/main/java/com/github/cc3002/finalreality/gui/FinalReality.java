package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.Controller.phases.InvalidActionException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import java.util.List;

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

    primaryStage.show();
  }



  private @NotNull Scene createScene1() throws FileNotFoundException {
    var background =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo.jpg")));
    root.getChildren().add(background);
    buttonNextPhase = createButton("next Phase",150,540);
    starGame = createButton("Start Turn",50,540);
    listTurns = createLabel(0,0);
    listWeapons = createLabel(0,25);




    listEnemies = createLabel(0,75);
    listHPEnemies = createLabel(0, 100);
    listPlayers = createLabel(500,75);
    listHPPlayers = createLabel(500,100);
    phaseLabel = createLabel(0,150);
    starGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.startPlaying();
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
        controller.buttonNext();
      }
    });
    //acciones de los botones para armar
    swordButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.thisWeaponButton(controller.getInventory().get(0));
      }
    });
    staffButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.thisWeaponButton(controller.getInventory().get(1));
      }
    });
    knifeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.thisWeaponButton(controller.getInventory().get(2));
      }
    });
    axeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.thisWeaponButton(controller.getInventory().get(3));
      }
    });
    bowButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.thisWeaponButton(controller.getInventory().get(4));
      }
    });

    //acciones para elegir a  quien voy a atacar
    enemy1Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.selectingEnemy(0);
      }
    });
    enemy2Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.selectingEnemy(1);
      }
    });
    enemy3Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.selectingEnemy(2);
      }
    });
    enemy4Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.selectingEnemy(3);
      }
    });
    enemy5Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.selectingEnemy(4);
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
        listTurns.setText("turns : " + controller.showTurns() );

        phaseLabel.setText("Phase : " + controller.getCurrentPhase() );
      }
    };
    timer.start();
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
    controller.createSword("SwordName",15,30);
    controller.createStaff("StaffName",13,29,3);
    controller.createKnife("KnifeName",8,32);
    controller.createAxe("AxeName",11,26);
    controller.createBow("BowName",12,34);

    //creamos players y enemies y los agregamos a sus respectivas listas y a la cola de turnos
    controller.createKnight( "nameKnight", "Knight",2);
    controller.createEnemy("nameEnemy1", 30, 4, 12);

    controller.createEngineer( "nameEngineer", "Engineer",3);
    controller.createEnemy( "nameEnemy2", 40, 3,14);
    controller.createEnemy("nameEnemy3", 39, 2, 10);
    controller.createThief( "nameThief", "Thief",5);
    controller.createEnemy("nameEnemy4",28,4,15);
    controller.createWhiteMage( "nameWhiteMage", "WhiteMage",1, 14);
    controller.createEnemy("nameEnemy5", 38, 1, 7);
    controller.createBlackMage( "nameBlackMage", "BlackMage",2, 12);

  }
}