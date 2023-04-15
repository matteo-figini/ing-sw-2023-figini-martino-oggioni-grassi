package it.polimi.ingsw.network.server;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.network.client.ClientHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * This abstract class represents the implementation of the Server.
 */
// TODO: capire se è necessario tenere la classe astratta oppure no
public abstract class Server {

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



}
