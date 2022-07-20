package it.unitn.prog2.matteo_brusarosco;

import javafx.scene.paint.Color;

public class Bubbler extends Wanderer {
    Bubbler() {
        entityColor = Color.LIGHTBLUE;
        setFill(entityColor);
    }

    @Override
    void move() {
        if (rnd.nextDouble() <= 0.10) {
            setSize(getSize() + getSize()*0.2);
        }

        super.move();
    }
}
