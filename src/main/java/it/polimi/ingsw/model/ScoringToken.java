package it.polimi.ingsw.model;

import java.io.Serializable;

/**
 * This immutable class represents the scoring tokens on a common goal card.
 * Each card has got a score.
 */
public record ScoringToken(int score) implements Serializable {
    /**
     * Initialize the token with its own score.
     * @param score The score of the card.
     */
    public ScoringToken {
    }

    /**
     * @return The score of the card.
     */
    @Override
    public int score() {
        return score;
    }
}
