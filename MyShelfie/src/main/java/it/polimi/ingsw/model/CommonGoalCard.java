package it.polimi.ingsw.model;

import it.polimi.ingsw.exception.NoScoringTokenAvailableException;
import java.util.List;

public abstract class CommonGoalCard {
    private List<ScoringToken> scoringTokens;   // Stack with the scoring tokens.

    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers
     */
    public CommonGoalCard (int numPlayers) {
        // Nel costruttore si inizializzano le tessere del punteggio in base al numero di giocatori
        scoringTokens.add(new ScoringToken(8));
        if (numPlayers >= 3) {
            scoringTokens.add(new ScoringToken(6));
        }
        scoringTokens.add(new ScoringToken(4));
        if (numPlayers == 4) {
            scoringTokens.add(new ScoringToken(2));
        }
    }

    /**
     * Extract the card in the top of the stack of scoring tokens.
     * @return the card in the top of the stack
     * @throws NoScoringTokenAvailableException there aren't available scoring tokens for the card (= stack is empty).
     */
    public ScoringToken popScoringToken () throws NoScoringTokenAvailableException {
        ScoringToken token;
        if (this.scoringTokens.size() == 0) {
            throw new NoScoringTokenAvailableException();
        } else {
            token = scoringTokens.remove(0);
            return token;
        }
    }

    /**
     * Abstract method that will be overriden in the subclasses that check the single pattern is satisfied.
     * @param shelf the shelf where there are tails. Requires that shelf is not null.
     * @return true if the shelf passed as parameter satisfies the condition, false if it doesn't.
     */
    public abstract boolean checkPattern (Shelf shelf);
}