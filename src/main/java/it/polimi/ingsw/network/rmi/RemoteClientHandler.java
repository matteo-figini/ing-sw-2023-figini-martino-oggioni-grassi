package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.message.Message;

import java.io.Serializable;
import java.rmi.ConnectException;
import java.rmi.RemoteException;


public class RemoteClientHandler implements ClientHandler {
    /** Reference to the {@code RemoteClient} associated with the {@code RemoteClientHandler}. */
    private final RemoteClient remoteClient;

    /** Reference to the {@code RemoteServer} implementation. */
    private final RemoteServerImpl remoteServer;

    public RemoteClientHandler (RemoteClient clientReference, RemoteServerImpl server) throws RemoteException {
        this.remoteClient = clientReference;
        this.remoteServer = server;
    }

    /**
     * This method sends a message to the client.
     * @param message The message to send to the client.
     */
    @Override
    public void sendMessage(Message message) {
        try {
            remoteClient.messageToClient(message);
            System.out.println("Message sent: " + message.toString());
        } catch (RemoteException e) {
            System.out.println("Unable to communicate with the client.");
            remoteServer.onClientDisconnection(this);
        }
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean isConnected() {
        return true;
    }

}