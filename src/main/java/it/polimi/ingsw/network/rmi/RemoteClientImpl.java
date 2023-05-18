package it.polimi.ingsw.network.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RemoteClientImpl implements RemoteClient{

    @Override
    public void startConnection(String serverName){
        RemoteServerImpl remoteServer;

        try {
            remoteServer = (RemoteServerImpl) Naming.lookup("rmi://"+serverName+"/RMIServer");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
