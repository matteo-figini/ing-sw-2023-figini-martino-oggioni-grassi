package it.polimi.ingsw.network.message;

public class PingMessage extends Message {

    public PingMessage (String sender) {
        super(sender, MessageType.PING_MESSAGE);
    }
}
