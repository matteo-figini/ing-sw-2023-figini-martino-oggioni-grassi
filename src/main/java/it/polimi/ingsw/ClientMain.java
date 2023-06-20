package it.polimi.ingsw;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.view.gui.GUIMain;
import it.polimi.ingsw.view.tui.ColoredTUI;
import it.polimi.ingsw.view.tui.TUI;
import javafx.application.Application;

public class  ClientMain {
    public static void main(String[] args) {
        boolean cliRequested = false;
        boolean rmiRequested = false; // Boolean set true for RMI connection and false for Socket connection

        for (String param : args) {
            if (param.equalsIgnoreCase("--cli") || param.equalsIgnoreCase("-c")) {
                cliRequested = true;
            }
            if (param.equalsIgnoreCase("--rmi") || param.equalsIgnoreCase("-r")) {
                rmiRequested = true;
            }
        }

        if (cliRequested) {
            TUI tuiInterface = new ColoredTUI();
            ClientManager clientManager = new ClientManager(tuiInterface);
            tuiInterface.setClientManager(clientManager);
            tuiInterface.startView(rmiRequested);
        } else if (!cliRequested && !rmiRequested) {
            Application.launch(GUIMain.class);
        } else {
            System.out.println("Unable to manage RMI connection and GUI interface. Client stopped.");
        }
    }
}
