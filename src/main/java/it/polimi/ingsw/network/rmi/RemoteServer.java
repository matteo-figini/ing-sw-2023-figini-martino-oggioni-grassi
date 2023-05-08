package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.network.message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface through which the Client can see the Server.
 */
public interface RemoteServer extends Remote {
    /**
     * This method allows a Client to join the game on the Server.
     * @param client the Player who wants to join the Game.
     * @throws RemoteException if an error occurs during Client-Server communication.
     */
    public void joinGame(RemoteClient client) throws RemoteException;

    /**
     * This method allows a client (who is already in the game) to exit the match.
     *
     * @param client the Player who wants to exit the Game.
     * @throws RemoteException if an error occurs during Client-Server communication.
     */
    public void exitGame(RemoteClient client) throws RemoteException;

    /**
     * This method handles a client's reconnection if a disconnection occurs.
     * @param client the Player who has lost connection and wants to re-enter the Game
     * @throws RemoteException if an error occurs during Client-Server communication.
     */
    public void reconnectToGame(RemoteClient client) throws RemoteException;

    /**
     * This method forwards a message coming from the Client to the GameController through the Server.
     * @param message the message sent by the Client.
     * @throws RemoteException if an error occurs during Client-Server communication.
     */
    public void forwardMessage(Message message) throws RemoteException;


}
