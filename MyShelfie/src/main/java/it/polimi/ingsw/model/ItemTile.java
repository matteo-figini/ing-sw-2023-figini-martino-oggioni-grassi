package it.polimi.ingsw.model;

public class ItemTile{
    private ItemTileType color;

    public ItemTile(ItemTileType color){
        this.color = color;
    }

    public String getItemTileType() {
        return color;
    }

    public void setObjectCardType(ItemTileType color) {
        this.color = color;
    }
}