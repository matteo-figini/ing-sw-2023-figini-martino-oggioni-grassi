package it.polimi.ingsw.network.client;

import it.polimi.ingsw.network.message.ErrorMessage;
import it.polimi.ingsw.network.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * This class extends the {@code Client} class using socket technology.
 */
public class SocketClient extends Client {
    private final Socket socket;        // Client socket
    private final ObjectInputStream objectInputStream;  // Input stream for socket
    private final ObjectOutputStream objectOutputStream;    // Output stream for socket
    private final int SOCKET_TIMEOUT = 20000;

    /**
     * Default constructor sets the connection to the server.
     * @param ipAddress IP address of the server.
     * @param port Port of the server.
     */
    public SocketClient (String ipAddress, int port) throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress(ipAddress, port), SOCKET_TIMEOUT);
        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        // TODO: cosa fare per abilitare il ping?
    }

    /**
     * Sends the message specified as parameter to the server. If an {@code IOException} occurs, the client will be
     * disconnected from the server.
     * @param message The message to be sent.
     */
    @Override
    public void sendMessage (Message message) {
        try {
            this.objectOutputStream.writeObject(message);
            this.objectOutputStream.reset();
        } catch (IOException e) {
            this.disconnect();
            notifyObservers(new ErrorMessage(null, "Unable to send the message. Client disconnected."));
        }
    }

    @Override
    public void readMessage() {
        // TODO: implementare il metodo
    }

    /**
     * Disconnect the client from the server.
     */
    @Override
    public void disconnect() {
        try {
            if (!socket.isClosed()) {
                // TODO: Si dovrebbe terminare il thread di readMessage e disabilitare il pinging
                socket.close();
            }
        } catch (IOException e) {
            notifyObservers(new ErrorMessage(null, "Unable to disconnect from the server."));
        }
    }

    @Override
    public void enablePinger (boolean pingEnabled) {
        // TODO: implementare il metodo
    }


}
