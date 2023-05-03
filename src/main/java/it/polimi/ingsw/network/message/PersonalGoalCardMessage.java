package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;

public class PersonalGoalCardMessage extends Message {

    /** */
    private final PersonalGoalCard personalGoalCard;

    public PersonalGoalCardMessage (PersonalGoalCard personalGoalCard) {
        super("SERVER", MessageType.PERSONAL_GOAL_CARD);
        this.personalGoalCard = personalGoalCard;
    }

    public PersonalGoalCard getPersonalGoalCard() {
        return personalGoalCard;
    }

    @Override
    public String toString() {
        return "PersonalGoalCardMessage{" +
                "personalGoalCard=" + personalGoalCard +
                '}';
    }
}
