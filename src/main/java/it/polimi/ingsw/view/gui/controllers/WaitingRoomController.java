package it.polimi.ingsw.view.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polimi.ingsw.network.ClientManager;
import javafx.fxml.FXML;

public class WaitingRoomController {

    private ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}