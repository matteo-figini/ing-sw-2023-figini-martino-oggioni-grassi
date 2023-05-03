package it.polimi.ingsw.network.server;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.controller.GameState;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.view.VirtualView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This abstract class represents the implementation of the Server.
 * Based on the network technology (socket or RMI), derived class will extend the functionalities.
 */
public class Server {

    /** Instance of the {@code GameController} class. */
    private final GameController gameController;

    /** Map containing all the instances of the {@code ClientHandler} by their nickname. */
    private final Map<String, ClientHandler> clientHandlerMap;

    // private final Object lock;

    /**
     * Creates an instance of the server.
     * @param gameController The instance of {@code GameController}.
     */
    public Server (GameController gameController) {
        this.gameController = gameController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
        // this.lock = new Object();
    }

    /**
     * This method creates a Client after checking if the nickname is valid or the game is not already started
     * Otherwise in will disconnect the client. If the nickname is valid but the game already started, the client
     * handler will be disconnected, else if the game is not started yet but the nickname is not valid, a correct response
     * is submitted to the client.
     * @param nickname The nickname of the new potential client.
     * @param clientHandler The client handler of the specific client.
     */
    public void addClient (String nickname, ClientHandler clientHandler) {
        VirtualView virtualView = new VirtualView(clientHandler);
        if (gameController.getGameState() == GameState.LOBBY_STATE) {
            if (gameController.checkNicknameAvailability(nickname, virtualView)) {
                clientHandlerMap.put(nickname, clientHandler);
                gameController.handleLogin(nickname, virtualView);
            } else {
                virtualView.showLoginResponse(false, true);
            }
        } else {
            if (gameController.isGameSuspended() && gameController.getOfflinePlayers().contains(nickname)) {
                // Il giocatore era precedentemente connesso, poi si è disconnesso e ora si è riconnesso.
                clientHandlerMap.remove(nickname);

                clientHandlerMap.put(nickname, clientHandler);
                System.out.println("Player reconnected: " + nickname);
                gameController.handleLogin(nickname, virtualView);
            } else {
                virtualView.showLoginResponse(true, false);
                // clientHandler.disconnect();
            }
        }
    }

    /**
     * This method disconnects a Client (his VirtualView and Clienthandler) from the network.
     * @param nickname The nickname of the client that will be disconnected.
     * @param virtualView The virtual view of the client that will be disconnected.
     */
    public void removeClient (String nickname, VirtualView virtualView) {
        clientHandlerMap.remove(nickname);
        gameController.removeVirtualView(nickname, virtualView);
        System.out.println("Disconnected client \"" + nickname + "\" from the server.");
    }

    /**
     * Sends a message from the Client to the controller.
     * @param message to be forwarded to the GameController
     */
    public void onMessageReceived (Message message) {
        gameController.onMessageReceived(message);
    }

    public void onClientDisconnection (ClientHandler clientHandler) {
        String nicknameOfDisconnectedClient;
        System.out.println("Client " + clientHandler.toString() + " disconnected.");
        nicknameOfDisconnectedClient = fromClientHandlerToNickname(clientHandler);
        System.out.println("Nickname of the disconnected client: " + nicknameOfDisconnectedClient);
        clientHandlerMap.remove(nicknameOfDisconnectedClient);
        gameController.getVirtualViewMap().remove(nicknameOfDisconnectedClient);
        gameController.setPlayerOffline(nicknameOfDisconnectedClient);
    }

    private String fromClientHandlerToNickname (ClientHandler clientHandler) {
        for (Map.Entry<String, ClientHandler> entry : clientHandlerMap.entrySet()) {
            if (entry.getValue().equals(clientHandler)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
