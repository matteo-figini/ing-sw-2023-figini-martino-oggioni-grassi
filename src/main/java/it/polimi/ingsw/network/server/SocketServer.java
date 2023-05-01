package it.polimi.ingsw.network.server;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import it.polimi.ingsw.controller.GameController;

/**
 * This class extends the Server class by Socket network technology.
 */
public class SocketServer extends Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int port = 55555;
    private boolean serverState;


    /**
     * This constructor creates a server-side socket on a given port.
     * @throws IOException when a problem occurs with the I/O system.
     */
    public SocketServer() throws IOException {
        super(new GameController());
        this.serverSocket = new ServerSocket(this.port);
    }

    /**
     * This method returns the current state of the Server.
     * @return a boolean which value is 1 if the Server is active, 0 otherwise.
     */
    public boolean isActive(){
        return this.serverState;
    }

    /**
     * This method sets the current state of the Server
     * @param state
     */
    public void setState(boolean state){
        this.serverState = state;
    }


    public void runServerConnection() throws IOException {

        while (isActive()) {
            try {
                ServerSocket sc = new ServerSocket(this.port);
                System.out.println("Server socket ready on port: " + this.port);
                Socket s = sc.accept();
                System.out.println("Received client connection");

            } catch (IOException ex) {
                System.err.println("Connection Failed. Try again.");
            }
        }
    }

    public void closeConnection(){

    }


}