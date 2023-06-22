package it.polimi.ingsw.model;

import java.io.Serializable;

/**
 * This class represents a cell inside the shelf.
 */
public class ShelfCell implements Serializable {
    private ItemTile tile;      // Tile contained in the cell

    /**
     * When a single cell is initialized, it doesn't have any tile inside.
     */
    public ShelfCell(){
        this.tile = null;
    }

    /**
     * This method tells if the cell is free or is busy (in case it contains a tile).
     * @return {@code true} if the cell doesn't contain a tile, {@code false} otherwise.
     */
    public boolean isFree(){
        return (this.getTile() == null);
    }

    /**
     * Get the tile inside the cell (return null if there isn't any tile inside).
     * @return The tile contained in the cell, or {@code null} if there isn't any tile.
     */
    public ItemTile getTile () {
        return this.tile;
    }

    /**
     * Set the tile attribute to the specified value.
     * @param tile The {@code ItemTile} contained in the cell.
     */
    public void setTile(ItemTile tile) {
        this.tile = tile;
    }
}