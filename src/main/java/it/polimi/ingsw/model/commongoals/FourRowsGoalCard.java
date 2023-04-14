package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;

import java.util.HashMap;
import java.util.Map;

// TODO: testare l'algoritmo di controllo delle carte per FourRowsGoalCard
public class FourRowsGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public FourRowsGoalCard(int numPlayers) {
        super(numPlayers, "Quattro righe formate ciascuna da 5 tessere di uno, due o tre tipi differenti. " +
                "Righe diverse possono avere combinazioni diverse di tipi di tessere.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        int validRows = 0;

        for (int i = 0; i < Shelf.ROWS; i++) {
            boolean containsFreeCells;

            Map<ItemTileType, Integer> tilesInRow = new HashMap<>();
            for (ItemTileType type : ItemTileType.values()) {
                tilesInRow.put(type, 0);
            }

            assert tilesInRow.size() == 6;

            containsFreeCells = false;
            for (int j = 0; j < Shelf.COLUMNS && !containsFreeCells; j++) {
                if (!shelf.getShelfContent()[i][j].isFree()) {
                    Integer prevValue = tilesInRow.get(shelf.getShelfContent()[i][j].getTile().getItemTileType());
                    prevValue = prevValue + 1;
                    tilesInRow.put(shelf.getShelfContent()[i][j].getTile().getItemTileType(), prevValue);
                } else {
                    containsFreeCells = true;
                }
            }

            if (!containsFreeCells) {
                int keysWithZeroVal = 0;
                for (Map.Entry<ItemTileType, Integer> set : tilesInRow.entrySet()) {
                    if (set.getValue() == 0) {
                        keysWithZeroVal++;
                    }
                }
                if (keysWithZeroVal >= 3) {
                    validRows++;
                }
            }
        }

        return (validRows >= 4);
    }
}
