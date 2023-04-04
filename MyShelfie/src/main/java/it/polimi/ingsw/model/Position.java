package it.polimi.ingsw.model;

/**
 * This immutable class represents a couple of 2D coordinates, useful eg. in the shelf or on the board.
 */
public class Position {
    private int x, y;

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
}