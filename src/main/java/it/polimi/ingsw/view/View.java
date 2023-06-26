package it.polimi.ingsw.view;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ScoringToken;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;

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
     * Send a message to open a waiting room scene
     */
    void switchToWaitingRoom();

    /**
     * Send a message to open a game room scene
     */
    void switchToGameRoom();

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
     * Show the public player information regarding all the player status.
     * @param player {@code String} containing the nickname of the player.
     * @param shelfContent Content of the player's shelf.
     * @param firstCommonGoal The token corresponding to the first common goal (if obtained, otherwise it is null).
     * @param secondCommonGoal The token corresponding to the second common goal (if obtained, otherwise it is null).
     * @param hasEndGameToken {@code Boolean} indicating if the player has got the end game token.
     */
    void showPlayerInformation(String player, ShelfCell[][] shelfContent, ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken);

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
}
