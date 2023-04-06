package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.Shelf;

// TODO: implementare l'algoritmo di controllo delle carte per TwoSquaresGoalCard
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
        return false;
    }
}
