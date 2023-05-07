package it.polimi.ingsw.network.Socket.server;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * This class is used to manage multi-client connection. When a new connection is accepted,
 * a new object SocketClientHandler is created and a new thread is started.
 */
public class SocketClientHandler implements ClientHandler, Runnable {
    private Socket clientSocket;
    private SocketServer socketServer;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private boolean isConnected;
    private final Object inputLockObject;
    private final Object outputLockObject;

    /**
     * This constructor creates a socket ClientHandler which will manage by thread every single client connection.
     * @param server instance of the socket Server.
     * @param clientSocket Socket connected to the Client.
     */
    public SocketClientHandler (SocketServer server, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.socketServer = server;
        this.isConnected = true;
        this.inputLockObject = new Object();
        this.outputLockObject = new Object();

        try {
            this.outputStream = new ObjectOutputStream(this.clientSocket.getOutputStream());
            this.inputStream = new ObjectInputStream(this.clientSocket.getInputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run () {
        try {
            System.out.println("Established new client connection with: " + clientSocket.getInetAddress().toString());
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (inputLockObject) {
                        Message message = null;
                        try {
                            message = (Message) inputStream.readObject();
                        } catch (SocketException se) {
                            clientSocket.close();
                            this.isConnected = false;
                            Thread.currentThread().interrupt();
                        }
                        if (message != null && message.getMessageType() != MessageType.PING_MESSAGE) {
                            if (message.getMessageType() == MessageType.LOGIN_REQUEST) {
                                socketServer.addClient(message.getNickname(), this);
                            } else {
                                System.out.println("Received message: " + message.toString());
                                socketServer.onMessageReceived(message);
                            }
                        }
                    }
                }
                socketServer.onClientDisconnection(this);
            } catch (ClassNotFoundException | ClassCastException e) {
                System.out.println("Invalid stream.");
            }
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Unable to handle Socket client handler.");
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage (Message message) {
        try {
            synchronized (outputLockObject) {
                outputStream.writeObject(message);
                outputStream.reset();
                System.out.println("Message sent: " + message.toString());
            }
        } catch (IOException e) {
            System.err.println("I/O Error.");
            disconnect();
        }
    }


    @Override
    public void disconnect() {
        if (!isConnected)
            return;
        try {
            // If the socket for the client is still alive, close it.
            if (!clientSocket.isClosed()) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
        this.isConnected = false;
        socketServer.onClientDisconnection(this);
    }

    /**
     * Returns if the current client handler is connected.
     * @return {@code true} if the client handler is connected, {@code false} otherwise.
     */
    @Override
    public boolean isConnected() {
        return isConnected;
    }
}
