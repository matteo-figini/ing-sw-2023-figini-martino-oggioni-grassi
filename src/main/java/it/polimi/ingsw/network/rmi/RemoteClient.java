package it.polimi.ingsw.network.rmi;
import it.polimi.ingsw.network.message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface defines the methods that will be used by the client to communicate with remote objects.
 */
public interface RemoteClient extends Remote {
    /**
     * This method forwards the message passed as parameter to the {@code ClientManager}.
     * @throws RemoteException Exception raised if a connection error occurs.
     */
    void messageToClient(Message message) throws RemoteException;
}
