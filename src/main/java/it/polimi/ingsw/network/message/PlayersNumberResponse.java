package it.polimi.ingsw.network.message;

/**
 * Message sent from the client to the server specifying the number of the player in the game.
 */
public class PlayersNumberResponse extends Message {
    private final int playersNumber;        // Number of the players in the game.

    /**
     * @param nickname Client sender of the information about the number of the players.
     * @param playersNumber Number of the players in the game.
     */
    public PlayersNumberResponse(String nickname, int playersNumber) {
        super(nickname, MessageType.PLAYERSNUMBER_REPLY);
        this.playersNumber = playersNumber;
    }

    /**
     * @return Number of the players in the game.
     */
    public int getPlayersNumber() {
        return playersNumber;
    }

    @Override
    public String toString() {
        return "PlayersNumberReply{" +
                "playersNumber=" + playersNumber +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
