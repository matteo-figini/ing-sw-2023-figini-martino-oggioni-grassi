package it.polimi.ingsw.exception;

/**
 * This exception is thrown when there aren't enough free cells on the shelf.
 */
public class NotEnoughCellsException extends Exception {
    @Override
    public String getMessage() {
        return "EX: There are not enough free cells on the shelf.";
    }
}
