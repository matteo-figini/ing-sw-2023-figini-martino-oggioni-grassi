package it.polimi.ingsw.network.socket.client;

import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.network.message.ErrorMessage;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.PingMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class extends the {@code Client} class using socket technology.
 */
public class SocketClient extends Client {
    private final Socket socket;        // Client socket
    private final ObjectInputStream inputStream;  // Input stream for socket
    private final ObjectOutputStream outputStream;    // Output stream for socket
    public static final int SOCKET_TIMEOUT = 10000;
    private final ExecutorService readService = Executors.newSingleThreadExecutor();
    private final ScheduledExecutorService pingSchedule = Executors.newSingleThreadScheduledExecutor();

    /**
     * The default constructor sets the connection to the server.
     * @param ipAddress IP address of the server.
     * @param port Port of the server.
     */
    public SocketClient (ClientManager manager, String ipAddress, int port) throws IOException {
        setClientManager(manager);
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress(ipAddress, port), SOCKET_TIMEOUT);
        this.inputStream = new ObjectInputStream(socket.getInputStream());
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        enablePing();
    }

    /**
     * Sends the message specified as parameter to the server. If an {@code IOException} occurs, the client will be
     * disconnected from the server.
     * @param message The message to be sent.
     */
    @Override
    public void sendMessage (Message message) {
        try {
            this.outputStream.writeObject(message);
            this.outputStream.reset();
        } catch (IOException e) {
            this.disconnect();
            clientManager.update(new ErrorMessage(null, "Unable to send the message. Client disconnected."));
        }
    }

    @Override
    public void readMessage() {
        readService.execute(() -> {
            while (!readService.isShutdown()) {
                Message message;
                try {
                    message = (Message) inputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    message = new ErrorMessage(null, "Disconnecting from the server. You can close safely the program.");
                    disconnect();
                    readService.shutdownNow();
                }
                clientManager.update(message);
            }
        });
    }

    /**
     * Disconnect the client from the server.
     */
    @Override
    public void disconnect() {
        try {
            if (!socket.isClosed()) {
                readService.shutdownNow();
                disablePing();
                socket.close();
            }
        } catch (IOException e) {
            clientManager.update(new ErrorMessage(null, "Unable to disconnect from the server."));
        }
    }

    @Override
    public void enablePing () {
        pingSchedule.scheduleAtFixedRate(
                () -> sendMessage(new PingMessage(clientManager.getNickname())),
                0,
                SOCKET_TIMEOUT/2,
                TimeUnit.MILLISECONDS);
    }

    @Override
    public void disablePing () {
        pingSchedule.shutdownNow();
    }
}
