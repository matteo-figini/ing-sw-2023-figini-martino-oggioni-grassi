package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {

    /**
     * This method adds a new client connection.
     * @throws RemoteException
     */
    public void addClient() throws RemoteException;

    /**
     * This method receives messages to be sent to the Server.
     * @throws RemoteException
     */
    public void msgToServer(Message message) throws RemoteException;

}
