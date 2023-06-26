package it.polimi.ingsw.network.message;

/**
 * Message used by the client to send login information to the server.
 */
public class LoginRequestMessage extends Message {

    /**
     * The Constructor of the message sends information about the nickname of the client.
     * @param nickname Nickname suggested from the client.
     */
    public LoginRequestMessage(String nickname) {
        super(nickname, MessageType.LOGIN_REQUEST);
    }

    @Override
    public String toString() {
        return "LoginRequestMessage{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
