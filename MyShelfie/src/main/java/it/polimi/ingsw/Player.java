package it.polimi.ingsw;


public class Player{

    private String nickname;

    private int score = 0;

    private boolean firstPlayer = false;

    private boolean firstCommonGoalReached = false;

    private boolean secondCommonGoalReached = false;

    private boolean hasEndGameToken = false;


    public Player(String nickname){

        this.nickname=nickname;
        this.score=score;
        this.firstPlayer=firstPlayer;
        this.firstCommonGoalReached=firstCommonGoalReached;
        this.secondCommonGoalReached=secondCommonGoalReached;
        this.hasEndGameToken=hasEndGameToken;

    }

    public boolean isFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public boolean isFirstCommonGoalReached() {
        return firstCommonGoalReached;
    }

    public void setFirstCommonGoalReached(boolean firstCommonGoalReached) {
        this.firstCommonGoalReached = firstCommonGoalReached;
    }

    public boolean isSecondCommonGoalReached() {
        return secondCommonGoalReached;
    }

    public void setSecondCommonGoalReached(boolean secondCommonGoalReached) {
        this.secondCommonGoalReached = secondCommonGoalReached;
    }

    public boolean isHasEndGameToken() {
        return hasEndGameToken;
    }

    public void setHasEndGameToken(boolean hasEndGameToken) {
        this.hasEndGameToken = hasEndGameToken;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Position> chooseCards(){

    }

    public List<ObjectCard> rearrangeCards(List<ObjectCard> unordered){

    }
}