package it.polimi.ingsw.model;

/**
 * This class represents the coordinates inside the shelf, that can be useful for specifying where to insert & pick up
 * the item tiles.
 */
public class Position {
    private int x, y; // Coordinates

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}