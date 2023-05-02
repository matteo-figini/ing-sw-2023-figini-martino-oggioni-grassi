package it.polimi.ingsw.network.server;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.controller.GameState;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.view.VirtualView;

import java.io.IOException;
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

    private final Object lock;

    /**
     * Creates an instance of the server.
     * @param gameController The instance of {@code GameController}.
     */
    public Server (GameController gameController) {
        this.gameController = gameController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
        this.lock = new Object();
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
            virtualView.showLoginResponse(true, false);
            // clientHandler.disconnect();
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

    /**
     * This method communicates with the Game Controller when a disconnection occurs.
     * @param clientHandler
     */
    public void manageDisconnection (ClientHandler clientHandler) {
        // TODO: implementare la disconnessione di un client
        // Siccome per ora non stiamo implementando la resilienza alle disconnessioni, è sufficiente che una volta che un client
        // si disconnette, la partita termina per tutti i client.
        /*removeClient(getNickname(), getVVbyNickname());
        if (gameController.getGameState() != GameState.LOBBY_STATE){
            clientHandlerMap.clear();
            gameController.getVirtualView().remove(getNickname());
            gameController.getPlayers().remove(getNickname());
        }*/
    }

}
