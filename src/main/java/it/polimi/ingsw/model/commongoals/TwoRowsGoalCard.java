package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;

public class TwoRowsGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public TwoRowsGoalCard(int numPlayers) {
        super(numPlayers, "Due righe formate ciascuna da 5 diversi tipi di tessere.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        int validRows = 0;
        for (int i = 0; i < Shelf.ROWS; i++) {
            // If the row doesn't contain free cells and there are all different item tile types, the row is valid.
            if (rowWithoutFreeCells(shelf, i) && allDifferentItemTiles(shelf, i)) {
                validRows++;
            }
        }
        return validRows >= 2;
    }

    /**
     * Returns {@code true} if the row {@code rowIndex} of the {@code shelf} doesn't contain free cells, otherwise returns {@code false}.
     * @param shelf The {@code Shelf} to check.
     * @param rowIndex The row in the shelf to check
     * @return {@code true} if the row {@code rowIndex} of the {@code shelf} doesn't contain free cells, otherwise returns {@code false}.
     */
    private boolean rowWithoutFreeCells (Shelf shelf, int rowIndex) {
        boolean rowValid = true;
        for (int j = 0; j < Shelf.COLUMNS && rowValid; j++) {
            if (shelf.getShelfContent()[rowIndex][j].isFree()) {
                rowValid = false;
            }
        }
        return rowValid;
    }

    /**
     * Returns {@code true} if the row {@code rowIndex} of the {@code shelf} contains all different cells. More specifically,
     * if we consider all the possible {@code ItemTileType} types, a row contains all different cells if, for each
     * {@code ItemTileType}, there are 0 or 1 occurrences of that type and no more than 1 occurrence.
     * @param shelf The {@code Shelf} to check.
     * @param rowIndex The row in the shelf to check.
     * @return A boolean value according to the method description.
     */
    private boolean allDifferentItemTiles (Shelf shelf, int rowIndex) {
        boolean rowValid = true;

        // Initialize the counting map
        Map<ItemTileType, Integer> cellsInRow = new HashMap<>();
        for (ItemTileType type : ItemTileType.values()) {
            cellsInRow.put(type, 0);
        }

        // Count the number of the occurrences of each ItemTileType in the shelf
        for (int j = 0; j < Shelf.COLUMNS; j++) {
            ItemTileType cellType = shelf.getShelfContent()[rowIndex][j].getTile().getItemTileType();
            Integer prevValue = cellsInRow.get(cellType);
            prevValue = prevValue + 1;
            cellsInRow.put(cellType, prevValue);
        }

        // Check that each entry of the map doesn't contain values over 1.
        for (Map.Entry<ItemTileType, Integer> set : cellsInRow.entrySet()) {
            if (set.getValue() > 1) {
                rowValid = false;
                break;
            }
        }

        return rowValid;
    }
}
