package it.polimi.ingsw.exception;

/**
 * This exception is raised in case of the number of the cards to extract is not positive or greater than
 * the available size.
 */
public class WrongNumberOfCardsException extends Exception {
    @Override
    public String getMessage () {
        return "EXCEPTION RAISED: The number of the cards to extract is not positive or greater than the available size.";
    }
}
