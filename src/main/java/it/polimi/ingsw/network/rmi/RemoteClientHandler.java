package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.message.Message;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


//l'idea è che per ogni clienthandler vengono utilizzati i metodi dell'interfaccia remota
//del Server, per questo motivo estende UnicastRemoteObject così posso recuperare il riferimento al server.
public class RemoteClientHandler extends UnicastRemoteObject implements ClientHandler, Runnable{

    private RemoteClient remoteClient;

    public RemoteClientHandler (RemoteServerImpl server) throws RemoteException {
        super();
        boolean isConnected = true;
    }

    public void doJob(String serverHost) throws Exception{

        // take a reference of the server from the registry
        RemoteServerImpl remoteServer = (RemoteServerImpl) Naming.lookup("rmi://" + serverHost + "/ChatServer");

        //(nel Socket vengono salvati in due variabili di tipo Object)
    }

    @Override
    public void run() {
        System.out.println("Established new client connection.");
        while (!Thread.currentThread().isInterrupted()){
            //leggi il messaggio con metodo di RemoteServer e chiama
            //i metodi di RemoteServerImpl per passarne il contenuto al server.
        }
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