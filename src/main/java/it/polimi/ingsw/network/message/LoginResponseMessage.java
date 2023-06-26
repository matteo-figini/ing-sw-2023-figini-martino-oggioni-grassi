package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

/**
 * Message used by the server to reply to a login request sending information about the validity of the nickname
 * and the status of the connection.
 */
public class LoginResponseMessage extends Message {
    private final boolean nicknameAccepted;       // Boolean information about the nickname accepted or not
    private final boolean connectionEstablished;  // Boolean information about the connection establishment (successful or not)

    /**
     * @param nicknameAccepted Boolean information about the nickname accepted or not.
     * @param connectionEstablished Boolean information about the connection establishment (successful or not).
     */
    public LoginResponseMessage(boolean nicknameAccepted, boolean connectionEstablished) {
        super(Server.SERVER_NAME, MessageType.LOGIN_REPLY);
        this.nicknameAccepted = nicknameAccepted;
        this.connectionEstablished = connectionEstablished;
    }

    /**
     * @return {@code true} if the suggested nickname is valid and unique, {@code false} otherwise.
     */
    public boolean isNicknameAccepted() {
        return nicknameAccepted;
    }

    /**
     * @return {@code true} if a stable connection is established, {@code false} otherwise.
     */
    public boolean isConnectionEstablished() {
        return connectionEstablished;
    }

    @Override
    public String toString() {
        return "LoginReply{" +
                "nicknameAccepted=" + nicknameAccepted +
                ", connectionEstablished=" + connectionEstablished +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
