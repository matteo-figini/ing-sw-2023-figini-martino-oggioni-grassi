package it.polimi.ingsw;

public class Game{
    private boolean lastLap = false;

    private List<Player> players = new ArrayList<>();

    private Player gameFirstPlayer;
    private Board board;
    private Bag bag=new Bag();
    private List<CommonGoalCard> commonGoalCards = new ArrayList<>();

    private Player activePlayer;

    public Game(Board board){
        this.activePlayer = activePlayer;
        this.lastLap = lastLap;
        this.board = board;
        this.gameFirstPlayer = gameFirstPlayer;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void addCommonGoalCard(CommonGoalCard commonGoalCard){
        this.commonGoalCards.add(commonGoalCard);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public boolean isLastLap() {
        return lastLap;
    }

    public void setLastLap(boolean lastLap) {
        this.lastLap = lastLap;
    }

    /**
     *
     */
    public void chooseFirstPlayer(){
        Random f = new Random();
        int findex = f.nextInt(players.size());
        gameFirstPlayer = players.get(findex);  //set attribute first player in Game
        players.get(findex).firstPlayer = true; //attribute firstplayer in Player change to true
        setActivePlayer(players.get(findex));
    }

    public Player getPlayerByNickname(String nickname){
        for(Player player : players){
            if(player.getNickname().equals(nickname)){
                return player;
            }
        }
        return null;
    }

    public boolean isNameTaken(String nickname){
        return getPlayerByNickname(nickname) != null;
    }

    public Player selectNextPlayer(Player activePlayer){
        int index = players.indexOf(activePlayer);
        int nextIndex = (index + 1) % players.size();
        return players.get(nextIndex);
    }

    /**
     *
     * @return
     */
    public int refillBoardFromBag(){
        bag.shuffle();
        int x = board.getFreeCellOnBoard();
        int y = bag.availableCards();
        int n = Math.min(x,y);
        for(int i = 0; i<n; i++){
            private ItemTile tile= bag.drawTile();
            for(int j=0; j < 9;j++){
                for(int k=0; k<9; k++){
                    if(board.getBoardContent(j, k).isFree()){
                        board.setBoardContent(board, j, k, tile);
                    }
                }
            }
        }

    }

}