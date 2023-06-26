package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

/**
 * Message sent from the server to the client asking the number of the players in the game.
 */
public class PlayersNumberRequest extends Message {
    public PlayersNumberRequest() {
        super(Server.SERVER_NAME, MessageType.PLAYERS_NUMBER_REQUEST);
    }

    @Override
    public String toString() {
        return "PlayersNumberRequest{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
