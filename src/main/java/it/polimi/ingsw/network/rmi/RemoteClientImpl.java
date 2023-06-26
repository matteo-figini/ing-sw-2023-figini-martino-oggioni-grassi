package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;
import it.polimi.ingsw.network.message.PingMessage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class implements the remote interface for the client.
 */
public class RemoteClientImpl extends Client implements RemoteClient, Runnable {
    /** Instance of the connected {@code RemoteServer}. */
    private RemoteServer remoteServer;
    private int lastPingCounter;
    /** Read service. */
    private final ExecutorService readService = Executors.newSingleThreadExecutor();
    /** Ping service. */
    private final ScheduledExecutorService pingSchedule = Executors.newSingleThreadScheduledExecutor();
    /** Standard timeout for RMI connection. */
    public static final int RMI_TIMEOUT = 10000;
    /** Server IP address. */
    private String ipAddress;
    /** Server port. */
    private int port;

    /**
     * @param manager Reference to the {@code ClientManager} of the client.
     * @param ipAddress Server IP address.
     * @param port Server RMI port (default: 1099)
     * @throws RemoteException Exception raised if a connection error occurs.
     */
    public RemoteClientImpl (ClientManager manager, String ipAddress, int port) throws RemoteException {
        setClientManager(manager);
        this.ipAddress = ipAddress;
        this.port = port;
        Registry registry = LocateRegistry.getRegistry(this.ipAddress, this.port);
        try {
            this.remoteServer = (RemoteServer) registry.lookup(Server.SERVER_NAME);
            enablePing();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Deprecated
    public void run() {
        try {
            //...
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to get the reference from the RMI registry so that the method contained in the class RemoteServer
     * can be used by the client.
     * @return the reference to the RemoteServer class
     * @throws Exception Exception raised if a connection error occurs.
     */
    public RemoteServer getReference() throws Exception {
        //Locate the Registry
        Registry registry = LocateRegistry.getRegistry(this.ipAddress, this.port);
        //Get and return the reference of the exported object from RMI registry
        return (RemoteServer) registry.lookup(Server.SERVER_NAME);
    }

    /**
     * This method checks if the ping counter of a Client has been incremented. If it is not updated, it means that the
     * client has been disconnected.
     */
    /*@Deprecated
    public void checkPing() {
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
    }*/

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
        readService.execute(() -> {
            if (message.getMessageType() != MessageType.PING_MESSAGE) {
                clientManager.update(message);
            }
        });
    }

    @Override
    public void readMessage() {

    }

    @Override
    public void disconnect() {
        if (remoteServer != null) {
            System.out.println("Disconnecting from the server. You can close safely the program.");
            remoteServer = null;
            disablePing();
            // System.exit(0);
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
