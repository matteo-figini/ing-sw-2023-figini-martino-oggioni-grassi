package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;

// TODO: implementare l'algoritmo di controllo delle carte per EightEqualsGoalCard
public class EightEqualsGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers
     */
    public EightEqualsGoalCard(int numPlayers) {
        super(numPlayers);
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        Map<ItemTileType, Integer> occurrences = new HashMap<>();
        occurrences.put(ItemTileType.LIGHTBLUE, 0);
        occurrences.put(ItemTileType.BLUE, 0);
        occurrences.put(ItemTileType.YELLOW, 0);
        occurrences.put(ItemTileType.GREEN, 0);
        occurrences.put(ItemTileType.PINK, 0);
        occurrences.put(ItemTileType.WHITE, 0);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (!shelf.getShelfContent()[i][j].isFree()) {

                }
            }
        }

        return false;
    }
}
