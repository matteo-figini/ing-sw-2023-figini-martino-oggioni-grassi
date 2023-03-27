package it.polimi.ingsw;

public class ShelfCell{

    private Shelf shelf;

    private ObjectCardType color;

    private int value;

    private ShelfCellType status;

    public ShelfCell(Shelf shelf, int value, ShelfCellType status, ObjectCardType color){
        this.shelf = shelf;
        this.value = value;
        this.status = status;
    }

    public int getColor() {
        return color;
    }

    public ShelfCellType getStatus() {
        return status;
    }

    public void setColor(ObjectCardType color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setStatus(ShelfCellType status) {
        this.status = status;
    }

    public boolean isFree(){

    }

}