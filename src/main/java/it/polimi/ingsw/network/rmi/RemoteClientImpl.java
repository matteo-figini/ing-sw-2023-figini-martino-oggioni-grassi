package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This class implements the remote interface for the client.
 */
public class RemoteClientImpl extends Client implements RemoteClient, Runnable {

    public RemoteClientImpl(ClientManager manager) throws RemoteException {
        setClientManager(manager);
    }


    @Override
    public void run() {
        try {
            //...
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to get the reference from the RMI registry so that the method contained in the class RemoteServer can be used by the client.
     *
     * @return the reference to the RemoteServer class
     * @throws Exception if a remote exception occurs
     */
    public RemoteServer getReference() throws Exception {
        //Locate the Registry
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        //Get and return the reference of the exported object from RMI registry
        return (RemoteServer) registry.lookup(Server.SERVER_NAME);
    }

    /**
     * This method gets a reference to the Remote server so that the Client can use the methods contained in the
     * RemoteServer interface.
     * @param message The message to be sent.
     */
    @Override
    public void sendMessage(Message message) {
        try {
            RemoteServer server = getReference();
            server.messageToServer(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void connectClient (String nickname, ClientHandler clientHandler) throws RemoteException{
        try {
            RemoteServer server = getReference();
            server.addClient(nickname, clientHandler);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void msgToClient(Message message) throws RemoteException {
        clientManager.update(message);
    }

    @Override
    public void readMessage() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void enablePing() {

    }

    @Override
    public void disablePing() {

    }

}
