package it.polimi.ingsw.network.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import it.polimi.ingsw.controller.GameController;

/**
 * This class extends the Server class by Socket network technology.
 */
public class SocketServer extends Server {
    private Server server;
    private ServerSocket serverSocket;
    private int port = 55555;
    private boolean serverState = false;


    /**
     * This constructor creates a server-side socket on a given port.
     * @throws IOException when a problem occurs with the I/O system.
     */
    public SocketServer() throws IOException {
        super(new GameController());
        this.serverSocket = new ServerSocket(this.port);
        serverSocket.setSoTimeout(10000);
        this.serverState = true;
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


    /**
     * This method is built to accept connections from different clients.
     * @throws IOException when a I/O error occurs.
     */
    public void runServerConnection() throws IOException {
        System.out.println("Server started. Waiting for connections...");
        while (isActive()) {
           Socket clientSocket = serverSocket.accept();
            System.out.println("Connection accepted from " + clientSocket.getInetAddress().getHostName());
            SocketClientHandler clientHandler = new SocketClientHandler(this, clientSocket);
            clientHandler.start();
        }
    }


    /**
     * This method will be used to close the server connection.
     */
    public void closeConnection(ClientHandler clientHandler){
        if (serverSocket != null) {
            try {
                System.out.println("Closing Server...");
                serverSocket.close();
                server.ManageDisconnection(clientHandler);
                serverState = false;
            } catch (IOException e) {
                System.err.println("Disconnection Failed. Try again.");
            }
        }
    }
}


