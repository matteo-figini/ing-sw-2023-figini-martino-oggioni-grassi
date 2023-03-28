package it.polimi.ingsw;

/**
 * This class represents the single element inside the board.
 */
public class BoardCell {
    private BoardCellType type;
    private ItemTile itemTile;

    /**
     * Create a new board cell type without any item tile inside.
     * @param type type of the board (Not playable, free or busy).
     */
    public BoardCell (BoardCellType type){
        this.type = type;
        this.itemTile = null;
    }

    /**
     * Change board cell type.
     * @param newType new type of that board cell.
     */
    public void setType (BoardCellType newType) {
        this.type = newType;
    }

    /**
     * Returns the type of that board cell type.
     * @return the type of that board cell type.
     */
    public BoardCellType getType() {
        return type;
    }

    /**
     *
     * @return if the cell is free
     */
    public boolean isFree(){
        return this.type.equals(BoardCellType.FREE);
    }

    /**
     *
     * @return if the cell is playable
     */
    public boolean isPlayable(){
        return !this.type.equals(BoardCellType.NOT_PLAYABLE);
    }
}