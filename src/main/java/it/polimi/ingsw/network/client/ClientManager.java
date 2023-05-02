package it.polimi.ingsw.network.client;

import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.Position;
import it.polimi.ingsw.network.message.*;
import it.polimi.ingsw.view.View;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientManager {
    private View view;
    private Client client;
    private String nickname;

    /**
     * Constructs client manager.
     * @param view The view of the client.
     */
    public ClientManager (View view) {
        this.view = view;
    }

    /* ---------- FROM CLIENT TO SERVER ---------- */
    /**
     * Creates a (socket) connection to the server with the IP address and the port specified.
     * If the connection is successful, nickname will be asked; otherwise, a bad login result is shown.
     * @param ipAddress The server IP address.
     * @param port The server port.
     */
    public void onUpdateServerInformation (String ipAddress, int port) {
        try {
            this.client = new SocketClient(this, ipAddress, port);
            client.readMessage();
            view.askNickname();
        } catch (IOException e) {
            view.showGenericMessage("Unable to connect.");
        }
    }

    /**
     * Send a message to the server containing the nickname of the client.
     * The nickname is also stored to create the messages for the server.
     * @param nickname The nickname of the client.
     */
    public void onUpdateNickname (String nickname) {
        this.nickname = nickname;
        client.sendMessage(new LoginRequest(this.nickname));
    }

    /**
     * Send a message to the server containing the number of the players.
     * @param playersNumber The number of the players in the game.
     */
    public void onUpdatePlayersNumber (int playersNumber) {
        client.sendMessage(new PlayersNumberReply(this.nickname, playersNumber));
    }

    /**
     * Send a message to the server containing a list of positions on the board and the column in the shelf.
     * @param positions Positions on the board.
     * @param column The column in the shelf.
     */
    public void onUpdateColumnAndPosition (List<Position> positions, int column) {
        client.sendMessage(new PickTiles(this.nickname, positions, column));
    }

    /**
     * Disconnect the client.
     * // TODO: è davvero necessario questo metodo? Forse sì, forse no, forse boh...
     */
    public void onDisconnection () {
        client.disconnect();
    }

    /* ---------- FROM SERVER TO CLIENT ---------- */
    // Un unico metodo che, in base al tipo di messaggio ricevuto, invoca un metodo specifico sulla view.
    /**
     * Receives a message from the server and, based on the message type, require a specific action to the client view.
     * @param message The message received from the server.
     */
    public void update (Message message) {
        switch (message.getMessageType()) {
            // ...
            case BOARD_CONTENT -> {
                BoardContent boardMessage = (BoardContent) message;
                view.showBoardContent(boardMessage.getBoardContent());
            }
            case SHELF_CONTENT -> {
                ShelfContent shelfMessage = (ShelfContent) message;
                view.showShelfContent(shelfMessage.getShelfContent(), shelfMessage.getPlayer());
            }
            case GENERIC_MESSAGE -> {
                GenericMessage genericMessage = (GenericMessage) message;
                view.showGenericMessage(genericMessage.getGenericMessage());
            }
            // ...
        }
    }


    /* ---------- UTILITY METHODS ---------- */
    /**
     * This method returns true if the IP address specified as parameter is a valid IP address, otherwise it returns false.
     * @param ipAddress The IP address required to be checked.
     * @return {@code true} if the IP address is valid, {@code false} otherwise.
     */
    public static boolean isValidIPAddress (String ipAddress) {
        if (ipAddress == null)
            return false;

        final String IPV4_REGEX_VALIDATOR = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX_VALIDATOR);
        final Matcher matcher = IPV4_PATTERN.matcher(ipAddress);
        return matcher.matches();
    }

    /**
     * This method returns true if the port specified as parameter is a valid port, otherwise it returns false.
     * Port must be included in the range [1024, 65536) to be valid.
     * @param port The port required to be checked.
     * @return {@code true} if the port is valid, {@code false} otherwise.
     */
    public static boolean isValidPort (int port) {
        return (port >= 1024 && port < 65536);
    }
}
