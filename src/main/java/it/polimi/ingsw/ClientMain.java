package it.polimi.ingsw;

import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.gui.GuiMain;
import it.polimi.ingsw.view.tui.ColoredTUI;
import it.polimi.ingsw.view.tui.TUI;
import javafx.application.Application;

public class  ClientMain {
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
            TUI tuiInterface = new ColoredTUI();
            ClientManager clientManager = new ClientManager(tuiInterface);
            tuiInterface.setClientManager(clientManager);
            tuiInterface.startView();
        } else if (cliRequested && rmiRequested) {
            System.out.println("Unable to manage RMI connection. Client stopped.");
        } else if (!cliRequested && !rmiRequested) {
            Application.launch(GuiMain.class);
            // System.out.println("Unable to manage GUI interface. Client stopped.");
        } else {
            System.out.println("Unable to manage RMI connection and GUI interface. Client stopped.");
        }
    }
}
