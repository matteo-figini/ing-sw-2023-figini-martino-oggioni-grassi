package it.polimi.ingsw.model;

/**
 * This immutable class represents the item tile in the board or in the shelf.
 * Every item tile has got an item tile type (enumeration) that represents the type.
 */
public class ItemTile {
    private ItemTileType type;

    /**
     * This constructor creates a new Item Tile based on the specified type passed as parameter.
     * @param type the type of the item tile.
     */
    public ItemTile (ItemTileType type){
        this.type = type;
    }

    /**
     * Get the item tile type.
     * @return a value of the ItemTileType enumeration.
     */
    public ItemTileType getItemTileType() {
        return this.type;
    }
}