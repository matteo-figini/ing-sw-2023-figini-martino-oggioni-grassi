package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.message.Message;

/**
 * Generic interface to implement observer design pattern.
 * Every observer must implement this interface and redefine the update method.
 */
public interface Observer {
    public void update (Message message);
}
