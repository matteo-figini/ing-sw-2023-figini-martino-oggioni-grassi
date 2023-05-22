package it.polimi.ingsw;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.rmi.RemoteServerImpl;
import it.polimi.ingsw.network.socket.server.SocketServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) throws RemoteException {
        boolean rmiConnection = false;

        for (String param : args) {
            if (param.equalsIgnoreCase("--rmi") || param.equalsIgnoreCase("-r")) {
                rmiConnection = true;
                break;
            }
        }

        GameController gameController = new GameController();
        Server server = new Server(gameController);

        if (rmiConnection) {
            //System.out.println("Unable to manage RMI connection. Server closing.");
            RemoteServerImpl remoteServer = new RemoteServerImpl(server);
            // remoteServer.startServerConnection(); //will be replaced by thread.run
            //Thread thread = new Thread (remoteServer);
            //thread.start();
        } else {
            SocketServer socketServer = new SocketServer(server, SocketServer.SOCKET_SERVER_PORT);
            Thread thread = new Thread(socketServer);
            thread.start();
        }
    }
}
