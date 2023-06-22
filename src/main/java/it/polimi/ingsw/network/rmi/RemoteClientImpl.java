package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.LoginRequestMessage;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;
import it.polimi.ingsw.network.message.PingMessage;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class implements the remote interface for the client.
 */
public class RemoteClientImpl extends Client implements RemoteClient, Runnable {

    private RemoteServer remoteServer;
    private int lastPingCounter;

    private final ScheduledExecutorService pingSchedule = Executors.newSingleThreadScheduledExecutor();

    public static final int RMI_TIMEOUT = 20000;

    public RemoteClientImpl (ClientManager manager, String ipAddress, int port) throws RemoteException {
        setClientManager(manager);
        Registry registry = LocateRegistry.getRegistry(ipAddress, port);
        try {
            this.remoteServer = (RemoteServer) registry.lookup(Server.SERVER_NAME);
            enablePing();
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
     *This method checks if the ping counter of a Client has been incremented. If it is not updated, it means that the client
     * has been disconnected.
     */
    public void checkPing(){
        try {
            remoteServer = this.getReference();
            remoteServer.ping();
            System.out.println("Ping sent to Server. Counter: " + lastPingCounter);

            if (lastPingCounter == remoteServer.getCounter()){
                System.out.println("Connection lost.");
            } else {
                lastPingCounter = remoteServer.getCounter();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
                remoteServer.addClient(message.getNickname(), this);
            } else {
                remoteServer.messageToServer(message);
            }
        } catch (RemoteException e) {
            disconnect();
        }
    }

    @Override
    public void messageToClient(Message message) throws RemoteException {
        if (message.getMessageType() != MessageType.PING_MESSAGE) {
            clientManager.update(message);
        }
    }

    @Override
    public void readMessage() {

    }

    @Override
    public void disconnect() {
        if (remoteServer != null) {
            System.out.println("Disconnecting from the server due to an internal server error.");
            remoteServer = null;
            disablePing();
            System.exit(0);
        }
    }

    @Override
    public void enablePing() {
        pingSchedule.scheduleAtFixedRate(
                () -> sendMessage(new PingMessage(clientManager.getNickname())),
                0,
                RMI_TIMEOUT/2,
                TimeUnit.MILLISECONDS);
    }

    @Override
    public void disablePing() {
        pingSchedule.shutdownNow();
    }
}
