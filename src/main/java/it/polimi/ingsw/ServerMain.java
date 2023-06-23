package it.polimi.ingsw;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.rmi.RemoteServer;
import it.polimi.ingsw.network.rmi.RemoteServerImpl;
import it.polimi.ingsw.network.socket.server.SocketServer;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static void main(String[] args) {
        boolean rmiConnection = false;

        for (String param : args) {
            if (param.equalsIgnoreCase("--rmi") || param.equalsIgnoreCase("-r")) {
                rmiConnection = true;
                break;
            }
        }

        GameController gameController = new GameController();
        Server server = new Server(gameController);
        SocketServer socketServer = new SocketServer(server, SocketServer.SOCKET_SERVER_PORT);
        Thread thread = new Thread(socketServer);
        thread.start();
        try {
            RemoteServerImpl remoteServer = new RemoteServerImpl(server);
        } catch (RemoteException e) {
            System.out.println("Cannot start RMI server.");
        }
    }
}
