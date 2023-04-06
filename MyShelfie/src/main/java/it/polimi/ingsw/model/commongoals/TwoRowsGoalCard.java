package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.Shelf;

// TODO: implementare l'algoritmo di controllo delle carte per TwoRowsGoalCard
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
        return false;
    }
}
