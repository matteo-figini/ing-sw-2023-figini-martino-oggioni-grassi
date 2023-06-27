package it.polimi.ingsw.view.gui.controllers;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.view.gui.GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This scene asks the first player the number of the players in the game.
 */
public class NumPlayerRequestSceneController {
    /** The {@code ClientManager} associated with the client. */
    private ClientManager clientManager;
    /** The {@code GUI} class associated with the client. */
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
    private Label messageLabel;

    @FXML
    void initialize() {
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'NumPlayerRequestScene.fxml'.";
        assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: check your FXML file 'NumPlayerRequestScene.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file 'NumPlayerRequestScene.fxml'.";
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

    public void setGUI(GUI gui) {
        this.gui = gui;
    }

    /**
     * Check that the chosen number of the player is between {@code Game.MIN_PLAYERS} and {@code Game.MAX_PLAYERS} values.
     * If it is, it reports the error to the client, otherwise it sends the message via the {@code ClientManager} and changes
     * the scene.
     * @param event Event associated to the button click.
     */
    @FXML
    public void askPlayerNumber (javafx.event.ActionEvent event) {
        int number = getPlayerNumber();
        if (number < Game.MIN_PLAYERS || number > Game.MAX_PLAYERS) {
            numPlayers.setText("");
            messageLabel.setText("Wrong number of players (must be between " + Game.MIN_PLAYERS + " and " + Game.MAX_PLAYERS + ")");
        } else {
            clientManager.onUpdatePlayersNumber(number);
            gui.switchToWaitingRoom();
        }
    }
}
