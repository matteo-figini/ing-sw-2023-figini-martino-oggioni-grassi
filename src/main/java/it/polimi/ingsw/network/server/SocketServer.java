package it.polimi.ingsw.network.server;

import it.polimi.ingsw.controller.GameController;

/**
 * This class extends the Server class by Socket network technology.
 */
public class SocketServer extends Server {

    public SocketServer () {
        // TODO: costruttore da sistemare! Per ora è stato messo così solo per evitare che mostri errore.
        super(new GameController());
    }
}
