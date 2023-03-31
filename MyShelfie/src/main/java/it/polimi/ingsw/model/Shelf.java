package it.polimi.ingsw.model;

import it.polimi.ingsw.exception.NotEnoughCellsException;

import java.util.List;

/**
 * This class represents the shelf of the player.
 */
public class Shelf {
    private ShelfCell[][] shelfContent;
    private final int rows, columns;

    /**
     * Initializes the matrix representing the shelf and every single value inside the shelf.
     */
    public Shelf (){
        this.rows = 6;
        this.columns = 5;
        this.shelfContent = new ShelfCell[rows][columns];
        // Initialize every cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }
    }

    /**
     * Creates a matrix that represent a copy of the shelf.
     * @return pointer to the copy.
     */
    // TODO: creare una copia della shelf che contenga anche la copia delle tessere.
    public ShelfCell[][] getShelfContent() {
        ShelfCell[][] copy = new ShelfCell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                copy[i][j] = shelfContent[i][j];
            }
        }
        return copy;
    }

    /**
     * Clears the shelf.
     */
    public void clearShelf() {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                shelfContent[i][j] = null;
            }
        }
    }

    /**
     * Inserts the cards in the list inside the specified column.
     * Cards are inserted from the first one to the last one.
     * @param cards cards to insert in the shelf
     * @param column column where to insert the cards
     * @throws NotEnoughCellsException exception raised when there are more cards than available cells in the column
     */
    public void insertCards(List<ItemTile> cards, int column) throws NotEnoughCellsException {
        int firstRowAvailable;
        if (cards.size() > freeCellsOnColumn(column)) {
            throw new NotEnoughCellsException();
        }
        firstRowAvailable = this.freeCellsOnColumn(column);
        for (int i = 0; i < cards.size(); i++) {
            shelfContent[firstRowAvailable][column].setTile(cards.get(i));
            firstRowAvailable--;
        }
    }


    /**
     * Checks if the shelf is full or not
     * @return boolean that indicates if the shelf is full.
     */
    public boolean isFull () {
        boolean result = true;
        for(int i = 0; i < rows && result == true; i++) {
            for (int j = 0; j < columns && result == true; j++) {
                if (shelfContent[i][j].isFree()) {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * Counts the number of free cells in the specified column of the shelf.
     * @param column the column where to check the number of free cells.
     * @return the number of free cells.
     */
    public int freeCellsOnColumn (int column) {
        int topRow;
        for (topRow = 0; shelfContent[topRow][column].isFree(); topRow++);
        return topRow;
    }

    /**
     *
     * @return
     */
    public int pointsFromAdjacencies () {
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
    public List<ItemTile> rearrangeCards(List<ItemTile> unordered) {
        // TODO: pensare se questo metodo è meglio metterlo nel player
        return null;
    }
}