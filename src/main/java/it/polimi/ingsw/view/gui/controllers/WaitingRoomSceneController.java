package it.polimi.ingsw.view.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polimi.ingsw.network.ClientManager;
import javafx.fxml.FXML;

/**
 * This class represents the controller for the waiting room's scene.
 * It doesn't have actions since this scene is just a standby scene.
 */
public class WaitingRoomSceneController {
    /** Reference to the {@code ClientManager} of the client. */
    private ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
    }

    /**
     * @return The {@code ClientManager} associated to the client.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Sets the proper {@code ClientManager} as parameter.
     * @param clientManager The {@code ClientManager} associated to the client.
     */
    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}