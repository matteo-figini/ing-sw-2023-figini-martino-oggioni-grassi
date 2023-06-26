package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

import java.util.List;

/**
 * This message is used to send to each player a list of all the players connected to the game.
 * This list is used, for example, to set the appropriate layout on the GUI scene.
 */
public class PlayersListMessage extends Message {
    /** List of the nicknames of the players. */
    private final List<String> players;

    /**
     * @param players List of the nicknames of the players.
     */
    public PlayersListMessage (List<String> players) {
        super(Server.SERVER_NAME, MessageType.PLAYERS_LIST);
        this.players = players;
    }

    /**
     * @return List of the nicknames of the players.
     */
    public List<String> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "PlayersListMessage{" +
                "players=" + players +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
