package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerImpl extends UnicastRemoteObject/*implements Runnable*/{
    private final Server server;
    private boolean isConnected = true;

    public RemoteServerImpl (Server server) throws RemoteException {
        super();
        this.server = server;
    }

    //this will be the 'run' method once the multithreading will be implemented
    public void startServerConnection(){
        try {
            //create the Client Handler
            RemoteClientHandler clientHandler = new RemoteClientHandler(this);
            //Locate registry for the client handled and bind the remote reference
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("RMIServer", clientHandler);
            //Showing if the server is running
            System.out.println("RMI server running");
            //Starting the thread related to the client handler
            //Thread = new Thread(clientHandler);
            //thread.start();
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
