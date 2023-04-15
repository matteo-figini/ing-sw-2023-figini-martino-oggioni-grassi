package it.polimi.ingsw.exception;

/**
 * This exception is raised when the tiles requested from the board are not in correct positions.
 */
public class WrongPositionsException extends Exception {
    @Override
    public String getMessage() {
        return "EXCEPTION RAISED: the tiles requested from the board are not in correct positions.";
    }
}
