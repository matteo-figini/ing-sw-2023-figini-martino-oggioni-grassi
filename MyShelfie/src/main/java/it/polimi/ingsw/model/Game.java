package it.polimi.ingsw.model;

import it.polimi.ingsw.exception.WrongNumberOfCardsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: da revisionare completamente

// TODO: singleton pattern?
/**
 * This class represents all the game in terms of player, board and all the model.
 * It can be useful as an entry point for the controller.
 */
public class Game {
    private boolean lastLap;    // This attribute is 'true' whether the game is at the last lap, 'false' otherwise.
    private List<Player> players;   // This list represents the players in the game.
    private Player activePlayer;    // This attribute represents a pointer to the current player in the list above.
    private Board board;    // This attribute represents the board of the game.
    private Bag bagTiles;    // This attribute represents the bag with the item tiles.
    private List<CommonGoalCard> commonGoalCards;   // This list represents the (two) common goal cards in the game.

    // TODO: istanziare la board una volta che il numero di giocatori è chiaro!

    public Game (Board board) {
        this.lastLap = false;
        this.players = new ArrayList<>();
        this.activePlayer = null;
        // this.board = new Board();
        this.bagTiles = new Bag();
        this.commonGoalCards = new ArrayList<>();
    }

    /**
     * This method creates a new player instance based on the nickname passed as parameter and add it to the players list.
     * @param nickname The nickname of the player. Requires that is not null.
     */
    public void addPlayer (String nickname) {
        Player newPlayer = new Player(nickname);
        this.players.add(newPlayer);
    }


    public void addCommonGoalCard(CommonGoalCard commonGoalCard){
        this.commonGoalCards.add(commonGoalCard);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer (Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * This method indicates if it is the last lap of the match.
     * @return A boolean indicating if it is the last lap.
     */
    public boolean isLastLap() {
        return lastLap;
    }

    /**
     * This method sets the attribute "lastLap" to true, so it means that this is the final lap of the match.
     * Ensures that isLastLap() returns true.
     */
    public void setLastLap () {
        this.lastLap = true;
    }

    /**
     *
     */
    /*public void chooseFirstPlayer(){
        Random f = new Random();
        int findex = f.nextInt(players.size());
        gameFirstPlayer = players.get(findex);  //set attribute first player in Game
        // players.get(findex).firstPlayer = true; //attribute firstplayer in Player change to true
        setActivePlayer(players.get(findex));
    }*/

    /**
     * Returns the instance of the player with the nickname specified as parameter if it exists, otherwise it returns null.
     * @param nickname The nickname of the desired player. Requires that is not null.
     * @return A reference to the desired player if it exists, otherwise null.
     */
    public Player getPlayerByNickname (String nickname) {
        for (Player player : players) {
            if (player.getNickname().equals(nickname)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Returns true if the nickname specified as parameter is already taken, false otherwise. Since it isn't possible to have
     * two players with the same nickname, it can be useful to check with this method before adding a player.
     * @param nickname The nickname to search. Requires that is not null.
     * @return A boolean that indicates if a player with that nickname already exists.
     */
    public boolean isNicknameTaken (String nickname) {
        return getPlayerByNickname(nickname) != null;
    }

    public Player selectNextPlayer () {
        int index = players.indexOf(activePlayer);
        int nextIndex = (index + 1) % players.size();
        return players.get(nextIndex);
    }

    /**
     * This method refills the board from the bag. The number of the tiles to move is the minimum value between the number
     * of the free cells on the board and the number of the tiles in the bag.
     * @return The number of the item tiles moved from the bag to the board. A return value of 0 means that a
     * WrongNumberOfCardsException is raised.
     */
    public int refillBoardFromBag () {
        int tilesMoved = 0;
        this.bagTiles.shuffle();
        int tilesToMove = Math.min(board.getFreeCellsOnBoard(), bagTiles.availableTiles());
        try {
            List<ItemTile> tilesExtracted = this.bagTiles.drawTiles(tilesToMove);
            tilesMoved = tilesExtracted.size();
            this.board.refillBoard(tilesExtracted);
        } catch (WrongNumberOfCardsException ex) {
            System.out.println(ex.getMessage());
        }
        return tilesMoved;
    }
}