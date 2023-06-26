package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {
    /**
     * This method is used to check that the connection with a client is working.
     */
    void ping() throws RemoteException;

    /**
     * This method returns the amount of time a Client has been connected to the Server.
     * @return the counter of the client's connections.
     * @throws RemoteException Exception raised if a connection error occurs.
     */
    int getCounter() throws RemoteException;

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
