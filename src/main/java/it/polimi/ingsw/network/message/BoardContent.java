package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.BoardCell;

import java.util.Arrays;

/**
 * This class represents a message that contains a copy of the game board.
 * This message is sent from the server to one or more clients.
 */
public class BoardContent extends Message {
    /** Matrix of {@code BoardCell} that represents a copy of the board content. */
    private final BoardCell[][] boardContent;

    /**
     * This constructor receives in input a reference to a matrix containing the board cells.
     * It is recommended to pass a copy of the board content, instead of the original content.
     * @param boardContent A reference to a matrix representing the board.
     */
    public BoardContent (BoardCell[][] boardContent) {
        super("SERVER", MessageType.BOARD_CONTENT);
        this.boardContent = boardContent;
    }

    /**
     * @return The board content contained in the message.
     */
    public BoardCell[][] getBoardContent() {
        return boardContent;
    }

    @Override
    public String toString() {
        return "BoardContent{" +
                "boardContent=" + Arrays.toString(boardContent) +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
