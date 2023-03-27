package it.polimi.ingsw;

public class Board{

    private BoardCell boardContent[9][9];

    private Game game;

    private int freeCellOnBoard;

    public Board(int numPlayer, Game game, BoardCell boardCell){
        this.freeCellOnBoard = freeCellOnBoard;
        this.boardContent = boardContent;
        this.game = game;
        this.boardCell = boardCell;
    }

    public int getFreeCellOnBoard() {
        return freeCellOnBoard;
    }

    public void setFreeCellOnBoard(int freeCellOnBoard) {
        this.freeCellOnBoard = freeCellOnBoard;
    }

    public void setBoardContent(BoardCell[] boardContent, int i, int j, ItemTile color) {
        boardContent[i][j].objectCard = color;
        boardContent[i][j].setType(BoardCellType.BUSY);
    }

    public BoardCell[] getBoardContent(int i, int j) {
        return boardContent[i][j];
    }

    public void refillBoard(List<ObjectCard> cards){

    }

    public List<ObjectCard> pickUpCards(List<Position> postitions){

    }

    public boolean fillingRequired(){

    }
}