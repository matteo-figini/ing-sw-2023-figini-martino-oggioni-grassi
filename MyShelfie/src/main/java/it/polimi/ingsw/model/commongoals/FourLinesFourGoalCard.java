package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.Shelf;

// TODO: implementare l'algoritmo di controllo delle carte per FourLinesFourGoalCard
public class FourLinesFourGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public FourLinesFourGoalCard(int numPlayers) {
        super(numPlayers , "Quattro gruppi separati formati ciascuno da quattro tessere adiacenti dello stesso tipo, disposte " + "" +
                "in orizzontale oppure in verticale. Le tessere di un gruppo possono essere diverse da quelle di un altro gruppo.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        return false;
    }
}
