package it.polimi.ingsw.network.socket.server;

import it.polimi.ingsw.network.message.Message;

import java.io.IOException;

/**
 * This interface represents a generic client handler for the server, to handle the connection with a specific client.
 * Every type of connection (e.g. Socket/RMI) must implement this interface.
 * This interface contains methods for sending a message to a client and to manage connection/disconnection.
 */
public interface ClientHandler {

    /**
     * Sends a message to the client handled by the {@code ClientHandler}.
     * @param message The message to send to the client.
     */
    void sendMessage(Message message);

    /**
     * Disconnects the specified client from the server, e.g. due to ping timeout or not valid information.
     */
    void disconnect ();

    /**
     * Indicates if the client handled by the {@code ClientHandler} is connected to the {@code Server}.
     * @return A boolean indicating if the client is connected or not.
     */
    boolean isConnected ();
}
