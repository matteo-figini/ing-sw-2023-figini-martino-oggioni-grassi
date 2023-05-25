package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.message.Message;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClientImpl extends Client implements RemoteClient, Runnable{

    @Override
    public void run() {
        try {
            //...
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public RemoteServer getReference() throws Exception{
        //Locate the Registry
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        //Get the reference of the exported object from RMI registry
        RemoteServer server = (RemoteServer) registry.lookup("server");
        return server;
    }

    @Override
    public void sendMessage(Message message) {
        try {
            RemoteServer server = getReference();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //TODO chiama metodo remoto (da implementare)
    }

    @Override
    public void messageReceived() throws RemoteException {
        //TODO implement
    }

    @Override
    public void readMessage() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void enablePing() {

    }

    @Override
    public void disablePing() {

    }

}
