package it.polimi.ingsw.network.message;

import java.util.List;

public class PlayersListMessage extends Message {
    /** List of the nicknames of the players. */
    private final List<String> players;

    public PlayersListMessage (List<String> players) {
        super("SERVER", MessageType.PLAYERS_LIST);
        this.players = players;
    }

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
