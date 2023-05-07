package it.polimi.ingsw.network.Socket.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.message.Message;

/**
 * This class extends the Server class by Socket network technology.
 */
public class SocketServer implements Runnable {
    private final int port;
    public static final int SOCKET_SERVER_PORT = 5000;
    private final Server server;
    private ServerSocket serverSocket;

    /**
     * This constructor creates a server-side socket on a given port.
     */
    public SocketServer (Server server, int port) {
        this.server = server;
        this.port = port;
    }

    /**
     * Creates a thread that will listen on the {@code ServerSocket}.
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
                clientSocket.setSoTimeout(0);
                // Create and start the specific client handler.
                SocketClientHandler clientHandler = new SocketClientHandler(this, clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void onClientDisconnection (ClientHandler clientHandler) {
        server.onClientDisconnection(clientHandler);
    }

    public void addClient (String nickname, ClientHandler clientHandler) {
        server.addClient(nickname, clientHandler);
    }

    public void onMessageReceived(Message message) {
        server.onMessageReceived(message);
    }
}


