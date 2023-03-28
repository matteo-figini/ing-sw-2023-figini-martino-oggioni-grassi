package it.polimi.ingsw;

public class ShelfCell{
    private ItemTile tile;      // Tile contained in the cell.
    private ShelfCellType status;

    public ShelfCell(){
        this.tile = null;
        this.status = ShelfCellType.FREE;
    }

    public ShelfCellType getStatus() {
        return status;
    }

    public void setStatus (ShelfCellType status) {
        this.status = status;
    }

    public boolean isFree(){
        return this.status.equals(ShelfCellType.FREE);
    }

}