package it.polimi.ingsw.network.server;

import it.polimi.ingsw.network.message.Message;

/**
 * This interface represents a generic client handler for the server, to handle the connection with a specific client.
 * Every type of connection (e.g. Socket/RMI) must implement this interface.
 * This interface contains methods for sending a message to a client and to manage connection/disconnection.
 */
public interface ClientHandler {

    /**
     * This method sends a message to the client handled by the client handler.
     * @param message The message to send to the client.
     */
    public void sendMessage (Message message);

    /**
     * This method disconnects the specified client from the server, e.g. due to ping timeout or not valid information.
     */
    public void disconnect ();
    // La connessione con il client è gestita esplicitamente dal server!

    /**
     * This method indicates if the client handled by the client handler is connected to the server.
     * @return A boolean indicating if the client is connected or not.
     */
    public boolean isConnected ();
}
