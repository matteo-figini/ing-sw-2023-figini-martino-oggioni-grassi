package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;

/**
 *
 */
public class PersonalGoalCardMessage extends Message {

    /** */
    private final PersonalGoalCard personalGoalCard;
    private final String cardOwner;

    public PersonalGoalCardMessage (PersonalGoalCard personalGoalCard, String owner) {
        super("SERVER", MessageType.PERSONAL_GOAL_CARD);
        this.personalGoalCard = personalGoalCard;
        this.cardOwner = owner;
    }

    public PersonalGoalCard getPersonalGoalCard() {
        return personalGoalCard;
    }

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
