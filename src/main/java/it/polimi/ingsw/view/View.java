package it.polimi.ingsw.view;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.message.Message;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This interface represents all the methods for the specific views. Every type of view (CLI, GUI with Swing/JavaFX,
 * virtual views on the server...) must implement this interface.
 */
public interface View {

    /**
     * Asks the user to set a nickname.
     */
    void askNickname () throws IOException;

    /**
     * Asks the first user to set the players number.
     */
    void askPlayersNumber ();

    /**
     * Send a message to open waiting room scene
     */
    void waitingRoom();

    /**
     * Send a message to open game room scene
     */
    void gameRoom();

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
     * Show a list of string containing the nickname of the players.
     * @param players {@code List} of nicknames.
     */
    void showPlayersList (List<String> players);

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

    /**
     * Show the common goal card passed as parameter.
     * @param commonGoalCard The common goal card to be shown.
     * @param progressiveCard A progressive number indicating if the card is the first or the second one in the game.
     */
    void showCommonGoalCard (CommonGoalCard commonGoalCard, Integer progressiveCard);

    /**
     * Show the personal goal card passed as parameter.
     * @param personalGoalCard The personal goal card to be shown.
     */
    void showPersonalGoalCard (PersonalGoalCard personalGoalCard, String cardOwner);

    /**
     * Show the final sorted score board.
     * @param scoreBoardMap The {@code Map} containing the score board.
     */
    void showScoreBoard (Map<String, Integer> scoreBoardMap);

    /**
     * Show chat on guiGame scene
     */
    void showUpdateChat(String message);
}
