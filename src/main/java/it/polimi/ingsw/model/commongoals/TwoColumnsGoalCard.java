package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;

public class TwoColumnsGoalCard extends CommonGoalCard {
    private int number = 2;
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public TwoColumnsGoalCard(int numPlayers) {
        super(numPlayers, "Due colonne formate ciascuna da 6 diversi tipi di tessere.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        int validColumns = 0;
        for (int j = 0; j < Shelf.COLUMNS; j++) {
            // If the column doesn't contain free cells and there are all different item tile types, the column is valid.
            if (columnWithoutFreeCells(shelf, j) && allDifferentItemTiles(shelf, j)) {
                validColumns++;
            }
        }
        return validColumns >= 2;
    }

    /**
     * Returns {@code true} if the {@code columnIndex} of the {@code shelf} doesn't contain free cells, otherwise returns {@code false}.
     * @param shelf The {@code Shelf} to check.
     * @param columnIndex The column in the shelf to check.
     * @return A boolean value according to the method description.
     */
    private boolean columnWithoutFreeCells (Shelf shelf, int columnIndex) {
        boolean columnValid = true;
        for (int i = 0; i < Shelf.ROWS && columnValid; i++) {
            if (shelf.getShelfContent()[i][columnIndex].isFree()) {
                columnValid = false;
            }
        }
        return columnValid;
    }

    /**
     * Returns {@code true} if the {@code columnIndex} of the {@code shelf} contains all different cells. More specifically,
     * if we consider all the possible {@code ItemTileType} types, a column contains all different cells if, for each
     * {@code ItemTileType}, there are 0 or 1 occurrences of that type and no more than 1 occurrence.
     * @param shelf The {@code Shelf} to check.
     * @param columnIndex The column in the shelf to check.
     * @return A boolean value according to the method description.
     */
    private boolean allDifferentItemTiles (Shelf shelf, int columnIndex) {
        boolean columnValid = true;

        // Initialize the counting map
        Map<ItemTileType, Integer> cellsInColumn = new HashMap<>();
        for (ItemTileType type : ItemTileType.values()) {
            cellsInColumn.put(type, 0);
        }

        // Count the number of the occurrences of each ItemTileType in the shelf
        for (int i = 0; i < Shelf.ROWS; i++) {
            ItemTileType cellType = shelf.getShelfContent()[i][columnIndex].getTile().getItemTileType();
            Integer prevValue = cellsInColumn.get(cellType);
            prevValue = prevValue + 1;
            cellsInColumn.put(cellType, prevValue);
        }

        // Check that each entry of the map doesn't contain values over 1.
        for (Map.Entry<ItemTileType, Integer> set : cellsInColumn.entrySet()) {
            if (set.getValue() != 1) {
                columnValid = false;
                break;
            }
        }

        return columnValid;
    }
    public int getNumber() {
        return number;
    }
}
