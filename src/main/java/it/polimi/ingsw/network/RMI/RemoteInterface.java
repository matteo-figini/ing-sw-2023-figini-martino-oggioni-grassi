package it.polimi.ingsw.network.RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * This interface defines the methods that will be used by the Client on remote objects.
 */
public interface RemoteInterface extends Remote {

}
