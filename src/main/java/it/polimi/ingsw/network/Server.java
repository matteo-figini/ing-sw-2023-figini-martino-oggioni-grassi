package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.controller.GameState;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.view.VirtualView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the implementation of the Server.
 * Based on the network technology (socket or RMI), a class will extend the functionalities.
 */
public class Server {
    /** Instance of the {@code GameController} class. */
    private final GameController gameController;

    /** Map containing all the instances of the {@code ClientHandler} by their nickname. */
    private final Map<String, ClientHandler> clientHandlerMap;

    /** Server name. */
    public static final String SERVER_NAME = "MyShelfieServer";

    private final Object lockObject = new Object();

    /**
     * Creates an instance of the server.
     * @param gameController The instance of {@code GameController}.
     */
    public Server (GameController gameController) {
        this.gameController = gameController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
    }

    /**
     * Add a new client with the nickname specified as parameter and the {@code ClientHandler} created by the
     * {@code ClientHandler} class. Based on the current state of the {@code GameController}, the connection can
     * be a new client connection or a client reconnection.
     * @param nickname The nickname of the client.
     * @param clientHandler {@code ClientHandler} of the client.
     */
    public void addClient (String nickname, ClientHandler clientHandler) {
        VirtualView virtualView = new VirtualView(clientHandler);
        if (gameController.getGameState() == GameState.LOBBY_STATE) {
            addNewClientConnection(nickname, clientHandler, virtualView);
        } else {
            addClientReconnection(nickname, clientHandler, virtualView);
        }
    }

    /**
     * Add a new client connection to the server. Requires that the {@code GameController} class is in {@code LOBBY_STATE} state.
     * If exists a player with the same nickname, inform the client and ask for a new nickname.
     * Otherwise, associate the {@code ClientHandler} of the client with his nickname and pass the control to
     * {@code GameController}.
     * @param nickname String containing the nickname of the new client.
     * @param clientHandler {@code ClientHandler} of the new client.
     * @param virtualView {@code VirtualView} of the new client.
     */
    private void addNewClientConnection (String nickname, ClientHandler clientHandler, VirtualView virtualView) {
        if (gameController.checkNicknameAvailability(nickname, virtualView)) {
            // Il giocatore si sta aggiungendo alla partita in fase di lobby con un nickname valido.
            clientHandlerMap.put(nickname, clientHandler);
            virtualView.showLoginResponse(true, true);
            gameController.handleLogin(nickname, virtualView);
        } else {
            // Player is trying to get into the game with an invalid nickname.
            // Inform the player that the nickname is invalid.
            virtualView.showLoginResponse(false, true);
        }
    }

    /**
     * Add a new client connection to the server. Requires that the {@code GameController} class is in {@code IN_GAME} state
     * or in {@code LAST_LAP} state.
     * The reconnection is accepted only if it exists a player with the same nickname in the list of the players and
     * that player is currently marked as offline: in this case, associate the nickname of the client with his
     * {@code ClientHandler} and pass the control to the controller. Otherwise, if this condition is not met, inform
     * the client that the connection cannot be accepted and disconnect the client.
     * @param nickname String containing the nickname of the new client.
     * @param clientHandler {@code ClientHandler} of the new client.
     * @param virtualView {@code VirtualView} of the new client.
     */
    private void addClientReconnection (String nickname, ClientHandler clientHandler, VirtualView virtualView) {
        if (gameController.getOfflinePlayers().contains(nickname)) {
            // Il giocatore sta cercando di accedere nuovamente alla partita in seguito a disconnessione.
            clientHandlerMap.put(nickname, clientHandler);          // Store the client handler of the client.
            System.out.println("Player reconnected: " + nickname);
            gameController.handleReconnection(nickname, virtualView);
        } else {
            // Il giocatore sta cercando di accedere al gioco a partita in corso non per riconnessione.
            // Segnala che l'accesso non è valido e disconnetti il client.
            virtualView.showLoginResponse(true, false);
            clientHandler.disconnect();
        }
    }

    /**
     * Sends a message to the controller.
     * @param message to be forwarded to the {@code GameController}.
     */
    public void onMessageReceived (Message message) {
        gameController.onMessageReceived(message);
    }

    /**
     * Handles the disconnection of the client, removing his references from the {@code ClientHandler} map and the
     * {@code VirtualView} map. Based on the current status of the game, if it is set to {@code LOBBY_STATE} the client
     * will be removed also from the player list, otherwise his status change to "offline".
     * @param clientHandler The {@code ClientHandler} of the disconnected client.
     */
    public void onClientDisconnection (ClientHandler clientHandler) {
        String nicknameOfDisconnectedClient = fromClientHandlerToNickname(clientHandler);
        if (nicknameOfDisconnectedClient != null) {
            clientHandlerMap.remove(nicknameOfDisconnectedClient);
            gameController.removeVirtualView(nicknameOfDisconnectedClient, gameController.getVirtualViewMap().get(nicknameOfDisconnectedClient));
            gameController.broadcastMessage("Player " + nicknameOfDisconnectedClient + " is disconnected.");
            System.out.println("Client with name " + nicknameOfDisconnectedClient + " is disconnected.");
            if (gameController.getGameState() == GameState.LOBBY_STATE) {
                // Remove the player from the players' list.
                gameController.removePlayer(nicknameOfDisconnectedClient);
            } else {
                // Set the status of the player to offline.
                gameController.setPlayerOffline(nicknameOfDisconnectedClient);
            }
            // System.out.println(clientHandlerMap);
            if (clientHandlerMap.isEmpty()) {
                System.out.println("There aren't players connected: game finishes!");
                System.exit(0);
            }
        } else {
            System.out.println("Cannot find a player from the specified client handler: " + clientHandler.toString());
        }
    }

    /**
     * Return the nickname of the client associated with the {@code ClientHandler} specified as parameter.
     * @param clientHandler {@code ClientHandler} of the client.
     * @return The nickname of the client associated with the {@code clientHandler}.
     */
    private String fromClientHandlerToNickname (ClientHandler clientHandler) {
        for (Map.Entry<String, ClientHandler> entry : clientHandlerMap.entrySet()) {
            if (entry.getValue().equals(clientHandler)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
