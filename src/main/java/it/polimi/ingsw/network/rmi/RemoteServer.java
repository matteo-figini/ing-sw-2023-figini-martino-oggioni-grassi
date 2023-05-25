package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.message.Message;

import java.rmi.RemoteException;

public interface RemoteServer{

    /**
     * This method adds a new client connection.
     * @throws RemoteException
     */
    public void addClient() throws RemoteException;

    /**
     * This method receives messages to be sent to the Server.
     * @throws RemoteException
     */
    public void msgToServer() throws RemoteException;

}
