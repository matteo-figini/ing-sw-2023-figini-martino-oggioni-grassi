package it.polimi.ingsw.network.message;

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
