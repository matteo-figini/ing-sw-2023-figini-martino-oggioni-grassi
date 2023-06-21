package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerImpl extends UnicastRemoteObject implements RemoteServer {
    /** Reference to the {@code Server} object. */
    private final Server server;

    public static final int DEFAULT_RMI_PORT = 1099;

    public RemoteServerImpl (Server server) throws RemoteException {
        this.server = server;
        try {
            Registry registry = LocateRegistry.createRegistry(DEFAULT_RMI_PORT);
            registry.bind(Server.SERVER_NAME, this);
            System.out.println("RMI server created on port " + DEFAULT_RMI_PORT + "...");
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("Unable to instantiate RMI server.");
        }
    }

    /**
     * This method is used to add new clients, the Server will establish if it is a new connection or a reconnection.
     * @throws RemoteException if an exception with the Remote object occurs.
     */
    @Override
    public void addClient (String nickname, RemoteClient remoteClient) throws RemoteException {
        RemoteClientHandler clientHandler = new RemoteClientHandler(remoteClient, this);
        this.server.addClient(nickname, clientHandler);
    }

    /**
     * This method sends a message from the Client implementation to the server.
     * @param message the message to be forwarded to the server.
     * @throws RemoteException if an exception occurs.
     */
    @Override
    public void messageToServer (Message message) throws RemoteException {
        System.out.println("Message received: " + message.toString());
        server.onMessageReceived(message);
    }

    /**
     * Handles the disconnection of a client, passing the request to the {@code Server}.
     * @param clientHandler The {@code ClientHandler} disconnected.
     */
    public void onClientDisconnection (ClientHandler clientHandler) {
        server.onClientDisconnection(clientHandler);
    }

}
