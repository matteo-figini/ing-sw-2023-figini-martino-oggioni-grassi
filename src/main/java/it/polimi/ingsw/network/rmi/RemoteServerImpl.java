package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;
import jdk.jshell.spi.ExecutionControlProvider;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteServerImpl implements RemoteServer, Runnable {
    private final Server server;

    public RemoteServerImpl(Server server) throws RemoteException {
        this.server = server;
    }

    @Override
    public void run() {
        //Create the RemoteServer object
        RemoteServerImpl remoteServer = null;
        try {
            remoteServer = new RemoteServerImpl(server);
            //Export the object using UnicastRemoteObject class
            RemoteServer stub = (RemoteServer) UnicastRemoteObject.exportObject(remoteServer, 0);
            //Get the registry to register the object
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            registry.bind("server", stub);
        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }

        while (!Thread.currentThread().isInterrupted()){
            //Create and start a specific client handler
            RemoteClientHandler clientHandler = null;
            try {
                clientHandler = new RemoteClientHandler(this);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            Thread thread = new Thread(clientHandler);
            thread.start();
        }

    }


    /**
     * This method is used to add new clients, the Server will establish if it is a new connection or a reconnection.
     * @throws RemoteException if an exception with the Remote object occurs.
     */
    @Override
    public void addClient(String nickname, ClientHandler clientHandler) throws RemoteException {
        server.addClient(nickname, clientHandler);
    }


    /**
     * This method sends a message from the Client implementation to the server.
     * @param message the message to be forwarded to the server.
     * @throws RemoteException if an exception occurs.
     */
    @Override
    public void msgToServer(Message message) throws RemoteException {
        server.onMessageReceived(message);
    }

}
