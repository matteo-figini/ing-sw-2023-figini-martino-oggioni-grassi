package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.exception.NoScoringTokenAvailableException;
import it.polimi.ingsw.model.ScoringToken;
import it.polimi.ingsw.model.Shelf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonGoalCard implements Serializable {
    private int number;
    private final List<ScoringToken> scoringTokens;   // Stack with the scoring tokens.

    protected String description;

    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public CommonGoalCard (int numPlayers) {
        scoringTokens = new ArrayList<>();
        scoringTokens.add(new ScoringToken(8));
        if (numPlayers >= 3) {
            scoringTokens.add(new ScoringToken(6));
        }
        scoringTokens.add(new ScoringToken(4));
        if (numPlayers == 4) {
            scoringTokens.add(new ScoringToken(2));
        }
    }

    public CommonGoalCard (int numPlayers, String description) {
        this(numPlayers);
        this.description = description;
    }

    /**
     * Extract the tile at the top of the stack of scoring tokens.
     * @return The tile at the top of the stack
     * @throws NoScoringTokenAvailableException There aren't available scoring tokens for the card (= stack is empty).
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

    public List<ScoringToken> getScoringTokens() {
        List<ScoringToken> tokens = new ArrayList<>(this.scoringTokens);
        return tokens;
    }

    /**
     * Abstract method (that will be overriden in the subclasses) that check the single pattern is satisfied.
     * @param shelf the shelf where there are tails. Requires that shelf is not null.
     * @return true if the shelf passed as parameter satisfies the condition, false if it doesn't.
     */
    public abstract boolean checkPattern (Shelf shelf);

    /**
     * @return The common goal card description.
     */
    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }
}