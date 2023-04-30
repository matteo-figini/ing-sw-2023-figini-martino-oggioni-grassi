package it.polimi.ingsw.model;

import it.polimi.ingsw.exception.NotEnoughCellsException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the shelf of the player.
 */
public class Shelf {
    private ShelfCell[][] shelfContent;

    final public static int ROWS = 6;
    final public static int COLUMNS = 5;

    /**
     * Initializes the matrix representing the shelf and every single value inside the shelf.
     */
    public Shelf (){
        this.shelfContent = new ShelfCell[ROWS][COLUMNS];
        // Initialize every cell in the matrix
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
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
        return shelfContent;
    }

    public void setShelfContent(ShelfCell[][] shelfContent) {
        this.shelfContent = shelfContent;
    }

    /**
     * Clears the shelf.
     */
    public void clearShelf() {
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
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
        firstRowAvailable = this.freeCellsOnColumn(column) - 1;
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
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (shelfContent[i][j].isFree()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Counts the number of free cells in the specified column of the shelf.
     * @param column the column where to check the number of free cells.
     * @return the number of free cells.
     */
    public int freeCellsOnColumn (int column) {
        int topRow;
        for (topRow = 0; topRow < Shelf.ROWS && shelfContent[topRow][column].isFree(); topRow++);
        return topRow;
    }

    /**
     * This method calculates the score due to all the adjacences inside the shelf. At the end of the game, additional points are
     * given by how many "clusters" of same item tiles are in the shelf.
     * @return The total score due to adjacences.
     */
    public int pointsFromAdjacencies () {
        List<List<Position>> bigList = new ArrayList<>();
        List<Position> l = new ArrayList<>();
        List<Position> l1;

        // Inizializzazione della matrice di supporto
        char[][] support = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                support[i][j] = 'U';
            }
        }

        // Creazione della lista delle posizioni con tessere adiacenti
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (!shelfContent[i][j].isFree() && support[i][j] != 'V') {
                    if (support[i][j] == 'U') {
                        l = new ArrayList<>();
                        l.add(new Position(i, j));
                        bigList.add(l);
                    } else if (support[i][j] == 'I') {
                        l = findElement(bigList, new Position(i, j));
                    }

                    // Controllo della cella a destra
                    if ((j < COLUMNS - 1) && !shelfContent[i][j+1].isFree() &&
                            shelfContent[i][j+1].getTile().getItemTileType() == shelfContent[i][j].getTile().getItemTileType()) {
                        if (support[i][j+1] == 'U') {
                            assert l != null;
                            l.add(new Position(i, j+1));
                            support[i][j+1] = 'I';
                        } else if (support[i][j+1] == 'I') {
                            try {
                                l1 = findElement(bigList, new Position(i, j+1));
                                int size = l1.size();
                                for (int k = 0; k < size; k++) {
                                    l.add(l1.remove(0));
                                }
                            } catch (NullPointerException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }

                    // Controllo della tessera sottostante
                    if ((i < ROWS - 1) && !shelfContent[i+1][j].isFree() &&
                            shelfContent[i+1][j].getTile().getItemTileType() == shelfContent[i][j].getTile().getItemTileType()) {
                        if (support[i+1][j] == 'U') {
                            assert l != null;
                            l.add(new Position(i+1, j));
                            support[i+1][j] = 'I';
                        } else if (support[i+1][j] == 'I') {
                            try {
                                l1 = findElement(bigList, new Position(i+1, j));
                                int size = l1.size();
                                for (int k = 0; k < size; k++) {
                                    l.add(l1.remove(0));
                                }
                            } catch (NullPointerException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                }
                support[i][j] = 'V';
            }
        }
        return calculatePoints(fromPositionsToSize(bigList));
    }

    /* METODI PRIVATI DI SUPPORTO AL CALCOLO DEI PUNTI PER LE ADIACENZE */
    /**
     * This util method returns the list inside "bigList" in which the position specified by the elem parameter is contained.
     * @param bigList The list of positions' lists.
     * @param elem The position to find.
     * @return The pointer to the correct positions' list.
     */
    private List<Position> findElement (List<List<Position>> bigList, Position elem) {
        for (List<Position> l : bigList) {
            if (l.contains(new Position(elem.getX(), elem.getY()))) {
                return l;
            }
        }
        return null;
    }

    /**
     * This util method takes in input a list of positions' list and returns a list containing the size of the lists
     * which have a size greater or equal than 3.
     * @param bigList The list of positions' lists.
     * @return A list of the sizes greater or equal than 3.
     * NOTE: this method is implemented using functional programming constructs.
     */
    private List<Integer> fromPositionsToSize(List<List<Position>> bigList) {
        return bigList.stream()
                .map(List::size)
                .filter(size -> size >= 3)
                .collect(Collectors.toList());
    }

    /**
     * This util method receives in input a list containing the sizes and returns the total score from the list of cluster's size.
     * @param sizes The list of the cluster's size. Requires that each element in it is greater or equal than 3.
     * @return Total score calculated from the list.
     */
    private Integer calculatePoints (List<Integer> sizes) {
        Integer points = 0;
        for (Integer i : sizes) {
            if (i == 3)
                points += 2;
            else if (i == 4)
                points += 3;
            else if (i == 5)
                points += 5;
            else if (i >= 6)
                points += 8;
        }
        return points;
    }
}