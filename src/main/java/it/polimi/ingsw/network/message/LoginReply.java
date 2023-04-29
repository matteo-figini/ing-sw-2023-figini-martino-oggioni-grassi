package it.polimi.ingsw.network.message;

/**
 * Message used by the server to reply to a login request sending information about the validity of the nickname
 * and the status of the connection.
 */
public class LoginReply extends Message {
    private final boolean nicknameAccepted;       // Boolean information about the nickname accepted or not
    private final boolean connectionEstablished;  // Boolean information about the connection establishment (successful or not)

    public LoginReply(boolean nicknameAccepted, boolean connectionEstablished) {
        super("SERVER", MessageType.LOGIN_REPLY);
        this.nicknameAccepted = nicknameAccepted;
        this.connectionEstablished = connectionEstablished;
    }

    public boolean isNicknameAccepted() {
        return nicknameAccepted;
    }

    public boolean isConnectionEstablished() {
        return connectionEstablished;
    }

    @Override
    public String toString() {
        return "LoginReply{" +
                "nicknameAccepted=" + nicknameAccepted +
                ", connectionEstablished=" + connectionEstablished +
                ", nickname='" + this.getNickname() + '\'' +
                '}';
    }
}
