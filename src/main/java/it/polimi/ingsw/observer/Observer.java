package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.message.Message;

/**
 * Generic interface to implement observer design pattern.
 * Every observer must implement this interface and redefine the update method.
 */
public interface Observer {

    /**
     * Update the observer class based on the message received.
     * @param message The message received from the observable.
     */
    public void update (Message message);
}
