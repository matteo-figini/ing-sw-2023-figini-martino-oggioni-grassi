package it.polimi.ingsw.view.tui;

import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;

/**
 * This class extends the {@code TUI} class in order to handle a better text user interface using ANSI escape
 * codes for printing the board and the shelf.
 */
public class ColoredTUI extends TUI {
    public static final String ANSI_WHITE_BACKGROUND = "\033[48;5;231m";
    public static final String ANSI_GREEN_BACKGROUND = "\033[48;5;34m";
    public static final String ANSI_BLUE_BACKGROUND = "\033[48;5;19m";
    public static final String ANSI_LIGHTBLUE_BACKGROUND = "\033[48;5;31m";
    public static final String ANSI_PINK_BACKGROUND = "\033[48;5;205m";
    public static final String ANSI_YELLOW_BACKGROUND = "\033[48;5;220m";

    @Override
    public void showBoardContent (BoardCell[][] boardContent) {
        // TODO: adapt this method!
        System.out.println("Actual board:");
        for (int i = 0; i < Board.MAX_ROWS; i++) {
            for (int j = 0; j < Board.MAX_COLUMNS; j++) {
                if (boardContent[i][j].isPlayable()) {
                    if (!boardContent[i][j].isFree()) {
                        switch (boardContent[i][j].getItemTile().getItemTileType()) {
                            case GREEN -> System.out.print("G ");
                            case WHITE -> System.out.print("W ");
                            case YELLOW -> System.out.print("Y ");
                            case BLUE -> System.out.print("B ");
                            case LIGHTBLUE -> System.out.print("L ");
                            case PINK -> System.out.print("P ");
                            default -> System.out.print("? ");
                        }
                    } else {
                        System.out.print("- ");
                    }
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void showShelfContent (ShelfCell[][] shelfContent, String nickname) {
        // TODO: adapt this method!
        System.out.println("Shelf of " + nickname + ":");
        System.out.print("  | ");
        for (int i = 0; i < Shelf.COLUMNS; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n--------------");
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                if (j == 0)
                    System.out.print(i + " | ");
                if (!shelfContent[i][j].isFree()) {
                    switch (shelfContent[i][j].getTile().getItemTileType()) {
                        case GREEN -> System.out.print("G ");
                        case WHITE -> System.out.print("W ");
                        case YELLOW -> System.out.print("Y ");
                        case BLUE -> System.out.print("B ");
                        case LIGHTBLUE -> System.out.print("L ");
                        case PINK -> System.out.print("P ");
                        default -> System.out.print("? ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
