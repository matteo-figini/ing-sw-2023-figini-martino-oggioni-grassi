package it.polimi.ingsw.view.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.gui.GUI;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class NumPlayerController {
    private ClientManager clientManager;
    private GUI gui;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button3;

    @FXML
    private TextField numPlayers;

    @FXML
    void initialize() {
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'numPlayer.fxml'.";
        assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: check your FXML file 'numPlayer.fxml'.";
    }

    public int getPlayerNumber() {
        return Integer.parseInt(numPlayers.getText());
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public GUI getGUI() {
        return gui;
    }

    public void setGUI(GUI gui) {
        this.gui = gui;
    }
    @FXML
    public void askPlayerNumber(javafx.event.ActionEvent event) throws IOException{
        //TODO: fare controllo numero giocatore
        int number = getPlayerNumber();
        clientManager.onUpdatePlayersNumber(number);
        gui.waitingRoom(); //non va avanti
    }
}
