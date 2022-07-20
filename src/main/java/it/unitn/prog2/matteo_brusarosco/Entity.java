package it.unitn.prog2.matteo_brusarosco;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public abstract class Entity extends Circle {
    final int GAME_SIZE_X = 500;
    final int GAME_SIZE_Y = 500;

    private double _size = 20;
    int stepSize = 10;
    int posX = 0;
    int posY = 0;
    int direction = 0;
    Color entityColor;
    Random rnd;

    Entity(Color color) {
        super(20);
        this.entityColor = color;
        setFill(this.entityColor);
        rnd = new Random();
        posX = rnd.nextInt(GAME_SIZE_X);
        posY = rnd.nextInt(GAME_SIZE_Y);
        setPosition();
    }

    Entity(int posX, int posY, Color color) {
        this(color);
        this.posX = posX;
        this.posY = posY;
    }

    public void setSize(double newSize) {
        this._size = newSize;
        this.setRadius(newSize);
    }

    public double getSize() {
        return this._size;
    }

    public void checkBoundary() {
        int size = (int) Math.floor(_size);
        if (posX+_size < 0) {
            posX = GAME_SIZE_X-size;
        } else if (posX >= GAME_SIZE_X) {
            posX = -size;
        }


        if (posY+_size < 0) {
            posY = GAME_SIZE_Y-size;
        } else if (posY >= GAME_SIZE_Y) {
            posY = -size;
        }
    }

    void move() {
        switch (direction) {
            case 0:
                posY-=stepSize;
                break;
            case 1:
                posX += stepSize;
                posY -= stepSize;
                break;
            case 2:
                posX += stepSize;
                break;
            case 3:
                posX += stepSize;
                posY += stepSize;
                break;
            case 4:
                posY += stepSize;
                break;
            case 5:
                posX -= stepSize;
                posY += stepSize;
                break;
            case 6:
                posX -= stepSize;
                break;
            default:
                posX -= stepSize;
                posY -= stepSize;
                break;
        }

        checkBoundary();
        setPosition();
    }

    public void setPosition() {
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}
