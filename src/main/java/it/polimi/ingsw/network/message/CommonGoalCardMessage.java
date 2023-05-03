package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.commongoals.CommonGoalCard;

public class CommonGoalCardMessage extends Message {

    /** The {@code CommonGoalCard} contained in the message. */
    private CommonGoalCard commonGoalCard;

    public CommonGoalCardMessage (CommonGoalCard commonGoalCard) {
        super("SERVER", MessageType.COMMON_GOAL_CARD);
        this.commonGoalCard = commonGoalCard;
    }

    public CommonGoalCard getCommonGoalCard() {
        return commonGoalCard;
    }

    @Override
    public String toString() {
        return "CommonGoalCardMessage{" +
                "commonGoalCard=" + commonGoalCard +
                '}';
    }
}
