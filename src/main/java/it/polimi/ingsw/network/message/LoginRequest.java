package it.polimi.ingsw.network.message;

/**
 * Message used by the client to send login information to the server.
 */
public class LoginRequest extends Message {

    public LoginRequest(String nickname) {
        super(nickname, MessageType.LOGIN_REQUEST);
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "nickname='" + this.getNickname() + '\'' +
                '}';
    }
}
