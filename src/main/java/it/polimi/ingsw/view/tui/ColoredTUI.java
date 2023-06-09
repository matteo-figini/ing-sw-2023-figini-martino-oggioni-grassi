package it.polimi.ingsw.view.tui;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;

import java.util.HashMap;
import java.util.Map;

/**
 * This class extends the {@code TUI} class in order to handle a better text user interface using ANSI escape
 * codes for printing the board and the shelf.
 */
public class ColoredTUI extends TUI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_TEXT = "\u001B[31m";
    public static final String ANSI_WHITE_BACKGROUND = "\033[48;5;231m";
    public static final String ANSI_GREEN_BACKGROUND = "\033[48;5;34m";
    public static final String ANSI_BLUE_BACKGROUND = "\033[48;5;19m";
    public static final String ANSI_LIGHTBLUE_BACKGROUND = "\033[48;5;31m";
    public static final String ANSI_PINK_BACKGROUND = "\033[48;5;205m";
    public static final String ANSI_YELLOW_BACKGROUND = "\033[48;5;220m";

    @Override
    public void showBoardContent (BoardCell[][] boardContent) {
        System.out.println("Board:");
        System.out.print("  | ");
        for (int j = 0; j < Board.MAX_COLUMNS; j++) {
            System.out.print(j + "   ");
        }
        System.out.println("\n---------------------------");
        for (int i = 0; i < Board.MAX_ROWS; i++) {
            for (int j = 0; j < Board.MAX_COLUMNS; j++) {
                if (j == 0)
                    System.out.print(i + " | ");
                if (boardContent[i][j].isPlayable()) {
                    if (!boardContent[i][j].isFree()) {
                        drawItemTile(boardContent[i][j].getItemTile().getItemTileType());
                        System.out.print(" ");

                    } else {
                        System.out.print("-   ");
                    }
                } else {
                    System.out.print("x   ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void showPlayerInformation(String player, ShelfCell[][] shelfContent, ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken) {
        System.out.println("Shelf of " + player + ":");
        System.out.print("  | ");
        for (int i = 0; i < Shelf.COLUMNS; i++)
            System.out.print(i + "   ");
        System.out.println("\n-----------------------");
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                if (j == 0)
                    System.out.print(i + " | ");
                if (!shelfContent[i][j].isFree()) {
                    drawItemTile(shelfContent[i][j].getTile().getItemTileType());
                    System.out.print(" ");
                } else {
                    System.out.print("-   ");
                }
            }
            System.out.println();
        }
        showTokensInformation(firstCommonGoal, secondCommonGoal, hasEndGameToken);
    }

    @Override
    public void showPersonalGoalCard (PersonalGoalCard personalGoalCard, String cardOwner) {
        Map<Position, ItemTileType> copySchema = new HashMap<>(personalGoalCard.getSchema());
        System.out.println("Personal goal card of " + cardOwner + ":");

        System.out.print("  | ");
        for (int i = 0; i < Shelf.COLUMNS; i++) {
            System.out.print(i + "   ");
        }
        System.out.println("\n-----------------------");
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                if (j == 0)
                    System.out.print(i + " | ");
                Position position = new Position(i, j);
                if (copySchema.containsKey(position)) {
                    drawItemTile(copySchema.get(position));
                    System.out.print(" ");
                } else {
                    System.out.print("-   ");
                }
            }
            // System.out.println();
            System.out.println();
        }
    }

    private void drawItemTile (ItemTileType itemTileType) {
        switch (itemTileType) {
            case GREEN -> System.out.print(ANSI_GREEN_BACKGROUND + "   " + ANSI_RESET);
            case WHITE -> System.out.print(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
            case YELLOW -> System.out.print(ANSI_YELLOW_BACKGROUND + "   " + ANSI_RESET);
            case BLUE -> System.out.print(ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET);
            case LIGHTBLUE -> System.out.print(ANSI_LIGHTBLUE_BACKGROUND + "   " + ANSI_RESET);
            case PINK -> System.out.print(ANSI_PINK_BACKGROUND + "   " + ANSI_RESET);
            default -> System.out.print(ANSI_RED_TEXT + "?  " + ANSI_RESET);
        }
    }
}
