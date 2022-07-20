package it.unitn.prog2.matteo_brusarosco;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameEndedWindow {
    GameEndedWindow(Stage gameEndedStage, int points) {
        VBox vbox = new VBox();

        vbox.getChildren().add(new Label("Points: " + points));
        vbox.getChildren().add(new Label("GAME OVER"));
        vbox.setAlignment(Pos.CENTER);
        gameEndedStage.setScene(new Scene(vbox, 200, 100));
        gameEndedStage.setTitle("Game ended");
        gameEndedStage.showAndWait();
    }
}
