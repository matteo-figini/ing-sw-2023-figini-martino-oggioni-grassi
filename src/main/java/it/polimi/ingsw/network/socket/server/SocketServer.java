package it.polimi.ingsw.network.socket.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.socket.client.SocketClient;

/**
 * This class extends the Server class by Socket network technology.
 */
public class SocketServer implements Runnable {
    /** Server port. */
    private final int port;

    /** Default socket server port. */
    public static final int SOCKET_SERVER_PORT = 5000;

    /** Instance of the {@code Server} class. */
    private final Server server;

    /** Instance of the {@code ServerSocket} listening for new client connections. */
    private ServerSocket serverSocket;

    /**
     * Creates a server-side socket on a given port.
     */
    public SocketServer (Server server, int port) {
        this.server = server;
        this.port = port;
    }

    /**
     * Creates a thread that constantly listens to on the {@code ServerSocket}.
     * When a new client asks for the connection, a new {@code SocketClientHandler} is created.
     */
    @Override
    public void run () {
        try {
            this.serverSocket = new ServerSocket(this.port);
            System.out.println("Socket server running on port " + this.port);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to start socket server.");
        }

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket clientSocket = serverSocket.accept();    // Wait for a new connection and receives the socket Object
                System.out.println("New connection request from: " + clientSocket.getInetAddress());
                clientSocket.setSoTimeout(SocketClient.SOCKET_TIMEOUT);
                // Create and start the specific client handler.
                SocketClientHandler clientHandler = new SocketClientHandler(this, clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Handles the disconnection of a client, passing the request to the {@code Server}.
     * @param clientHandler The {@code ClientHandler} disconnected.
     */
    public void onClientDisconnection (ClientHandler clientHandler) {
        server.onClientDisconnection(clientHandler);
    }

    /**
     * Handles the addition of a new client, passing the request to the {@code Server}.
     * @param nickname The nickname of the client.
     * @param clientHandler The {@code ClientHandler} of the new client.
     */
    public void addClient (String nickname, ClientHandler clientHandler) {
        server.addClient(nickname, clientHandler);
    }

    /**
     * Handles the receiving of a message, passing the request to the {@code Server}.
     * @param message The message received.
     */
    public void onMessageReceived(Message message) {
        server.onMessageReceived(message);
    }
}


