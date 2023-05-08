package it.polimi.ingsw.network.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface defines the methods that will be used by the Client on remote objects.
 */
public interface RemoteClient extends Remote {

    public void connect() throws RemoteException;
}
