package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;

// TODO: testare l'algoritmo di controllo delle carte per TwoSquaresGoalCard
public class TwoSquaresGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public TwoSquaresGoalCard(int numPlayers) {
        super(numPlayers, "Due gruppi separati di 4 tessere dello stesso tipo che formano un quadrato 2x2. " + "" +
                "Le tessere dei due gruppi devono essere dello stesso tipo.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        char[][] support = new char[Shelf.ROWS][Shelf.COLUMNS];
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                support[i][j] = 'U';
            }
        }

        Map<ItemTileType, Integer> mapOfColoredGroups = new HashMap<>();
        for (ItemTileType type : ItemTileType.values()) {
            mapOfColoredGroups.put(type, 0);
        }

        for (int i = 0; i < Shelf.ROWS - 1; i++) {
            for (int j = 0; j < Shelf.COLUMNS - 1; j++) {
                if (!shelf.getShelfContent()[i][j].isFree() && support[i][j] == 'U') {
                    if (!shelf.getShelfContent()[i][j + 1].isFree() &&
                            shelf.getShelfContent()[i][j + 1].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType() &&
                            support[i][j + 1] == 'U' &&
                            !shelf.getShelfContent()[i + 1][j + 1].isFree() &&
                            shelf.getShelfContent()[i + 1][j + 1].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType() &&
                            support[i + 1][j + 1] == 'U' &&
                            !shelf.getShelfContent()[i + 1][j].isFree() &&
                            shelf.getShelfContent()[i + 1][j].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType() &&
                            support[i + 1][j] == 'U') {
                        support[i][j + 1] = 'V';
                        support[i + 1][j + 1] = 'V';
                        support[i + 1][j] = 'V';
                        Integer prevValue = mapOfColoredGroups.get(shelf.getShelfContent()[i][j].getTile().getItemTileType());
                        prevValue = prevValue + 1;
                        mapOfColoredGroups.put(shelf.getShelfContent()[i][j].getTile().getItemTileType(), prevValue);
                    }
                }
                support[i][j] = 'V';
            }
        }

        for (Map.Entry<ItemTileType, Integer> set : mapOfColoredGroups.entrySet()) {
            if (set.getValue() >= 2) {
                return true;
            }
        }
        return false;
    }
}
