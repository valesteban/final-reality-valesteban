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



  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    //setiando el controller
    //crearmos y agregamos las armas al inventario
    controller.createSword("SwordName",15,10);
    controller.createStaff("StaffName",13,9,3);
    controller.createKnife("KnifeName",8,2);
    controller.createAxe("AxeName",11,6);
    controller.createBow("BowName",12,4);

    //creamos players y enemies y los agregamos a sus respectivas listas y a la cola de turnos
    controller.createEnemy("nameEnemy1", 10, 10, 12);
    controller.createEngineer( "nameEngineer", "Engineer",6);
    controller.createEnemy( "nameEnemy1", 10, 7,14);
    controller.createKnight( "nameKnight", "Knight",4);
    controller.createThief( "nameThief", "Thief",5);
    controller.createEnemy("nameEnemy3",8,11,15);
    controller.createWhiteMage( "nameWhiteMage", "WhiteMage",5, 14);
    controller.createBlackMage( "nameBlackMage", "BlackMage",8, 12);

    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);

    var background =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo4.jpg")));
    root.getChildren().add(background);

    Scene scene = createScene();
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private @NotNull Scene createScene(){
    Scene scene = new Scene(root,690,490);
    buttonNextPhase = createButton("next Phase",150,440);
    starGame = createButton("Start Turn",50,440);
    listTurns = createLabel(0,200);
    listEnemies = createLabel(0,50);
    listHPEnemies = createLabel(0, 75);
    listPlayers = createLabel(0,100);
    listHPPlayers = createLabel(0,125);
    phaseLabel = createLabel(0,150);
    listWeapons = createLabel(0,175);

    axeButton = createButton("Axe",400,440);
    bowButton = createButton("Bow",450,440);;
    knifeButton = createButton("Knife",500,440);;
    staffButton = createButton("Staff",552,440);;
    swordButton = createButton("Sword",600,440);;

    listWeapons.setText("Weapons : "+ controller.showWeapons());
    buttonNextPhase.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.buttonNext();
      }
    });
    starGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.startPlaying();
      }
    });
    axeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.ThisWeaponButton(controller.getInventory().get(3));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    swordButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.ThisWeaponButton(controller.getInventory().get(0));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    staffButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.ThisWeaponButton(controller.getInventory().get(1));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    knifeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.ThisWeaponButton(controller.getInventory().get(2));
        } catch (InvalidActionException e) {
          e.printStackTrace();
        }
      }
    });
    bowButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          controller.ThisWeaponButton(controller.getInventory().get(4));
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
}