package it.unitn.prog2.matteo_brusarosco;

import javafx.scene.paint.Color;

public class Player extends Entity {
    Player() {
        super(Color.ORANGE);
    }

    void move(int direction) {
        this.direction = direction;
        super.move();
    }

    public boolean isColliding(Entity e) {
        if (!e.collisionDeactivated) {
            double diffX = Math.pow((e.posX - posX), 2);
            double diffY = Math.pow((e.posY - posY), 2);
            double distance = Math.sqrt(diffX+diffY);
            double actualDistance = distance-getSize()-e.getSize();
            return actualDistance <= 0;
        }

        return false;
    }
}
