package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.BoardCell;

import java.util.Arrays;

// TODO: add Javadoc for the method
public class BoardContent extends Message {
    private BoardCell[][] boardContent;

    /**
     * This constructor receives in input a reference to a matrix containing the board cells.
     * It is recommended to pass a copy of the board content, instead of the original content.
     * @param boardContent A reference to a matrix representing the board.
     */
    public BoardContent (BoardCell[][] boardContent) {
        super("SERVER", MessageType.BOARD_CONTENT);
        this.boardContent = boardContent;
    }

    // TODO: add Javadoc for the method
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
