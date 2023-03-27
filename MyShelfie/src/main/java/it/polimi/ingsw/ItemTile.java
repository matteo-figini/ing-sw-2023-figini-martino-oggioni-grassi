package it.polimi.ingsw;

public class ItemTile{
    private ObjectCardType color;

    public ItemTile(ObjectCardType color){
        this.color = color;
    }

    public String getObjectCardType() {
        return color;
    }

    public void setObjectCardType(ObjectCardType color) {
        this.color = color;
    }
}