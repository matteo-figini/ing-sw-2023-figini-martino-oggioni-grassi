package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.message.Message;

import java.io.Serializable;
import java.rmi.RemoteException;


public class RemoteClientHandler implements ClientHandler {

    /** Reference to the {@code RemoteClient} associated with the {@code RemoteClientHandler}. */
    private RemoteClient remoteClient;

    public RemoteClientHandler (RemoteClient clientReference) throws RemoteException {
        this.remoteClient = clientReference;
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
            e.printStackTrace();
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