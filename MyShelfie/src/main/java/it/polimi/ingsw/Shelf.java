package it.polimi.ingsw;
import java.util.HashMap;
import java.util.Map;

public class Shelf{

    private ShelfCell[6][5] shelfContent;
    private Player player;
    private ShelfCell shelfCell;

    public Shelf(Player player, ShelfCell shelfCell){
        this.player = player;
        this.shelfCell = shelfCell;
        this.shelfContent = shelfContent;
    }

    public Map<ObjectCardType, Integer> colorCount(){
        Map<ObjectCardType, Integer> colorCounts = new HashMap<>();

        for (int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                ShelfCell currentCell = shelfContent[i][j];
                if(currentCell.getStatus() == ShelfCellType.BUSY){
                    ObjectCardType color = currentCell.getColor();
                    if (colorCounts.containsKey(color)){
                        colorCounts.put(color, colorCounts.get(value) + 1);
                    } else {
                        int value = 1;
                        colorCounts.put(color, value);
                    }
                }
            }
        }
        return colorCounts;
    }

    public void setShelfContent(ShelfCell[] shelfContent) {
        this.shelfContent = shelfContent;
    }

    public ShelfCell[] getShelfContent() {
        return shelfContent;
    }

    public void clearShelf(){
        for(int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                shelfContent[i][j].setColor(null);
                shelfContent[i][j].setStatus(FREE);
            }
        }
    }

    /**
     *
     * @param cards
     * @param columns
     */
    public void insertCards(List<ObjectCard> cards, int columns){

    }


    /**
     *
     * @return
     */
    public boolean isFull(){
        private boolean result = true;
        for(int i = 0; i < 6 && result = true; i++) {
            for (int j = 0; j < 5 && result = true; j++) {
                if(shelfContent[i][j].getStatus() == ShelfCellType.FREE){
                    result = false;
                }
            }
        }
        return result;
    }

    public int freeCellsOnColumn(int column){
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (shelfContent[i][column].getState() == ShelfCellType.FREE){
                count++;
            }
        }
        return count;
    }

    public int pointsFromAdjacency(){

    }

    public List<ObjectCard> rearrangeCards(List<ObjectCard> unordered){

    }
}