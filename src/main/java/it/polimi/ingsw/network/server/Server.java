package it.polimi.ingsw.network.server;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.controller.GameState;
import it.polimi.ingsw.network.client.ClientHandler;
import it.polimi.ingsw.view.VirtualView;

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

    public void addClient(String nickname, ClientHandler clientHandler ){
        VirtualView vv= new VirtualView();

        if (gameController.getGameState() == GameState.LOBBY_STATE){
            gameController.addVirtualView(nickname, vv);
            gameController.handleLogin(nickname, vv);
            //TODO: chiarire come viene fatto il controllo del corretto nickname (in modo da mettere una condizione
            //prima di inserire il nuovo client
            clientHandlerMap.put(nickname, clientHandler);
        } else {
            //SHOW login result
            clientHandler.disconnect();

        }
    }

    public void removeClient(String nickname){

    }

    //TODO mancano tutti i metodi relativi alla gestione di messaggi

}
