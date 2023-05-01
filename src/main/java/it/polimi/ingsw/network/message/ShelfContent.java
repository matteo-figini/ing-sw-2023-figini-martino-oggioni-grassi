package it.polimi.ingsw.network.message;

import it.polimi.ingsw.model.ShelfCell;

import java.util.Arrays;

public class ShelfContent extends Message {
    private ShelfCell[][] shelfContent;
    private String player;

    /**
     * This constructor receives in input a reference to a matrix containing the shelf cells.
     * It is recommended to pass a copy of the shelf content, instead of the original content.
     * @param shelfContent A reference to a matrix containing the shelf cells.
     */
    public ShelfContent (ShelfCell[][] shelfContent, String player) {
        super("SERVER", MessageType.SHELF_CONTENT);
        this.shelfContent = shelfContent;
        this.player = player;
    }

    public ShelfCell[][] getShelfContent() {
        return shelfContent;
    }

    public String getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "ShelfContent{" +
                "shelfContent=" + Arrays.toString(shelfContent) +
                ", player='" + player + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
