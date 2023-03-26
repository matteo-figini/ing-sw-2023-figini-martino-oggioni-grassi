package it.polimi.ingsw;

public class ScoringToken{

    private int score;
    private CommonGoalCard commonGoalCard;

    public ScoringToken(CommonGoalCard commonGoalCard){
        this.commonGoalCard = commonGoalCard;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
