package it.polimi.ingsw.model;

/**
 * This class represents the scoring tokens on a common goal card.
 * Each card has got a score.
 */
public class ScoringToken {
    private int score;

    /**
     * Initialize the token with its own score.
     * @param score the score of the card.
     */
    public ScoringToken (int score) {
        this.score = score;
    }

    /**
     * Get the score of the card.
     * @return the score of the card.
     */
    public int getScore() {
        return score;
    }
}
