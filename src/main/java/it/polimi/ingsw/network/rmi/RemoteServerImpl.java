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

public class RemoteServerImpl extends UnicastRemoteObject implements RemoteServer, Runnable {
    private final Server server;
    private boolean isConnected = true;

    public RemoteServerImpl(Server server) throws RemoteException {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            //Locate registry for the client handled and bind the remote reference
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("RMIServer", this);
            //Showing if the server is running
            System.out.println("RMI server running on default port.");
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to start remote server.");
        }

        while (!Thread.currentThread().isInterrupted()){
            //create and start a specific client handler
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

    @Override
    public void sendPing() throws RemoteException {
        //implementa il metodo
    }

    @Override
    public void messageToServer(Message msg) throws RemoteException {
        //implementa il metodo
    }

    @Override
    public void addClient() throws RemoteException {
        //implementa il metodo
    }


    /**
     * Handles the disconnection of a client, passing the request to the {@code Server}.
     * @param clientHandler The {@code ClientHandler} disconnected.
     */
    public void onClientDisconnection (ClientHandler clientHandler) {
        server.onClientDisconnection(clientHandler);//metodo che verrà chiamato da RemoteClientHandler
    }

    /**
     * Handles the addition of a new client, passing the request to the {@code Server}.
     * @param nickname The nickname of the client.
     * @param clientHandler The {@code ClientHandler} of the new client.
     */
    public void addClient (String nickname, ClientHandler clientHandler) {
        server.addClient(nickname, clientHandler);//metodo che verrà chiamato da RemoteClientHandler
    }

    /**
     * Handles the receiving of a message, passing the request to the {@code Server}.
     * @param message The message received.
     */
    public void onMessageReceived(Message message) {
        server.onMessageReceived(message); //metodo che verrà chiamato da RemoteClientHandler
    }
}
