package it.polimi.ingsw.network.message;

public class PingMessage extends Message {

    public PingMessage () {
        super(null, MessageType.PING_MESSAGE);
    }
}
