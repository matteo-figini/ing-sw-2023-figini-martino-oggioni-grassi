package it.polimi.ingsw.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * This immutable class represents a couple of 2D coordinates, useful eg. in the shelf or on the board.
 */
public class Position implements Serializable {
    private final int x;
    private final int y;

    /**
     * This constructor creates a new object with the coordinates specified in input.
     * @param x Row coordinate.
     * @param y Column coordinate.
     */
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the value of x coordinate.
     * @return the value of x coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Get the value of y coordinate.
     * @return the value of y coordinate.
     */
    public int getX() {
        return x;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return getX() == position.getX() && getY() == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}