package it.polimi.ingsw;

public class ServerMain {
    public static void main(String[] args) {
        boolean rmiConnection = false;

        for (String param : args) {
            if (param.equalsIgnoreCase("--rmi") || param.equalsIgnoreCase("-r")) {
                rmiConnection = true;
                break;
            }
        }
        // TODO: Istanzia la classe che gestisce il server e il game controller.

        if (rmiConnection) {
            System.out.println("Unable to manage RMI connection. Server closing.");
        } else {
            // TODO: Istanzia la classe che gestisce il server mediante socket
        }
    }
}
