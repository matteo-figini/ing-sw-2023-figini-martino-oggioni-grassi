package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.message.Message;

import java.io.Serializable;
import java.rmi.RemoteException;


public class RemoteClientHandler implements ClientHandler, Runnable, Serializable {

    private RemoteClient remoteClient;

    public RemoteClientHandler (RemoteServerImpl server) throws RemoteException {
        super();
    }

    @Override
    public void run() {
        System.out.println("Established new client connection.");
                    //TODO: qua dentro chiama il metodo sendMessage per inoltrare il messaggio al client
    }

    /**
     * This method sends a message to the client.
     * @param message The message to send to the client.
     */
    @Override
    public void sendMessage(Message message) {
        /*try {
            remoteClient.messageToClient(message);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean isConnected() {
        return false;
    }

}