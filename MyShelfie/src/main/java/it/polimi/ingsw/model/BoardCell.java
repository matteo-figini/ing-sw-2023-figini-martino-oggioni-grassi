package it.polimi.ingsw.model;

/**
 * This class represents the single cell inside the board. Every board cell has got a type (PLAYABLE/NOT PLAYABLE) and
 * a reference to the item tile contained.
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
     * Returns the type of the board cell type.
     * @return the type of the board cell type.
     */
    public BoardCellType getType() {
        return type;
    }

    /**
     * Get the item tile contained in the board cell.
     * @return a reference to the item tile contained in the board cell.
     */
    public ItemTile getItemTile() {
        return itemTile;
    }

    /**
     * Add the item tile passed by parameter in the board cell.
     * @param itemTile the tile that will be added in the board.
     */
    public void addItemTile(ItemTile itemTile) {
        this.itemTile = itemTile;
    }

    /**
     * Remove the item tile from the board cell.
     */
    public void freeCell () {
        this.itemTile = null;
    }

    /**
     * Indicates if the board cell is free or not.
     * @return a boolean indicating if the board cell is free.
     */
    public boolean isFree(){
        return (this.itemTile == null);
    }

    /**
     * Indicates if the board cell is playable or not.
     * @return a boolean indicating if the board cell is playable.
     */
    public boolean isPlayable(){
        return (this.type == BoardCellType.PLAYABLE);
    }
}