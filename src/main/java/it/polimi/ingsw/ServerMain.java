package it.polimi.ingsw;

import it.polimi.ingsw.controller.GameController;
import it.polimi.ingsw.network.server.Server;
import it.polimi.ingsw.network.server.SocketServer;

public class ServerMain {
    public static void main(String[] args) {
        boolean rmiConnection = false;

        for (String param : args) {
            if (param.equalsIgnoreCase("--rmi") || param.equalsIgnoreCase("-r")) {
                rmiConnection = true;
                break;
            }
        }

        if (rmiConnection) {
            System.out.println("Unable to manage RMI connection. Server closing.");
        } else {
            GameController gameController = new GameController();
            Server server = new Server(gameController);

            SocketServer socketServer = new SocketServer(server, SocketServer.SOCKET_SERVER_PORT);
            Thread thread = new Thread(socketServer);
            thread.start();
        }
    }
}
