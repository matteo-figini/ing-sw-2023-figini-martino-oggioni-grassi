package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.ScoringToken;
import it.polimi.ingsw.model.ShelfCell;

import java.util.Arrays;

/**
 * This class is used to represent all the public information about a single player,
 * such as the {@code Shelf} content and the information about the scoring token obtained
 * during the match.
 */
public class PlayerInformation extends Message {
    /** Matrix of {@code ShelfCell} containing the shelf content of the player. */
    private ShelfCell[][] shelfContent;

    private ScoringToken firstCommonGoal;

    private ScoringToken secondCommonGoal;

    private boolean hasEndGameToken;

    /** Name of the player. */
    private String player;

    /**
     * This constructor receives in input a reference to a matrix containing the shelf cells.
     * It is recommended to pass a copy of the shelf content, instead of the original content.
     * @param shelfContent A reference to a matrix containing the shelf cells.
     */
    public PlayerInformation(String player, ShelfCell[][] shelfContent, ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken) {
        super("SERVER", MessageType.PLAYER_INFORMATION);
        this.shelfContent = shelfContent;
        this.player = player;
        this.firstCommonGoal = firstCommonGoal;
        this.secondCommonGoal = secondCommonGoal;
        this.hasEndGameToken = hasEndGameToken;
    }

    public ShelfCell[][] getShelfContent() {
        return shelfContent;
    }

    public String getPlayer() {
        return player;
    }

    public ScoringToken getFirstCommonGoal() {
        return firstCommonGoal;
    }

    public ScoringToken getSecondCommonGoal() {
        return secondCommonGoal;
    }

    public boolean isHasEndGameToken() {
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
