package it.unitn.prog2.matteo_brusarosco;

import javafx.scene.paint.Color;

public class Wanderer extends Entity {
    int moveCount = 0;
    Wanderer() {
        super(Color.DARKBLUE);
    }

    @Override
    void move() {
        if (moveCount >= 5) {
            moveCount = 0;
            direction = rnd.nextInt(8);
        }

        super.move();
        moveCount++;
    }
}
