package it.polimi.ingsw.network.message;

/**
 * This message is sent whether the client is required to switch to the Game Room scene (in GUI)
 * or indicating that the game started (in TUI).
 */
public class GameRoomRequest extends Message{
    public GameRoomRequest() {
        super("SERVER", MessageType.GAME_ROOM_REQUEST);
    }

    @Override
    public String toString() {
        return "GameRoomRequest{" +
                "nickname='" + nickname +
                "is in game room" + '\'' +
                '}';
    }
}
