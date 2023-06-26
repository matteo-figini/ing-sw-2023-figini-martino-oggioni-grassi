package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface represents a remote server and contains method used by the clients connected.
 */
public interface RemoteServer extends Remote {
    /**
     * This method adds a new client connection.
     * @throws RemoteException Exception raised if a connection error occurs.
     */
    void addClient (String nickname, RemoteClient remoteClient) throws RemoteException;

    /**
     * This method receives messages to be sent to the Server.
     * @throws RemoteException Exception raised if a connection error occurs.
     */
    void messageToServer(Message message) throws RemoteException;

}
