package it.polimi.ingsw.exception;

/**
 * This exception is raised in case there aren't scoring token on the common goal card.
 * Since the maximum number of the player is 4, theoretically this exception cannot be raised; if it's raised there's an error
 * on the implementation...
 */
public class NoScoringTokenAvailableException extends Exception {
    @Override
    public String getMessage() {
        return "EXCEPTION RAISED: There aren't scoring token on the common goal card.";
    }
}
