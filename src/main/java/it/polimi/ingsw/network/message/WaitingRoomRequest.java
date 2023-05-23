package it.polimi.ingsw.network.message;

public class WaitingRoomRequest extends Message{
    public WaitingRoomRequest() {
        super("SERVER", MessageType.WAITING_ROOM_REQUEST);
    }

    @Override
    public String toString() {
        return "WaitingRoomRequest{" +
                "nickname='" + nickname +
                "is in waiting room" + '\'' +
                '}';
    }
}
