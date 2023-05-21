package it.polimi.ingsw.view.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.socket.client.ClientManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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