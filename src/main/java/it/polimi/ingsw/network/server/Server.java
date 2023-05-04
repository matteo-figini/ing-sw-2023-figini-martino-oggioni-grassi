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
 * This class represents the implementation of the Server.
 * Based on the network technology (socket or RMI), a class will extend the functionalities.
 */
public class Server {

    /** Instance of the {@code GameController} class. */
    private final GameController gameController;

    /** Map containing all the instances of the {@code ClientHandler} by their nickname. */
    private final Map<String, ClientHandler> clientHandlerMap;

    /**
     * Creates an instance of the server.
     * @param gameController The instance of {@code GameController}.
     */
    public Server (GameController gameController) {
        this.gameController = gameController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
    }

    // TODO: riscrivere la Javadoc per questo metodo!
    public void addClient (String nickname, ClientHandler clientHandler) {
        VirtualView virtualView = new VirtualView(clientHandler);
        synchronized (this) {
            if (gameController.getGameState() == GameState.LOBBY_STATE) {
                if (gameController.checkNicknameAvailability(nickname, virtualView)) {
                    // Il giocatore si sta aggiungendo alla partita in fase di lobby con un nickname valido.
                    clientHandlerMap.put(nickname, clientHandler);
                    gameController.handleLogin(nickname, virtualView);
                } else {
                    // Il giocatore si sta aggiungendo alla partita in fase di lobby con un nickname non valido.
                    // Informa il giocatore che il nickname non è valido e chiedi di reinserirlo.
                    virtualView.showLoginResponse(false, true);
                    // TODO: implementare questa situazione
                }
            } else {
                if (gameController.getOfflinePlayers().contains(nickname)) {
                    // Il giocatore sta cercando di accedere nuovamente alla partita in seguito a disconnessione.
                    clientHandlerMap.remove(nickname);
                    clientHandlerMap.put(nickname, clientHandler);
                    System.out.println("Player reconnected: " + nickname);
                    gameController.handleLogin(nickname, virtualView);
                } else {
                    // Il giocatore sta cercando di accedere al gioco a partita in corso e non per riconnessione.
                    // Segnala che l'accesso non è valido e disconnetti il client.
                    virtualView.showLoginResponse(true, false);
                    clientHandler.disconnect();
                    // TODO: implementare la disconnessione del client.
                }
            }
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
     *
     * @param clientHandler
     */
    public void onClientDisconnection (ClientHandler clientHandler) {
        String nicknameOfDisconnectedClient = fromClientHandlerToNickname(clientHandler);
        if (nicknameOfDisconnectedClient != null) {
            clientHandlerMap.remove(nicknameOfDisconnectedClient);
            gameController.removeVirtualView(nicknameOfDisconnectedClient, gameController.getVirtualViewMap().get(nicknameOfDisconnectedClient));
            gameController.broadcastGenericMessage("Player " + nicknameOfDisconnectedClient + " is disconnected.");
            System.out.println("Client " + clientHandler.toString() + " with name " + nicknameOfDisconnectedClient + " is disconnected.");
            gameController.setPlayerOffline(nicknameOfDisconnectedClient);
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
