package it.polimi.ingsw.exception;

/**
 * This exception is thrown when there aren't enough free cells on the shelf and a player tries to insert item tiles in it.
 */
public class NotEnoughCellsException extends Exception {
    @Override
    public String getMessage() {
        return "EXCEPTION RAISED: There aren't enough free cells on the shelf.";
    }
}
