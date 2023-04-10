package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic abstract class to implement Observer design pattern.
 * Every observable element must inherit from this class, so methods for adding/removing/notifying observers are implemented.
 */
public abstract class Observable {

    private final List<Observer> observersList = new ArrayList<>();

    /**
     * Add an observer to the observers' list.
     * @param obs The observer to be added.
     */
    public void addObserver (Observer obs) {
        observersList.add(obs);
    }

    /**
     * Remove the specified observer from the observers' list.
     * @param obs The observer to be removed.
     */
    public void removeObserver (Observer obs) {
        observersList.remove(obs);
    }

    /**
     * Notifies all the observers with a specific message.
     * @param message The notifying message.
     */
    protected void notifyObservers (Message message) {
        for (Observer obs : observersList) {
            obs.update (message);
        }
    }
}
