package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.Position;

import java.util.List;

/**
 * Message sent from the client to the server specifying a list of positions where to pick the tiles from the board
 * and the column in the shelf where to insert them.
 */
public class PickTilesReply extends Message {
    private List<Position> positionsOfTiles;    // List of the positions of tiles in the board.
    private int column;                         // Column on the shelf.

    public PickTilesReply(String nickname, List<Position> positionsOfTiles, int column) {
        super(nickname, MessageType.PICK_TILES_REPLY);
        this.positionsOfTiles = positionsOfTiles;
        this.column = column;
    }

    public List<Position> getPositionsOfTiles() {
        return positionsOfTiles;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "PickTiles{" +
                "positionsOfTiles=" + positionsOfTiles +
                ", column=" + column +
                '}';
    }
}
