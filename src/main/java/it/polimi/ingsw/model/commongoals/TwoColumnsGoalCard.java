package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;

// TODO: testare l'algoritmo di controllo delle carte per TwoColumnsGoalCard
public class TwoColumnsGoalCard extends CommonGoalCard {
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
            Map<ItemTileType, Integer> cellsInCol = new HashMap<>();
            for (ItemTileType type : ItemTileType.values()) {
                cellsInCol.put(type, 0);
            }

            for (int i = 0; i < Shelf.ROWS; i++) {
                if (!shelf.getShelfContent()[i][j].isFree()) {
                    Integer prevValue = cellsInCol.get(shelf.getShelfContent()[i][j].getTile().getItemTileType());
                    prevValue = prevValue + 1;
                    cellsInCol.put(shelf.getShelfContent()[i][j].getTile().getItemTileType(), prevValue);
                }
            }

            boolean validColumn = true;
            for (Map.Entry<ItemTileType, Integer> set : cellsInCol.entrySet()) {
                if (set.getValue() != 1) {
                    validColumn = false;
                    break;
                }
            }
            if (validColumn)
                validColumns++;
        }

        return validColumns >= 2;
    }
}
