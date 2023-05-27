package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.commongoals.CommonGoalCard;

public class CommonGoalCardMessage extends Message {

    /** The {@code CommonGoalCard} contained in the message. */
    private final CommonGoalCard commonGoalCard;

    private final Integer progressiveCard;

    public CommonGoalCardMessage (CommonGoalCard commonGoalCard, Integer progressiveCard) {
        super("SERVER", MessageType.COMMON_GOAL_CARD);
        this.commonGoalCard = commonGoalCard;
        this.progressiveCard = progressiveCard;
    }

    public CommonGoalCard getCommonGoalCard() {
        return commonGoalCard;
    }

    public Integer getProgressiveCard() {
        return progressiveCard;
    }

    @Override
    public String toString() {
        return "CommonGoalCardMessage{" +
                "commonGoalCard=" + commonGoalCard +
                ", progressiveCard=" + progressiveCard +
                '}';
    }
}
