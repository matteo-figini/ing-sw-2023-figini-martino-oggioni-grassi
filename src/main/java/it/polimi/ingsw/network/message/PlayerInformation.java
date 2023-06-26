package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.ScoringToken;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.network.Server;

import java.util.Arrays;

/**
 * This class is used to represent all the public information about a single player,
 * such as the {@code Shelf} content and the information about the scoring token obtained
 * during the match.
 */
public class PlayerInformation extends Message {
    /** Matrix of {@code ShelfCell} containing the shelf content of the player. */
    private ShelfCell[][] shelfContent;
    /** {@code ScoringToken} of the first common goal ({@code null} if the goal hasn't been reached}). */
    private ScoringToken firstCommonGoal;
    /** {@code ScoringToken} of the second common goal ({@code null} if the goal hasn't been reached}). */
    private ScoringToken secondCommonGoal;
    /** Boolean indicating if the player has the end game token. */
    private boolean hasEndGameToken;
    /** Nickname of the player. */
    private String player;

    /**
     * @param player Nickname of the player.
     * @param shelfContent Matrix of {@code ShelfCell} containing the shelf content of the player.
     * @param firstCommonGoal {@code ScoringToken} of the first common goal ({@code null} if the goal hasn't been reached}).
     * @param secondCommonGoal {@code ScoringToken} of the second common goal ({@code null} if the goal hasn't been reached}).
     * @param hasEndGameToken Boolean indicating if the player has the end game token.
     */
    public PlayerInformation(String player, ShelfCell[][] shelfContent, ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken) {
        super(Server.SERVER_NAME, MessageType.PLAYER_INFORMATION);
        this.shelfContent = shelfContent;
        this.player = player;
        this.firstCommonGoal = firstCommonGoal;
        this.secondCommonGoal = secondCommonGoal;
        this.hasEndGameToken = hasEndGameToken;
    }

    /**
     * @return Matrix of {@code ShelfCell} containing the shelf content of the player.
     */
    public ShelfCell[][] getShelfContent() {
        return shelfContent;
    }

    /**
     * @return Nickname of the player.
     */
    public String getPlayer() {
        return player;
    }

    /**
     * @return {@code ScoringToken} of the first common goal ({@code null} if the goal hasn't been reached}).
     */
    public ScoringToken getFirstCommonGoal() {
        return firstCommonGoal;
    }

    /**
     * @return {@code ScoringToken} of the second common goal ({@code null} if the goal hasn't been reached}).
     */
    public ScoringToken getSecondCommonGoal() {
        return secondCommonGoal;
    }

    /**
     * @return Boolean indicating if the player has the end game token.
     */
    public boolean hasEndGameToken () {
        return hasEndGameToken;
    }

    @Override
    public String toString() {
        return "PlayerInformation{" +
                "shelfContent=" + Arrays.toString(shelfContent) +
                ", player='" + player + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
