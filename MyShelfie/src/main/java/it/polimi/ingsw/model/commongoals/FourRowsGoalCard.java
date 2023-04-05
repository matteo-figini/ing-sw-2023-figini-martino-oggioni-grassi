package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.Shelf;

// TODO: implementare l'algoritmo di controllo delle carte per FourRowsGoalCard
public class FourRowsGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     *
     * @param numPlayers
     */
    public FourRowsGoalCard(int numPlayers) {
        super(numPlayers);
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        return false;
    }
}
