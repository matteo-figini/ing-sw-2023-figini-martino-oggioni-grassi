package it.polimi.ingsw.network.message;

/**
 * This message signals to the client to choose the position on the board in the game and the column.
 */
public class PickTilesRequest extends Message {

    public PickTilesRequest () {
        super("SERVER", MessageType.PICK_TILES_REQUEST);
    }
}
