package it.polimi.ingsw;

public enum CommonGoalCard implements GoalCard{

    SIX_COUPLES(true),

    FOUR_CORNERS(true),

    FOUR_LINES_FOUR(true),

    TWO_SQUARES(true),

    THREE_COLUMNS(true),

    EIGHT_EQUALS(true),

    DIAGONAL_FIVE(true),

    FOUR_ROWS(true),

    TWO_COLUMNS(true),

    TWO_ROWS(true),

    CROSS(true),

    TRIANGLE(true),

    private boolean available;
    private Game game;
    private ScoringToken scoringToken;

    private Stack scoreCards;

    /**
     *
     * @param available
     * @param numPlayers
     * @param game
     * @param scoringToken
     */
    public CommonGoalCard(boolean available, int numPlayers, Game game, ScoringToken scoringToken){
        this.game = game;
        this.scoringToken = scoringToken;
        this.available = available;
        scoreCards = new Stack(numPlayers);
        scoreCards2 = new Stack(numPlayers);
        if (numPlayers == 2){
            scoreCards.push(4);
            scoreCards.push(8);
            scoreCards2.push(4);
            scoreCards2.push(8);
        } else if (numPlayers == 3) {
            scoreCards.push(4);
            scoreCards.push(6);
            scoreCards.push(8);
            scoreCards2.push(4);
            scoreCards2.push(6);
            scoreCards2.push(8);
        } else if (numPlayers == 4) {
            scoreCards.push(2);
            scoreCards.push(4);
            scoreCards.push(6);
            scoreCards.push(8);
            scoreCards2.push(2);
            scoreCards2.push(4);
            scoreCards2.push(6);
            scoreCards2.push(8);
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int checkPattern(Shelf shelf){

    }
}