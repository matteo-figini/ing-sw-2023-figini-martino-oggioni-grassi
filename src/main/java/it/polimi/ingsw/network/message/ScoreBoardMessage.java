package it.polimi.ingsw.network.message;

import java.util.Map;

/**
 * This message is used to the send the final score board containing the score of each player.
 */
public class ScoreBoardMessage extends Message {
    /** Reference to the {@code Map} containing the score board. */
    private final Map<String, Integer> scoreBoardMap;

    public ScoreBoardMessage (Map<String, Integer> scoreBoardMap) {
        super("SERVER", MessageType.SCORE_BOARD);
        this.scoreBoardMap = scoreBoardMap;
    }

    /**
     * Returns the {@code Map} representing the score board.
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
