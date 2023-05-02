package it.polimi.ingsw.network.client;

import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.observer.Observable;

/**
 * This abstract class represents a general client. It will be extended by subclasses, depending on the technology
 * chosen for networking (e.g. Socket or RMI).
 */
public abstract class Client {
    protected ClientManager clientManager;

    /**
     * This method sends a message to the server.
     * @param message The message to be sent.
     */
    public abstract void sendMessage (Message message);

    /**
     * This method reads a message from the server.
     */
    public abstract void readMessage ();

    /**
     * This method disconnects the client from the server.
     */
    public abstract void disconnect ();

    /**
     * Enable a heartbeat (ping messages) to keep the connection alive.
     */
    public abstract void enablePing ();

    public abstract void disablePing ();

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
