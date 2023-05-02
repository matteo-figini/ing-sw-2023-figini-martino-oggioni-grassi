package it.polimi.ingsw.network.server;

import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class is used to manage multi-client connection. When a new connection is accepted,
 * a new object SocketClientHandler is created and a new thread is started.
 */
public class SocketClientHandler extends Thread implements ClientHandler{
    private Socket clientSocket;
    private SocketServer server;
    private boolean isConnected;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    public SocketClientHandler(SocketServer server, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.isConnected = true;
    }
    public void run() {
        System.out.println("Server waiting for connections...");

        try{
            while(!Thread.currentThread().isInterrupted()){
                Message message = (Message) input.readObject();

                if (message != null && message.getMessageType() != MessageType.PING_MESSAGE){
                    if (message.getMessageType() == MessageType.LOGIN_REQUEST){
                        server.addClient(message.getNickname(), this);
                    } else {
                        System.out.println("Received Message: " + message.toString());
                        server.onMessageReceived(message);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("I/O error.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found error.");
        }
    }

    public void start() {
        System.out.println("Starting Thread for the client " + clientSocket.getInetAddress().getHostName());
        super.start();
    }

    @Override
    public void MessageToClient(Message message) {
        try{
            output.writeObject(message);
            output.reset();
        } catch (IOException e) {
            System.err.println("I/O Error.");
        }
    }

    @Override
    public void disconnect() throws IOException {
        try {
            if(clientSocket.isConnected())
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("I/O Error.");
        }
        Thread.currentThread().interrupt();
        server.closeConnection();
        this.isConnected = false;
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }
}
