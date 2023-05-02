package it.polimi.ingsw.view;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ShelfCell;

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
    void askColumnAndPositions ();

    /**
     * Show a login response to the client.
     * @param validNickname {@code true} if the selected nickname is valid, {@code false} otherwise.
     * @param connectionEstablished {@code true} if a solid connection is established, {@code false} otherwise.
     */
    void showLoginResponse (boolean validNickname, boolean connectionEstablished);

    /**
     * Shows a generic message to the client.
     * @param genericMessage The text message to be shown.
     */
    void showGenericMessage (String genericMessage);

    /**
     * Show a matrix representing the board cells.
     * @param boardContent A matrix representing the board cells.
     */
    void showBoardContent (BoardCell[][] boardContent);

    /**
     * Show a matrix representing the shelf cells.
     * @param shelfContent A matrix representing the shelf cells.
     * @param nickname The nickname to which the shelf content belongs to.
     */
    void showShelfContent (ShelfCell[][] shelfContent, String nickname);

}
