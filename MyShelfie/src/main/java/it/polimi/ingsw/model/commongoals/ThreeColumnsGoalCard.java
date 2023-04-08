package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;

import java.util.HashMap;
import java.util.Map;

// TODO: testare l'algoritmo di controllo delle carte per ThreeColumnsGoalCard
public class ThreeColumnsGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public ThreeColumnsGoalCard(int numPlayers) {
        super(numPlayers, "Tre colonne formate ciascuna da 6 tessere di uno, due o tre tipi differenti. " +
                "Colonne diverse possono avere combinazioni diverse di tipi di tessere.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        int validColumns = 0;

        for (int j = 0; j < Shelf.COLUMNS; j++) {
            boolean containsFreeCells = false;
            Map<ItemTileType, Integer> tilesInCol = new HashMap<>();
            for (ItemTileType type : ItemTileType.values()) {
                tilesInCol.put(type, 0);
            }

            for (int i = 0; i < Shelf.ROWS && !containsFreeCells; i++) {
                if (!shelf.getShelfContent()[i][j].isFree()) {
                    Integer prevValue = tilesInCol.get(shelf.getShelfContent()[i][j].getTile().getItemTileType());
                    prevValue = prevValue + 1;
                    tilesInCol.put(shelf.getShelfContent()[i][j].getTile().getItemTileType(), prevValue);
                } else {
                    containsFreeCells = true;
                }
            }

            if (!containsFreeCells) {
                int keysWithZeroVal = 0;
                for (Map.Entry<ItemTileType, Integer> set : tilesInCol.entrySet()) {
                    if (set.getValue() == 0) {
                        keysWithZeroVal++;
                    }
                }
                if (keysWithZeroVal >= 3) {
                    validColumns++;
                }
            }
        }

        return validColumns >= 3;
    }
}
