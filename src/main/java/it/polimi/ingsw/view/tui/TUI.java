package it.polimi.ingsw.view.tui;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.network.client.ClientManager;
import it.polimi.ingsw.network.message.GenericMessage;
import it.polimi.ingsw.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TUI implements View {
    private ClientManager clientManager;
    private final Scanner scanner;

    public TUI () {
        scanner = new Scanner(System.in);
        // TODO: azioni di inizio per la view...
    }

    public void startView () {
        System.out.println("Welcome to MyShelfie Game!");
    }

    /**
     * This method asks the user to insert the connection information about the server, such as IP address and port.
     */
    public void askServerInformation () {
        String ipAddress, defaultIpAddress = "127.0.0.1";      // Localhost address.
        int port, defaultPort = 14000;
        boolean validInput = false;

        // Insert and verify the IP address and the port
        do {
            System.out.print("Please insert the IP address of the server (default: " + defaultIpAddress + "): ");
            ipAddress = scanner.nextLine();
            System.out.print("Please insert the port of the server (default: " + defaultPort + "): ");
            port = scanner.nextInt();
            if (ClientManager.isValidIPAddress(ipAddress) && ClientManager.isValidPort(port))
                validInput = true;
        } while (!validInput);

        // TODO: passare le richieste di connessione al client manager.
    }

    @Override
    public void askNickname() {
        System.out.print("Enter your nickname: ");
        // TODO: finire di implementare il metodo
    }

    @Override
    public void askPlayersNumber () {

    }

    @Override
    public void askColumnAndPositions () {
        int numOfPositions, column, row, col;
        List<Position> positions = new ArrayList<>();

        // Number of positions
        do {
            System.out.print("How many tiles do you want to pick up from the board (min. 1, max. 3)? ");
            numOfPositions = scanner.nextInt();
        } while (numOfPositions < 1 || numOfPositions > 3);

        // Positions
        for (int i = 0; i < numOfPositions; i++) {
            System.out.println("Position n° " + (i + 1));

            // Row
            do {
                System.out.print("Row: ");
                row = scanner.nextInt();
            } while (row < 0 || row >= Board.MAX_ROWS);

            // Column
            do {
                System.out.print("Column: ");
                col = scanner.nextInt();
            } while (col < 0 || col >= Board.MAX_COLUMNS);
            positions.add(new Position(row, col));
        }

        // Column
        do {
            System.out.print("What column in your shelf do you want to insert the " + numOfPositions + " tiles? ");
            column = scanner.nextInt();
        } while (column < 0 || column >= Shelf.COLUMNS);

        // TODO: Notify observers that a new PICK_TILES message is ready.
    }

    @Override
    public void showGenericMessage (String message) {
        System.out.println(message);
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

    /* ---------- GETTERS & SETTERS ---------- */
    /**
     * @return The client manager associated to the client.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * @param clientManager The client manager associated to the client.
     */
    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
