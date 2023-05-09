package it.polimi.ingsw.network.rmi;

import it.polimi.ingsw.network.message.Message;

import java.rmi.RemoteException;

public class RemoteServerImpl implements RemoteServer{
    @Override
    public boolean tryConnection(RemoteClient client) throws RemoteException {
        return false;
    }

    @Override
    public void joinGame(RemoteClient client) throws RemoteException {

    }

    @Override
    public void exitGame(RemoteClient client) throws RemoteException {

    }

    @Override
    public void reconnectToGame(RemoteClient client) throws RemoteException {

    }

    @Override
    public void forwardMessage(Message message) throws RemoteException {

    }
}
