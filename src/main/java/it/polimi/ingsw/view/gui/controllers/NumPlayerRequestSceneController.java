package it.polimi.ingsw.view.gui.controllers;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.view.gui.GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NumPlayerRequestSceneController {
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
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'NumPlayerRequestScene.fxml'.";
        assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: check your FXML file 'NumPlayerRequestScene.fxml'.";
    }

    public int getPlayerNumber() {
        int playerNumber = 0;
        try {
            playerNumber = Integer.parseInt(numPlayers.getText());
        } catch (NumberFormatException ignored) {
        }
        return playerNumber;
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
    public void askPlayerNumber (javafx.event.ActionEvent event) {
        int number = getPlayerNumber();
        if (number < Game.MIN_PLAYERS || number > Game.MAX_PLAYERS) {
            numPlayers.setText("");
        } else {
            clientManager.onUpdatePlayersNumber(number);
            gui.switchToWaitingRoom();
        }
    }
}
