package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Custom abstract observable class that can be observed
 */
public abstract class ViewObservable {

    protected final List<ViewObserver> observers = new ArrayList<>();

    /**
     * Adds an observer.
     * @param obs the observer to be added.
     */
    public void addObserver(ViewObserver obs){
        observers.add(obs);
    }

    /**
     * Removes an observer.
     * @param obs the observer to be removed.
     */
    public void removeObserver(ViewObserver obs){
        observers.remove(obs);
    }

    /**
     * Notifies all the current observes.
     * @param message
     */
    public void notifyObserver(Message message){
        for(ViewObserver obs : observers){
            obs.update(message);
        }
    }


}
