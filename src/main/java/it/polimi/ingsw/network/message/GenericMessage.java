package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

/**
 * Message used from the server to send text information to a client.
 * It inherits from {@code Message} class and contains a string for the message.
 */
public class GenericMessage extends Message {
    private final String genericMessage;

    public GenericMessage (String genericMessage) {
        super (Server.SERVER_NAME, MessageType.GENERIC_MESSAGE);
        this.genericMessage = genericMessage;
    }

    /**
     * @return The generic message.
     */
    public String getGenericMessage () {
        return genericMessage;
    }

    @Override
    public String toString() {
        return "GenericMessage{" +
                "genericMessage='" + genericMessage + '\'' +
                ", nickname='" + nickname + '\'' +
                ", messageType=" + messageType +
                '}';
    }
}
