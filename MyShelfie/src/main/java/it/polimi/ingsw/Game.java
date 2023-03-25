package it.polimi.ingsw;

public class Game{
    private boolean lastLap = false;

    private int activePlayer;

    public Game(List<String> nicknames){
        this.activePlayer = activePlayer;
        this.lastLap = lastLap;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    public boolean isLastLap() {
        return lastLap;
    }

    public void setLastLap(boolean lastLap) {
        this.lastLap = lastLap;
    }

    public void chooseFirstPlayer(){

    }

    public Player getPlayerByNickname(String nickname){

    }

    public boolean isNameTaken(String nickname){

    }

    public void selectNextPlayer(){

    }

    public int refillBoardFromBag(){

    }
}