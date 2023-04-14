package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;

// TODO: testare l'algoritmo di controllo delle carte per TwoRowsGoalCard
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
            Map<ItemTileType, Integer> cellsInRow = new HashMap<>();

            for (ItemTileType type : ItemTileType.values()) {
                cellsInRow.put(type, 0);
            }

            for (int j = 0; j < Shelf.COLUMNS; j++) {
                if (!shelf.getShelfContent()[i][j].isFree()) {
                    Integer prevValue = cellsInRow.get(shelf.getShelfContent()[i][j].getTile().getItemTileType());
                    prevValue = prevValue + 1;
                    cellsInRow.put(shelf.getShelfContent()[i][j].getTile().getItemTileType(), prevValue);
                }
            }

            boolean validRow = true;
            for (Map.Entry<ItemTileType, Integer> set : cellsInRow.entrySet()) {
                if (set.getValue() != 1 && set.getValue() != 0) {
                    validRow = false;
                    break;
                }
            }
            if (validRow)
                validRows++;
        }
        return validRows >= 2;
    }
}
