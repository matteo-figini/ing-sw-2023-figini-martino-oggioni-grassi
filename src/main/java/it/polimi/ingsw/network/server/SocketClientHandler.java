package it.polimi.ingsw.network.server;

import java.io.IOException;
import java.net.Socket;

/**
 * This class is used to manage multi-client connection. When a new connection is accepted,
 * a new object SocketClientHandler is created and a new thread is started.
 */
public class SocketClientHandler extends Thread{
    private Socket clientSocket;
    private SocketServer server;
    public SocketClientHandler(SocketServer server, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.server = server;

    }
    public void run() {
       //Scambio messaggi con il Client
    }

    public void start() {
        System.out.println("Starting Thread for the client " + clientSocket.getInetAddress().getHostName());
        super.start();
    }

}
