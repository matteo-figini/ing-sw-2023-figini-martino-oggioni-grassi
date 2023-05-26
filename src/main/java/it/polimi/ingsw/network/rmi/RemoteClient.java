package it.polimi.ingsw.network.rmi;
import it.polimi.ingsw.network.message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface defines the methods that will be used by the Client on remote objects.
 */
public interface RemoteClient extends Remote {

    /**
     * This method receives messages from the Server and forwards them to the ClientManager
     * @throws RemoteException
     */
    public void msgToClient(Message message) throws RemoteException;

}
