package it.polimi.ingsw.view.tui;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.View;

import java.util.*;

public class TUI implements View {
    /** The {@code ClientManager} associated to the client. */
    private ClientManager clientManager;

    /** Class for reading inputs from terminal. */
    private final Scanner scanner;

    public TUI () {
        scanner = new Scanner(System.in);
    }

    public void startView () {
        System.out.println("""

                         ___                          ,-,--.  ,--.-,,-,--,    ,----.                _,---.   .=-.-.   ,----. \s
                  .-._ .'=.'\\ ,--.-.  .-,--.        ,-.'-  _\\/==/  /|=|  | ,-.--` , \\   _.-.     .-`.' ,  \\ /==/_ /,-.--` , \\\s
                 /==/ \\|==|  /==/- / /=/_ /        /==/_ ,_.'|==|_ ||=|, ||==|-  _.-` .-,.'|    /==/_  _.-'|==|, ||==|-  _.-`\s
                 |==|,|  / - \\==\\, \\/=/. /         \\==\\  \\   |==| ,|/=| _||==|   `.-.|==|, |   /==/-  '..-.|==|  ||==|   `.-.\s
                 |==|  \\/  , |\\==\\  \\/ -/           \\==\\ -\\  |==|- `-' _ /==/_ ,    /|==|- |   |==|_ ,    /|==|- /==/_ ,    /\s
                 |==|- ,   _ | |==|  ,_/            _\\==\\ ,\\ |==|  _     |==|    .-' |==|, |   |==|   .--' |==| ,|==|    .-' \s
                 |==| _ /\\   | \\==\\-, /            /==/\\/ _ ||==|   .-. ,\\==|_  ,`-._|==|- `-._|==|-  |    |==|- |==|_  ,`-._\s
                 /==/  / / , / /==/._/             \\==\\ - , //==/, //=/  /==/ ,     //==/ - , ,/==/   \\    /==/. /==/ ,     /\s
                 `--`./  `--`  `--`-`               `--`---' `--`-' `-`--`--`-----`` `--`-----'`--`---'    `--`-``--`-----`` \s
                """);
        System.out.println("Welcome to MyShelfie Game!");
        askServerInformation();
    }

    /**
     * This method asks the user to insert the connection information about the server, such as IP address and port.
     * Then it delegates the connection to the {@code ClientManager}.
     */
    public void askServerInformation () {
        String ipAddress, defaultIpAddress = "127.0.0.1", input;      // Localhost address.
        int port, defaultPort = 5000;
        boolean validInput = false;

        // Insert and verify the IP address and the port
        do {
            System.out.print("Please insert the IP address of the server (default: " + defaultIpAddress + "): ");
            ipAddress = scanner.nextLine();
            if (ipAddress.equalsIgnoreCase(""))
                ipAddress = defaultIpAddress;
            System.out.print("Please insert the port of the server (default: " + defaultPort + "): ");
            input = scanner.nextLine();
            if (input.equals(""))
                port = defaultPort;
            else
                port = Integer.parseInt(input);

            if (ClientManager.isValidIPAddress(ipAddress) && ClientManager.isValidPort(port))
                validInput = true;
        } while (!validInput);

        clientManager.onUpdateServerInformation(ipAddress, port);
    }

    @Override
    public void askNickname() {
        System.out.print("Enter your nickname: ");
        String nickname = scanner.nextLine();
        clientManager.onUpdateNickname(nickname);
    }

    @Override
    public void askPlayersNumber () {
        int numOfPlayers;           // Default players number
        do {
            System.out.print("How many players do you want to play with (between 2 and 4)? ");
            numOfPlayers = Integer.parseInt(scanner.nextLine());
        } while (numOfPlayers < Game.MIN_PLAYERS || numOfPlayers > Game.MAX_PLAYERS);
        clientManager.onUpdatePlayersNumber(numOfPlayers);
    }

    @Override
    public void waitingRoom() {

    }

    @Override
    public void gameRoom() {

    }

    @Override
    public void askColumnAndPositions () {
        int numOfPositions, column, row, col;
        List<Position> positions = new ArrayList<>();

        // Number of positions
        do {
            System.out.print("How many tiles do you want to pick up from the board (min. 1, max. 3)? ");
            numOfPositions = Integer.parseInt(scanner.nextLine());
        } while (numOfPositions < 1 || numOfPositions > 3);

        // Positions
        for (int i = 0; i < numOfPositions; i++) {
            System.out.println("Position n° " + (i + 1));

            // Row
            do {
                System.out.print("Row: ");
                row = Integer.parseInt(scanner.nextLine());
            } while (row < 0 || row >= Board.MAX_ROWS);

            // Column
            do {
                System.out.print("Column: ");
                col = Integer.parseInt(scanner.nextLine());
            } while (col < 0 || col >= Board.MAX_COLUMNS);
            positions.add(new Position(row, col));
        }

        // Column
        do {
            System.out.print("What column in your shelf do you want to insert the " + numOfPositions + " tiles? ");
            column = Integer.parseInt(scanner.nextLine());
        } while (column < 0 || column >= Shelf.COLUMNS);

        clientManager.onUpdateColumnAndPosition(positions, column);
    }

    @Override
    public void showLoginResponse (boolean validNickname, boolean connectionEstablished) {
        if (!connectionEstablished) {
            System.out.println("For some stuff, it's impossible to establish a connection with the server.");
            System.exit(-1);
        } else if (!validNickname) {
            askNickname();
        } else {
            System.out.println("Connection successful.");
        }
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

    @Override
    public void showCommonGoalCard(CommonGoalCard commonGoalCard) {
        List<ScoringToken> tokens = commonGoalCard.getScoringTokens();
        System.out.print("Common Goal description: \"" + commonGoalCard.getDescription() + "\"\n\t[");
        for (ScoringToken token : tokens)
            System.out.print(token.score() + " ");
        System.out.println("]");
    }

    @Override
    public void showPersonalGoalCard(PersonalGoalCard personalGoalCard, String cardOwner) {
        Map<Position, ItemTileType> copySchema = new HashMap<>(personalGoalCard.getSchema());
        System.out.println("Personal goal card of " + cardOwner + ":");

        System.out.print("  | ");
        for (int i = 0; i < Shelf.COLUMNS; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n--------------");
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                if (j == 0)
                    System.out.print(i + " | ");
                Position position = new Position(i, j);
                if (copySchema.containsKey(position)) {
                    switch (copySchema.get(position)) {
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

    @Override
    public void showScoreBoard(Map<String, Integer> scoreBoardMap) {
        int progressivePosition = 1;
        System.out.println("CLASSIFICA FINALE: ");
        for (Map.Entry<String, Integer> entry : scoreBoardMap.entrySet()) {
            System.out.println(progressivePosition + ") " + entry.getKey() + ": " + entry.getValue() + " points");
            progressivePosition++;
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
