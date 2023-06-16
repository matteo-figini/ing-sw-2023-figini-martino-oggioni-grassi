package it.polimi.ingsw.model;

import java.io.Serializable;

/**
 * This immutable class represents the item tile in the board or in the shelf.
 * Every item tile has got an item tile type (enumeration) that represents the type.
 */
public class ItemTile implements Serializable {
    private final ItemTileType type;

    /**
     * Create a new Item Tile based on the specified type passed as parameter.
     * @param type The type of the item tile.
     */
    public ItemTile (ItemTileType type){
        this.type = type;
    }

    /**
     * Return the type of the item tile.
     * @return The {@code ItemTileType} of the current tile.
     */
    public ItemTileType getItemTileType() {
        return this.type;
    }
}