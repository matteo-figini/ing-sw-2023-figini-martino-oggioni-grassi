package it.polimi.ingsw;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.view.gui.GUIMain;
import it.polimi.ingsw.view.tui.ColoredTUI;
import it.polimi.ingsw.view.tui.TUI;
import javafx.application.Application;

/**
 * Entry point for the Client application. It asks to choose the preferred user interface (TUI or GUI).
 */
public class  ClientMain {
    public static void main(String[] args) {
        boolean cliRequested = false;

        for (String param : args) {
            if (param.equalsIgnoreCase("--cli") || param.equalsIgnoreCase("-c")) {
                cliRequested = true;
            }
        }

        if (cliRequested) {
            TUI tuiInterface = new ColoredTUI();
            ClientManager clientManager = new ClientManager(tuiInterface);
            tuiInterface.setClientManager(clientManager);
            tuiInterface.startView();
        } else {
            Application.launch(GUIMain.class);
        }
    }
}
