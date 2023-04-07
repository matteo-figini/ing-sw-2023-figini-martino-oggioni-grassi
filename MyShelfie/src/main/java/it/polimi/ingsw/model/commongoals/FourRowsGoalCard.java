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
            Map<ItemTileType, Integer> tilesInRow = new HashMap<>();
            for (ItemTileType type : ItemTileType.values()) {
                tilesInRow.put(type, 0);
            }
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                ShelfCell shelfCell = shelf.getShelfContent()[i][j];
                if (!shelfCell.isFree()) {
                    Integer prevValue = tilesInRow.get(shelfCell.getTile().getItemTileType());
                    prevValue = prevValue + 1;
                    tilesInRow.put(shelfCell.getTile().getItemTileType(), prevValue);
                }
            }

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

        return validRows >= 4;
    }
}
