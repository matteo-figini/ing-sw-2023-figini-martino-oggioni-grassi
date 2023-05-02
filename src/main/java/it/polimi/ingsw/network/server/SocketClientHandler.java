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

        //TODO: implementare i lock e vedere se ha senso tenere 'Extends Thread' o è meglio implementare l'interfaccia Runnable.

        try{
            while(!Thread.currentThread().isInterrupted()){
                Message message = (Message) input.readObject();

                if (message != null && message.getMessageType() != MessageType.PING_MESSAGE){
                    if (message.getMessageType() == MessageType.LOGIN_REQUEST){
                        server.addClient(message.getNickname(), this);
                    } else {
                        sendMessage(message);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        System.out.println("Starting Thread for the client " + clientSocket.getInetAddress().getHostName());
        super.start();
    }

    @Override
    public void sendMessage(Message message) {
        
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }
}
