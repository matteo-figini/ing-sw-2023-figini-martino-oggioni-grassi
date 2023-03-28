package it.polimi.ingsw;

public class ItemTile{
    private ItemTileType color;

    public ItemTile(ItemTileType color){
        this.color = color;
    }

    public String getObjectCardType() {
        return color;
    }

    public void setObjectCardType(ItemTileType color) {
        this.color = color;
    }
}