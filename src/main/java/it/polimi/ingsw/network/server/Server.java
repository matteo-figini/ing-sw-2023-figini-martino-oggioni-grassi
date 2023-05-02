package it.polimi.ingsw.network.server;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.controller.GameState;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.view.VirtualView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This abstract class represents the implementation of the Server.
 */
public abstract class Server extends Thread{

    /** Instance of the {@code GameController} class. */
    private GameController gameController;

    /** Map containing all the instances of the {@code ClientHandler} by their nickname. */
    private Map<String, ClientHandler> clientHandlerMap;

    /**
     * Creates an instance of the server.
     * @param gameController The instance of {@code GameController}.
     */
    public Server (GameController gameController) {
        this.gameController = gameController;
        clientHandlerMap = new HashMap<>();
    }

    /**
     * This method creates a Client after checking if the nickname is valid or the game is not already started
     * Otherwise in will disconnect the client.
     * @param nickname
     * @param clientHandler
     */
    public void addClient(String nickname, ClientHandler clientHandler ) throws IOException {
        VirtualView vv= new VirtualView(clientHandler);

        if (gameController.getGameState() == GameState.LOBBY_STATE){
            gameController.addVirtualView(nickname, vv);
            gameController.handleLogin(nickname, vv);
            if (gameController.checkNicknameAvailability (nickname, gameController.getPlayers(), vv))
                clientHandlerMap.put(nickname, clientHandler);
        } else {
            //SHOW login result
            clientHandler.disconnect();
        }
    }

    /**
     * This method disconnects a Client (his VirtualView and Clienthandler) from the network.
     * @param nickname
     * @param vv
     */
    public void removeClient(String nickname, VirtualView vv){
        clientHandlerMap.remove(nickname);
        gameController.removeVirtualView(nickname, vv);
        //Notify
    }

    /**
     * Sends a message from the Client to the controller.
     *
     * @param message to be forwarded to the GameController
     */
    public void onMessageReceived(Message message){
        gameController.onMessageReceived(message);
    }

}
