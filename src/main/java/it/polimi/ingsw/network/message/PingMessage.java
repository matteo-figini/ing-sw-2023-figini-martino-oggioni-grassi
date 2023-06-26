package it.polimi.ingsw.network.message;

/**
 * This message is used to keep alive the ping from server to client or vice-versa.
 */
public class PingMessage extends Message {

    public PingMessage (String sender) {
        super(sender, MessageType.PING_MESSAGE);
    }
}
