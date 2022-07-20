package it.unitn.prog2.matteo_brusarosco;

import javafx.scene.paint.Color;

public class Striker extends Entity {
    Striker() {
        super(Color.BLUE);
        direction = rnd.nextInt(8);
    }
}
