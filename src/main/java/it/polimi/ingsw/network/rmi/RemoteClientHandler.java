package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.PingMessage;

import java.rmi.RemoteException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static it.polimi.ingsw.network.rmi.RemoteClientImpl.RMI_TIMEOUT;

/**
 * This class represents a client handler connected to his specific client with the RMI connection.
 * It implements {@code ClientHandler} interface and manages the messages from server to client.
 */
public class RemoteClientHandler implements ClientHandler {
    /** Reference to the {@code RemoteClient} associated with the {@code RemoteClientHandler}. */
    private RemoteClient remoteClient;

    /** Reference to the {@code RemoteServer} implementation. */
    private final RemoteServerImpl remoteServer;
    /** {@code true} if the client is connected, {@code false} otherwise. */
    private boolean isConnected;
    /** Ping service. */
    private final ScheduledExecutorService pingSchedule = Executors.newSingleThreadScheduledExecutor();

    /**
     * @param clientReference Reference to the {@code RemoteClient}.
     * @param server Reference to the {@code RemoteServerImpl}.
     * @throws RemoteException Exception raised if a connection error occurs.
     */
    public RemoteClientHandler (RemoteClient clientReference, RemoteServerImpl server) throws RemoteException {
        this.remoteClient = clientReference;
        this.remoteServer = server;
        this.isConnected = true;
        enablePing();
    }

    /**
     * Sends a message to the client.
     * @param message The message to send to the client.
     */
    @Override
    public void sendMessage(Message message) {
        try {
            remoteClient.messageToClient(message);
            System.out.println("Message sent: " + message.toString());
        } catch (RemoteException e) {
            System.out.println("Unable to communicate with the client: disconnecting...");
            this.disconnect();
        }
    }

    @Override
    public void disconnect() {
        if (!isConnected()) {
            return;
        }
        if (this.remoteClient != null) {
            this.remoteClient = null;       // Removes the reference to the remote client.
        }
        this.isConnected = false;
        disablePing();
        remoteServer.onClientDisconnection(this);
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }

    /**
     * Enable ping service from the client handler to the client.
     */
    private void enablePing() {
        pingSchedule.scheduleAtFixedRate(
                () -> sendMessage(new PingMessage(Server.SERVER_NAME)),
                0,
                RMI_TIMEOUT/2,
                TimeUnit.MILLISECONDS);
    }

    /**
     * Disable ping service.
     */
    private void disablePing () {
        if (!pingSchedule.isShutdown()) {
            pingSchedule.shutdownNow();
        }
    }
}