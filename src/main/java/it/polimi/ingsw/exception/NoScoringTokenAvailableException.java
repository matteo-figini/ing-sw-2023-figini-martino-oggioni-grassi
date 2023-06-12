package it.polimi.ingsw.exception;

/**
 * This exception is raised in case there aren't scoring token on the common goal card and a scoring token is requested.
 */
public class NoScoringTokenAvailableException extends Exception {
    @Override
    public String getMessage() {
        return "EXCEPTION RAISED: There aren't scoring token on the common goal card.";
    }
}
