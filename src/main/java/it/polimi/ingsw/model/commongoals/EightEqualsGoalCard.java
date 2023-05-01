package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;

// TODO: testare l'algoritmo di controllo delle carte per EightEqualsGoalCard
public class EightEqualsGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public EightEqualsGoalCard(int numPlayers) {
        super(numPlayers, "Otto tessere dello stesso tipo. Non ci sono restrizioni sulla posizione di queste tessere.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        Map<ItemTileType, Integer> occurrences = new HashMap<>();
        for (ItemTileType type : ItemTileType.values()) {
            occurrences.put(type, 0);
        }

        // Aggiorno il valore nella mappa rispetto alla chiave corrispondente al tipo della cella.
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                if (!shelf.getShelfContent()[i][j].isFree()) {
                    Integer prevValue = occurrences.get(shelf.getShelfContent()[i][j].getTile().getItemTileType());
                    prevValue = prevValue + 1;
                    occurrences.put(shelf.getShelfContent()[i][j].getTile().getItemTileType(), prevValue);
                }
            }
        }

        // Controllo che almeno uno dei tipi desiderati contenga più di 8 celle.
        for (Map.Entry<ItemTileType, Integer> set : occurrences.entrySet()) {
            if (set.getValue() >= 8) {
                return true;
            }
        }
        return false;
    }
}
