package it.polimi.ingsw;

import it.polimi.ingsw.view.tui.TUI;

public class ClientMain {
    public static void main(String[] args) {
        boolean cliRequested = false;
        boolean rmiRequested = false;

        for (String param : args) {
            if (param.equalsIgnoreCase("--cli") || param.equalsIgnoreCase("-c")) {
                cliRequested = true;
            }
            if (param.equalsIgnoreCase("--rmi") || param.equalsIgnoreCase("-r")) {
                rmiRequested = true;
            }
        }

        if (cliRequested && !rmiRequested) {
            TUI tuiInterface = new TUI();

            // TODO: Avviare la comunicazione del client con interfaccia TUI e Socket per la connessione
        } else if (cliRequested && rmiRequested) {
            System.out.println("Unable to manage RMI connection. Client stopped.");
        } else if (!cliRequested && !rmiRequested) {
            System.out.println("Unable to manage GUI interface. Client stopped.");
        } else {
            System.out.println("Unable to manage RMI connection and GUI interface. Client stopped.");
        }
    }
}
