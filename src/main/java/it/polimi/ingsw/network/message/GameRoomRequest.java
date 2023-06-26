package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

/**
 * This message is sent whether the client is required to switch to the Game Room scene (in GUI)
 * or indicating that the game started (in TUI).
 */
public class GameRoomRequest extends Message{
    public GameRoomRequest() {
        super(Server.SERVER_NAME, MessageType.GAME_ROOM_REQUEST);
    }

    @Override
    public String toString() {
        return "GameRoomRequest{" +
                "nickname='" + nickname +
                "is in game room" + '\'' +
                '}';
    }
}
