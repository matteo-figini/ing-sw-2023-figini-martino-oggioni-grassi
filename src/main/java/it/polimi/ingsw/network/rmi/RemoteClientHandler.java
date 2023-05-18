package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.socket.server.ClientHandler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RemoteClientHandler implements ClientHandler/*, Runnable*/ {
    private RemoteServerImpl remoteServer;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    protected RemoteClientHandler(RemoteServerImpl server) throws RemoteException {
        this.remoteServer = server;
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
