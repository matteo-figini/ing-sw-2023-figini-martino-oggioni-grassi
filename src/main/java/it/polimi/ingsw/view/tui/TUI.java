package it.polimi.ingsw.view.tui;

import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.view.View;

public class TUI implements View {

    @Override
    public void askNickname() {
        System.out.print("Enter your nickname: ");
        // TODO: finire di implementare il metodo
    }

    @Override
    public void askPlayersNumber() {

    }

    @Override
    public void askColumnAndPositions() {

    }

    @Override
    public void showGenericMessage (String genericMessage) {

    }

    @Override
    public void showBoardContent (BoardCell[][] boardContent) {
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
        System.out.println("Shelf of " + nickname + ":");
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
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
