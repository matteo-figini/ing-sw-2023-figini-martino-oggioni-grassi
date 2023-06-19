package it.polimi.ingsw;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.view.gui.GUIMain;
import it.polimi.ingsw.view.tui.ColoredTUI;
import it.polimi.ingsw.view.tui.TUI;
/*import javafx.application.Application;*/

public class  ClientMain {
    public static void main(String[] args) {
        boolean cliRequested = false;
        boolean rmiRequested = false;
        boolean connectionType; //boolean set true for socket connection and false for RMI connection

        for (String param : args) {
            if (param.equalsIgnoreCase("--cli") || param.equalsIgnoreCase("-c")) {
                cliRequested = true;
            }
            if (param.equalsIgnoreCase("--rmi") || param.equalsIgnoreCase("-r")) {
                rmiRequested = true;
            }
        }

        TUI tuiInterface = new ColoredTUI();
        ClientManager clientManager = new ClientManager(tuiInterface);
        tuiInterface.setClientManager(clientManager);
        if (cliRequested && !rmiRequested) {
            connectionType = true;
            System.out.println("Creating socket client...");
            tuiInterface.startView(connectionType);
        } else if (cliRequested && rmiRequested) {
            connectionType = false;
            System.out.println("Creating remote client...");
            tuiInterface.startView(connectionType);
        } else if (!cliRequested && !rmiRequested) {
            /*Application.launch(GUIMain.class);*/
        } else {
            System.out.println("Unable to manage RMI connection and GUI interface. Client stopped.");
        }
    }
}
