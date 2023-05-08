package it.polimi.ingsw.network;

import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.network.message.Message;

/**
 * This abstract class represents a general client. It will be extended by subclasses, depending on the technology
 * chosen for networking (e.g. Socket or RMI).
 */
public abstract class Client { //extends UnicastRemoteObject (da importare) implements RemoteClient (quando avrò definito tutti i metodi RMI lato Client)

    /** The {@code ClientManager} associated to the client. */
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
     * Enable a ping messages to keep the connection alive.
     */
    public abstract void enablePing ();

    /**
     * Disable the ping message when the connection is not required.
     */
    public abstract void disablePing ();

    /**
     * Return the client manager associated with the client.
     * @return The client manager associated with the client.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Set the client manager to the parameter.
     * @param clientManager The client manager of the client.
     */
    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
