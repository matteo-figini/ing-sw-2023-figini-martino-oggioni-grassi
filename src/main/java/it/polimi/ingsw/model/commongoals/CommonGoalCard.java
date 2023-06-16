package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.exception.NoScoringTokenAvailableException;
import it.polimi.ingsw.model.ScoringToken;
import it.polimi.ingsw.model.Shelf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a general common goal card.
 * Every common goal card has got a serial number, a {@code List} of {@code ScoringTokens} representing the available
 * scoring tokens in the game and a textual description (Italian language).
 */
public abstract class CommonGoalCard implements Serializable {
    /** Serial number of the common goal card, from 1 to 12. */
    protected int serialNumber;
    /** {@code List} of {@code ScoringTokens} available during the game. */
    private final List<ScoringToken> scoringTokens;
    /** Textual description of the card. */
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

    /**
     * Constructor that takes in input the number of the players and the card description and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     * @param description Textual description of the card.
     */
    public CommonGoalCard (int numPlayers, String description) {
        this(numPlayers);
        this.description = description;
    }

    /**
     * Constructor that takes in input the number of the players and the card description and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     * @param description Textual description of the card.
     * @param serialNumber Serial number of the card.
     */
    public CommonGoalCard (int numPlayers, String description, int serialNumber) {
        this(numPlayers, description);
        this.serialNumber = serialNumber;
    }

    /**
     * Remove the tile at the top of the stack of scoring tokens and return it.
     * @return The tile at the top of the stack.
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

    /**
     * @return The {@code List} of {@code ScoringTokens} available in the game, from the highest one.
     */
    public List<ScoringToken> getScoringTokens() {
        List<ScoringToken> tokens = new ArrayList<>(this.scoringTokens);
        return tokens;
    }

    /**
     * Abstract method (that will be overridden in the subclasses) that check the single pattern is satisfied.
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

    /**
     * @return The serial number of the card.
     */
    public int getSerialNumber() {
        return this.serialNumber;
    }
}