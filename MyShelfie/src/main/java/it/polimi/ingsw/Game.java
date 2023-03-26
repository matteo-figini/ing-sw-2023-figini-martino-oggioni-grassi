package it.polimi.ingsw;

public class Game{
    private boolean lastLap = false;

    private List<Player> players = new ArrayList<>();
    private Board board;
    private Bag bag;
    private List<CommonGoalCard> commonGoalCards = new ArrayList<>();

    private int activePlayer;

    public Game(Board board, Bag bag){
        this.activePlayer = activePlayer;
        this.lastLap = lastLap;
        this.board = board;
        this.bag = bag;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void addCommonGoalCard(CommonGoalCard commonGoalCard){
        this.commonGoalCards.add(commonGoalCard);
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