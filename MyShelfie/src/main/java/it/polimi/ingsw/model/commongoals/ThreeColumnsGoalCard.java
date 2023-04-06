package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.Shelf;

// TODO: implementare l'algoritmo di controllo delle carte per ThreeColumnsGoalCard
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
        return false;
    }
}
