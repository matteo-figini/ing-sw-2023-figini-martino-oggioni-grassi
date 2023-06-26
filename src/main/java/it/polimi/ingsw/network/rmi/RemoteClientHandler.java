package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.PingMessage;

import java.io.Serializable;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static it.polimi.ingsw.network.rmi.RemoteClientImpl.RMI_TIMEOUT;


public class RemoteClientHandler implements ClientHandler {
    /** Reference to the {@code RemoteClient} associated with the {@code RemoteClientHandler}. */
    private RemoteClient remoteClient;

    /** Reference to the {@code RemoteServer} implementation. */
    private final RemoteServerImpl remoteServer;

    private boolean isConnected;

    private final ScheduledExecutorService pingSchedule = Executors.newSingleThreadScheduledExecutor();

    public RemoteClientHandler (RemoteClient clientReference, RemoteServerImpl server) throws RemoteException {
        this.remoteClient = clientReference;
        this.remoteServer = server;
        this.isConnected = true;
        enablePing();
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
            this.remoteClient = null;
        }
        this.isConnected = false;
        disablePing();
        remoteServer.onClientDisconnection(this);
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }

    public void enablePing() {
        pingSchedule.scheduleAtFixedRate(
                () -> sendMessage(new PingMessage(Server.SERVER_NAME)),
                0,
                RMI_TIMEOUT/2,
                TimeUnit.MILLISECONDS);
    }

    public void disablePing () {
        pingSchedule.shutdownNow();
    }

}