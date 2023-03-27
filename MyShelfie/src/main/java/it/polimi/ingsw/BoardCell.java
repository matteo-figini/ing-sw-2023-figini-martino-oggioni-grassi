package it.polimi.ingsw;

public class BoardCell{

    private Board board;
    private BoardCellType type;
    private ObjectCardType objectCard;
    private

    public BoardCell(Board board, BoardCellType type, ObjectCardType objectCard){
        this.board = board;
        this.type = type;
        this.objectCard = objectCard;
    }

    public void setType(BoardCellType newType) {
        type = newType;
    }

    public BoardCellType getType() {
        return type;
    }

    public boolean isFree(){

    }

    public boolean isPlayable(){

    }

}