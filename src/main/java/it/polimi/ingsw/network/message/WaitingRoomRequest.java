package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

/**
 * This message is used to send information to a client passing to the Waiting Room scene (GUI and TUI).
 */
public class WaitingRoomRequest extends Message {
    public WaitingRoomRequest() {
        super(Server.SERVER_NAME, MessageType.WAITING_ROOM_REQUEST);
    }

    @Override
    public String toString() {
        return "WaitingRoomRequest{" +
                "nickname='" + nickname +
                "is in waiting room" + '\'' +
                '}';
    }
}
