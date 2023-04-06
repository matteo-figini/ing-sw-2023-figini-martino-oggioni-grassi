package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.Shelf;

// TODO: implementare l'algoritmo di controllo delle carte per DiagonalFiveGoalCard
public class DiagonalFiveGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public DiagonalFiveGoalCard(int numPlayers) {
        super(numPlayers, "Cinque tessere dello stesso tipo che formano una diagonale.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        return false;
    }
}
