package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.network.Server;

/**
 * This class represents a message that contains a common goal card.
 * This message is sent from the server to one or more clients.
 */
public class CommonGoalCardMessage extends Message {

    /** The {@code CommonGoalCard} contained in the message. */
    private final CommonGoalCard commonGoalCard;

    /** Progressive number of the card. */
    private final Integer progressiveCard;

    public CommonGoalCardMessage (CommonGoalCard commonGoalCard, Integer progressiveCard) {
        super(Server.SERVER_NAME, MessageType.COMMON_GOAL_CARD);
        this.commonGoalCard = commonGoalCard;
        this.progressiveCard = progressiveCard;
    }

    /**
     * @return The {@code CommonGoalCard} contained in the message.
     */
    public CommonGoalCard getCommonGoalCard() {
        return commonGoalCard;
    }

    /**
     * @return The progressive number of the card in the game.
     */
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
