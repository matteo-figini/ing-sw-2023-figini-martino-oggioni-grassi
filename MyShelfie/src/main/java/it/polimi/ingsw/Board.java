package it.polimi.ingsw;

public class Board{

    private BoardCell boardContent[9][9];

    private Game game;
    private BoardCell boardCell;

    private int cardsOnBoard;

    public Board(int numPlayer, Game game, BoardCell boardCell){
        this.cardsOnBoard = cardsOnBoard;
        this.boardContent = boardContent;
        this.game = game;
        this.boardCell = boardCell;
    }

    public int getCardsOnBoard() {
        return cardsOnBoard;
    }

    public void setCardsOnBoard(int cardsOnBoard) {
        this.cardsOnBoard = cardsOnBoard;
    }

    public void setBoardContent(BoardCell[] boardContent) {
        this.boardContent = boardContent;
    }

    public BoardCell[] getBoardContent() {
        return boardContent;
    }

    public void refillBoard(List<ObjectCard> cards){

    }

    public List<ObjectCard> pickUpCards(List<Position> postitions){

    }

    public boolean fillingRequired(){

    }
}