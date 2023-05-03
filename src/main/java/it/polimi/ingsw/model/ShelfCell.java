package it.polimi.ingsw.model;

import java.io.Serializable;

/**
 * This class represents a cell inside the shelf.
 */
public class ShelfCell implements Serializable {
    private ItemTile tile;      // Tile contained in the cell

    /**
     * When the single cell is initialized, it doesn't have any tile inside.
     */
    public ShelfCell(){
        this.tile = null;
    }

    /**
     * This method tells if the cell is free or is busy (in case it contains a tile).
     * @return a boolean that represents if the cell is free.
     */
    public boolean isFree(){
        return (this.getTile() == null);
    }

    /**
     * Get the tile inside the cell (return null if there isn't any tile inside).
     * @return the tile contained in the cell.
     */
    public ItemTile getTile () {
        return this.tile;
    }

    /**
     * Set the tile attribute to the specified value.
     * @param tile the specified tile.
     */
    public void setTile(ItemTile tile) {
        this.tile = tile;
    }
}