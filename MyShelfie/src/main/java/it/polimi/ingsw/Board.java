package it.polimi.ingsw;

import java.util.List;

public class Board{
    private BoardCell[][] boardContent;
    private int freeCellsOnBoard;

    /**
     * Completare.
     * @param numPlayer
     */
    public Board (int numPlayer){
        boardContent = new BoardCell[9][9];
        // TODO: decidere come impostare il layout della board partendo dal numero di giocatori.
    }

    /**
     * Returns the number of the free cells on board.
     * It can be useful when a refill is mandatory, to know how many cards put in.
     * @return the number of the free cells on board.
     */
    public int getFreeCellsOnBoard() {
        return freeCellsOnBoard;
    }

    public BoardCell[][] getBoardContent() {
        // TODO: restituire NON il riferimento alla matrice, ma una copia di essa.
    }

    public void refillBoard (List<ItemTile> cards){
        // TODO: decidere se spostare l'implementazione qui o in Game.
    }

    /**
     * It returns the list of the item tile in the positions specified by the parameter.
     * @param positions Positions in the board where to take the cards.
     * @return Cards picked up from the board.
     */
    public List<ItemTile> pickUpCards(List<Position> positions){

    }

    /**
     * Checks if a complete filling is required.
     * @return a boolean indicating if filling is required.
     */
    public boolean fillingRequired(){

    }
}