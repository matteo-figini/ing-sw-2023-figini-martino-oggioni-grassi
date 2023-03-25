package it.polimi.ingsw;

public enum CommonGoalCard implements GoalCard{

    SIX_COUPLES(true);

    FOUR_CORNERS(true);

    FOUR_LINES_FOUR(true);

    TWO_SQUARES(true);

    THREE_COLUMNS(true);

    EIGHT_EQUALS(true);

    DIAGONAL_FIVE(true);

    FOUR_ROWS(true);

    TWO_COLUMNS(true);

    TWO_ROWS(true);

    CROSS(true);

    TRIANGLE(true);

    private boolean available;

    public CommonGoalCard(boolean available, int numPlayers){

        this.available = available;
    }

    public int checkPattern(Shelf shelf){

    }
}