package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.LoginRequestMessage;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This class implements the remote interface for the client.
 */
public class RemoteClientImpl extends Client implements RemoteClient, Runnable {

    private RemoteServer remoteServer;

    public RemoteClientImpl (ClientManager manager, String ipAddress, int port) throws RemoteException {
        setClientManager(manager);
        Registry registry = LocateRegistry.getRegistry(ipAddress, port);
        try {
            this.remoteServer = (RemoteServer) registry.lookup(Server.SERVER_NAME);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
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
            if (message.getMessageType() == MessageType.LOGIN_REQUEST) {
                this.remoteServer.addClient(message.getNickname(), this);
            } else {
                this.remoteServer.messageToServer(message);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void messageToClient(Message message) throws RemoteException {
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
