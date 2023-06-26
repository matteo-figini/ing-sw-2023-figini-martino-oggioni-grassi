package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

import java.util.Map;

/**
 * This message is used to send the final score board containing the score of each player.
 */
public class ScoreBoardMessage extends Message {
    /** Reference to the {@code Map} containing the score board. */
    private final Map<String, Integer> scoreBoardMap;

    /**
     * @param scoreBoardMap {@code Map} containing the score board.
     */
    public ScoreBoardMessage (Map<String, Integer> scoreBoardMap) {
        super(Server.SERVER_NAME, MessageType.SCORE_BOARD);
        this.scoreBoardMap = scoreBoardMap;
    }

    /**
     * @return The {@code Map} representing the score board.
     */
    public Map<String, Integer> getScoreBoardMap() {
        return scoreBoardMap;
    }

    @Override
    public String toString() {
        return "ScoreBoardMessage{" +
                "scoreBoardMap=" + scoreBoardMap +
                '}';
    }
}
