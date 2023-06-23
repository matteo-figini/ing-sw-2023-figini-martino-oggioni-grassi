package it.polimi.ingsw.view.tui;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.view.View;

import java.util.*;

public class TUI implements View {
    /** The {@code ClientManager} associated to the client. */
    private ClientManager clientManager;

    /** Class for reading inputs from the terminal. */
    private final Scanner scanner;

    public TUI () {
        scanner = new Scanner(System.in);
    }

    /**
     * Starts the view for the CLI interface.
     */
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
        boolean validInput = false, rmiConnection = false;

        // Choose the connection type between Socket or RMI
        do {
            System.out.println("Please select the preferred connection type: ");
            System.out.println("1) Socket connection (default)");
            System.out.println("2) RMI connection");
            int choose;
            try {
                input = scanner.nextLine();
                if (input.equals(""))
                    choose = 1;
                else
                    choose = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choose = 1;
            }
            switch (choose) {
                case 1 -> {
                    rmiConnection = false;
                    validInput = true;
                    System.out.println("You selected socket connection.");
                }
                case 2 -> {
                    rmiConnection = true;
                    validInput = true;
                    System.out.println("You selected RMI connection.");
                }
                default -> {
                    System.out.println("Incorrect choose.");
                    validInput = false;
                }
            }
        } while (!validInput);

        if (rmiConnection)
            defaultPort = 1099;

        // Insert and verify the IP address and the port
        validInput = false;
        do {
            System.out.print("Please insert the IP address of the server (default: " + defaultIpAddress + "): ");
            ipAddress = scanner.nextLine();
            if (ipAddress.equalsIgnoreCase(""))
                ipAddress = defaultIpAddress;
            System.out.print("Please insert the port of the server (default: " + defaultPort + "): ");
            try {
                input = scanner.nextLine();
                if (input.equals(""))
                    port = defaultPort;
                else
                    port = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                port = defaultPort;
            }

            if (ClientManager.isValidIPAddress(ipAddress) && ClientManager.isValidPort(port))
                validInput = true;
        } while (!validInput);

        clientManager.onUpdateServerInformation(ipAddress, port, rmiConnection);
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
            numOfPlayers = readIntegerNumber();
        } while (numOfPlayers < Game.MIN_PLAYERS || numOfPlayers > Game.MAX_PLAYERS);
        clientManager.onUpdatePlayersNumber(numOfPlayers);
    }

    @Override
    public void switchToWaitingRoom() {
        System.out.println("Waiting for other players...");
    }

    @Override
    public void switchToGameRoom() {
        System.out.println("Game started!");
    }

    @Override
    public void askColumnAndPositions () {
        int numOfPositions, column, row, col;
        List<Position> positions = new ArrayList<>();

        // Number of positions
        do {
            System.out.print("How many tiles do you want to pick up from the board (min. 1, max. 3)? ");
            numOfPositions = readIntegerNumber();
        } while (numOfPositions < 1 || numOfPositions > 3);

        // Positions
        for (int i = 0; i < numOfPositions; i++) {
            System.out.println("Position n° " + (i + 1));

            // Row
            do {
                System.out.print("Row: ");
                row = readIntegerNumber();
            } while (row < 0 || row >= Board.MAX_ROWS);

            // Column
            do {
                System.out.print("Column: ");
                col = readIntegerNumber();
            } while (col < 0 || col >= Board.MAX_COLUMNS);
            positions.add(new Position(row, col));
        }

        // Column
        do {
            System.out.print("What column in your shelf do you want to insert the " + numOfPositions + " tiles? ");
            column = readIntegerNumber();
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
    public void showPlayersList(List<String> players) {
        System.out.println("Player's list: ");
        for (String nickname : players) {
            System.out.println(nickname);
        }
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
    public void showPlayerInformation(String player, ShelfCell[][] shelfContent, ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken) {
        System.out.println("Shelf of " + player + ":");
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
        showTokensInformation(firstCommonGoal, secondCommonGoal, hasEndGameToken);
    }

    protected void showTokensInformation(ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken) {
        System.out.print("Points from scoring token obtained: ");
        if (firstCommonGoal != null)
            System.out.print(firstCommonGoal.score() + " ");
        if (secondCommonGoal != null)
            System.out.print(secondCommonGoal.score() + " ");
        System.out.println();
        System.out.print("The player " );
        if (hasEndGameToken)
            System.out.print("has ");
        else
            System.out.print("doesn't have ");
        System.out.println("the end game token.");
    }

    @Override
    public void showCommonGoalCard(CommonGoalCard commonGoalCard, Integer progressiveCard) {
        List<ScoringToken> tokens = commonGoalCard.getScoringTokens();
        System.out.print(progressiveCard + ") Common Goal description: \"" + commonGoalCard.getDescription() + "\"\n\t[");
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

    private int readIntegerNumber () {
        int number = 0;
        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ignored) {
            number = 0;
        }
        return number;
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
