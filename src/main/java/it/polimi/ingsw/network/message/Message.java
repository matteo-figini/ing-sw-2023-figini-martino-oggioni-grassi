package it.polimi.ingsw.network.message;

import java.io.Serializable;

/**
 * This immutable class represents a message sent between client and server.
 * Every message contains the nickname of the sender/receiver and a type determined by the enumeration {@code MessageType}.
 */
public abstract class Message implements Serializable {
    protected String nickname;         // Nickname of the sender/receiver

    protected MessageType messageType; // Type of the message

    /**
     * Default constructor set the nickname and the type of the message.
     * @param nickname The nickname of the client sender/receiver of the message.
     * @param messageType The type of the message.
     */
    public Message (String nickname, MessageType messageType) {
        this.nickname = nickname;
        this.messageType = messageType;
    }

    /**
     * Returns the nickname of the client.
     * @return The nickname of the client.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Returns the type of the message.
     * @return The type of the message.
     */
    public MessageType getMessageType() {
        return messageType;
    }

    /**
     * Creates a string representation of the message.
     * @return A string representation of the message.
     */
    @Override
    public String toString() {
        return "Message{" +
                "nickname='" + nickname + '\'' +
                ", messageType=" + messageType +
                '}';
    }
}
