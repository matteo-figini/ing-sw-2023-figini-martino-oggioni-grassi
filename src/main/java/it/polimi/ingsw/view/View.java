package it.polimi.ingsw.view;

/**
 * This interface represents all the methods for the specific views. Every type of view (CLI, GUI with Swing/JavaFX,
 * virtual views on the server...) must implement this interface.
 */
public interface View {

    /**
     * Asks the user to set a nickname.
     */
    void askNickname ();

    /**
     * Asks the first user to set the players number.
     */
    void askPlayersNumber ();

    /**
     * Asks the user a column on his shelf and a list of positions on which to draw the tiles from the board.
     */
    void askUserColumnAndPositions ();

    /**
     * Shows a generic message to the client.
     * @param genericMessage The text message to be shown.
     */
    void showGenericMessage (String genericMessage);

}
