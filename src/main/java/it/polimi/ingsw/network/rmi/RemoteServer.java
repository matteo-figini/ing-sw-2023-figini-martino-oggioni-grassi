package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.message.Message;

import java.rmi.RemoteException;

public interface RemoteServer /*, Runnable*/ {

    //metodo per testare la connessione (manda messaggio di ping)
    public void sendPing() throws RemoteException;

    //metodo per mandare un messaggio dal client al server
    public void messageToServer(Message msg) throws RemoteException;

    //metodo per aggiungere un client
    public void addClient() throws RemoteException;

}
