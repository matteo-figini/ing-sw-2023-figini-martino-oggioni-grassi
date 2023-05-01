package it.polimi.ingsw.view.tui;

import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.network.client.ClientManager;
import it.polimi.ingsw.view.View;

import java.util.Scanner;

public class TUI implements View {
    private ClientManager clientManager;

    public TUI () {
        // TODO: azioni di inizio per la view...
    }

    public void init () {
        System.out.println("Welcome to MyShelfie Game!");
    }

    /**
     * This method asks the user to insert the connection information about the server, such as IP address and port.
     */
    public void askServerInformation () {
        String ipAddress;
        String defaultIpAddress = "127.0.0.1";      // Localhost address.
        int port;
        int defaultPort = 14000;
        Scanner scn = new Scanner(System.in);
        boolean validInput = true;

        System.out.println("Please enter the information about IP address and port of the server: ");

        // Insert and verify the IP address
        do {
            ipAddress = scn.nextLine();
            // TODO: implementare il controllo dell'indirizzo IP (vedi classe ClientManager).
        } while (!validInput);

        // Insert and verify the port
        do {
            System.out.print("Inserisci il numero di porta: ");
            port = scn.nextInt();
            if (ClientManager.isValidPort(port)) {
                validInput = true;
            }
        } while (!validInput);

        // TODO: passare le richieste di connessione al client manager.
    }

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
