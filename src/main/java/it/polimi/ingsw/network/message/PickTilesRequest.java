package it.polimi.ingsw.network.message;

import it.polimi.ingsw.network.Server;

/**
 * This message signals to the client to choose the position on the board in the game and the column.
 */
public class PickTilesRequest extends Message {
    public PickTilesRequest () {
        super(Server.SERVER_NAME, MessageType.PICK_TILES_REQUEST);
    }
}
