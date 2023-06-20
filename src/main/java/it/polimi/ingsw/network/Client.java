package it.polimi.ingsw.network;

import it.polimi.ingsw.network.message.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This abstract class represents a general client. It will be extended by subclasses, depending on the technology
 * chosen for networking (e.g. Socket or RMI).
 */
public abstract class Client extends UnicastRemoteObject {

    /** The {@code ClientManager} associated to the client. */
    protected ClientManager clientManager;

    /**
     * Default constructor used to launch {@code RemoteException} in case of an RMI error.
     * @throws RemoteException Exception thrown in case of an exception with RMI connection.
     */
    protected Client() throws RemoteException {}

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
