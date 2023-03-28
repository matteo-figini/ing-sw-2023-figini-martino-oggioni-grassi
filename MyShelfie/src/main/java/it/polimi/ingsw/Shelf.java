package it.polimi.ingsw;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the shelf of any player.
 */
public class Shelf {
    private ShelfCell[][] shelfContent;
    private final int rows, columns;

    /**
     * Initializes the matrix representing the shelf.
     */
    public Shelf (){
        this.rows = 6;
        this.columns = 5;
        this.shelfContent = new ShelfCell[rows][columns];
    }

    /**
     *
     * @return
     */
    public ShelfCell[][] getShelfContent() {
        // TODO: ritornare una copia della matrice, non il riferimento.
    }

    /**
     * Clear the shelf.
     */
    public void clearShelf() {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                shelfContent[i][j] = null;
                shelfContent[i][j].setStatus(ShelfCellType.FREE);
            }
        }
    }

    /**
     * Inserts the cards in the list inside the specified column.
     * @param cards
     * @param columns
     */
    public void insertCards(List<ItemTile> cards, int columns){

    }


    /**
     *
     * @return
     */
    public boolean isFull () {
        boolean result = true;
        for(int i = 0; i < rows && result == true; i++) {
            for (int j = 0; j < columns && result == true; j++) {
                if (shelfContent[i][j].getStatus().equals(ShelfCellType.FREE)){
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param column
     * @return
     */
    public int freeCellsOnColumn (int column) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            if (shelfContent[i][column].getStatus().equals(ShelfCellType.FREE)){
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @return
     */
    public int pointsFromAdjacency () {
        // TODO: implementare il metodo che ritorna quanti punti sono assegnati dalle adiacenze.
        int points = 0;
        // ...
        return points;
    }

    /**
     *
     * @param unordered
     * @return
     */
    public List<ItemTile> rearrangeCards(List<ItemTile> unordered){

    }
}