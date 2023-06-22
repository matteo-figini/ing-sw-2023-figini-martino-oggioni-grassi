package it.polimi.ingsw.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * This immutable class represents a couple of 2D coordinates, useful e.g., in the shelf or on the board.
 */
public record Position(int x, int y) implements Serializable {
    /**
     * This constructor creates a new object with the coordinates specified in input.
     * @param x Row coordinate.
     * @param y Column coordinate.
     */
    public Position {
    }

    /**
     * @return the value of x coordinate.
     */
    @Override
    public int y() {
        return y;
    }

    /**
     * @return the value of y coordinate.
     */
    @Override
    public int x() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return x() == position.x() && y() == position.y();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x(), y());
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}