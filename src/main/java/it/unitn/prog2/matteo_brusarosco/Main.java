package it.unitn.prog2.matteo_brusarosco;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {
    int points = 0;
    Random rnd = new Random();
    boolean gameEnded = false;

    @Override
    public void start(Stage primaryStage) {
        Player player = new Player();
        List<Entity> entities = new ArrayList<>();
        entities.add(new Striker());
        entities.add(new Wanderer());
        entities.add(new Bubbler());

        BorderPane root = new BorderPane();
        root.getChildren().add(player);
        root.getChildren().addAll(entities);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new HandlePlayerInput(player, entities, root));
        primaryStage.setTitle("Escape!");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    class HandlePlayerInput implements EventHandler<KeyEvent> {
        Player player;
        List<Entity> entities;

        Pane gamePane;
        HandlePlayerInput(Player player, List<Entity> entities, Pane gamePane) {
            this.player = player;
            this.entities = entities;
            this.gamePane = gamePane;
        }

        @Override
        public void handle(KeyEvent keyEvent) {
            if (!gameEnded) {
                if (!"UpDownLeftRight".contains(keyEvent.getCode().getName())) return;

                String direction = keyEvent.getCode().getName();
                player.move(_directionToInt(direction));

                for (Entity e:
                        entities) {
                    e.move();
                }


                // generate a new random entity with a 10% probability
                if (rnd.nextDouble() <= 0.1) {
                    int entityType = rnd.nextInt(3);
                    System.out.println(entityType);
                    Entity newEntity;
                    switch (entityType) {
                        case 0: newEntity = new Wanderer(); break;
                        case 1: newEntity = new Striker(); break;
                        default: newEntity = new Bubbler(); break;
                    }

                    entities.add(newEntity);
                    gamePane.getChildren().add(newEntity);
                }

                boolean collisionDetected = false;
                for (Entity e:
                        entities) {
                    if (player.isColliding(e)) {
                        collisionDetected = true;
                        break;
                    }
                }

                if (collisionDetected) {
                    gameEnded = true;
                    new GameEndedWindow(new Stage(), points);

                } else {
                    points+= 100;
                }
            }

        }

        private int _directionToInt(String direction) {
            switch (direction) {
                case "Up": return 0;
                case "Down": return 4;
                case "Left": return 6;
                default: return 2;
            }
        }
    }

}