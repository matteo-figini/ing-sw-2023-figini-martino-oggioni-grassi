package it.polimi.ingsw;

public class Shelf{

    private ShelfCell shelfContent[6][5];

    public Shelf(){
        this.shelfContent = shelfContent;
    }

    public void setShelfContent(ShelfCell[] shelfContent) {
        this.shelfContent = shelfContent;
    }

    public ShelfCell[] getShelfContent() {
        return shelfContent;
    }

    public void clearShelf(){

    }

    public void insertCards(List<ObjectCard> cards, int columns){

    }

    public boolean isFull(){

    }

    public int freeCellsOnColumn(int column){

    }

    public int pointsFromAdjacency(){

    }
}