package it.polimi.ingsw;

public class Shelf{

    private ShelfCell shelfContent[6][5];
    private Player player;
    private ShelfCell shelfCell;

    public Shelf(Player player, ShelfCell shelfCell){
        this.player = player;
        this.shelfCell = shelfCell;
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

    /**
     *
     * @param cards
     * @param columns
     */
    public void insertCards(List<ObjectCard> cards, int columns){

    }

    public boolean isFull(){

    }

    public int freeCellsOnColumn(int column){

    }

    public int pointsFromAdjacency(){

    }

    public List<ObjectCard> rearrangeCards(List<ObjectCard> unordered){

    }
}