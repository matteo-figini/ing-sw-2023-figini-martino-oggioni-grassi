package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.message.Message;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RemoteClientHandler extends UnicastRemoteObject implements ClientHandler, Runnable{

    private RemoteClient remoteClient;

    public RemoteClientHandler (RemoteServerImpl server) throws RemoteException {
        super();
        boolean isConnected = true;
    }

    @Override
    public void run() {
        System.out.println("Established new client connection.");
                    //TODO ...
    }
    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean isConnected() {
        return false;
    }

}