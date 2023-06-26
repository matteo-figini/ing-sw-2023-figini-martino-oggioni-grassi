package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.Server;

/**
 * This message represents a personal goal card sent from the server to a client.
 */
public class PersonalGoalCardMessage extends Message {
    /** Reference to the {@code PersonalGoalCard}. */
    private final PersonalGoalCard personalGoalCard;
    /** String representing the owner of the card. */
    private final String cardOwner;

    /**
     * @param personalGoalCard Reference to the {@code PersonalGoalCard}
     * @param owner String representing the owner of the card.
     */
    public PersonalGoalCardMessage (PersonalGoalCard personalGoalCard, String owner) {
        super(Server.SERVER_NAME, MessageType.PERSONAL_GOAL_CARD);
        this.personalGoalCard = personalGoalCard;
        this.cardOwner = owner;
    }

    /**
     * @return Reference to the {@code PersonalGoalCard}
     */
    public PersonalGoalCard getPersonalGoalCard() {
        return personalGoalCard;
    }

    /**
     * @return String representing the owner of the card
     */
    public String getCardOwner() {
        return cardOwner;
    }

    @Override
    public String toString() {
        return "PersonalGoalCardMessage{" +
                "personalGoalCard=" + personalGoalCard +
                ", cardOwner='" + cardOwner + '\'' +
                '}';
    }
}
