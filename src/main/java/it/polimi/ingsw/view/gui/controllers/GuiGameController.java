package it.polimi.ingsw.view.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polimi.ingsw.network.ClientManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class GuiGameController {
    private ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Text Chat;

    @FXML
    private ImageView CommomGoalCard1;

    @FXML
    private ImageView CommomGoalCard2;

    @FXML
    private Button ExitButton;

    @FXML
    private ImageView PersonalGoalCard;

    @FXML
    private Text Player1Name;

    @FXML
    private Text Player2Name;

    @FXML
    private Text Player3Name;

    @FXML
    private Text Player4Name;

    @FXML
    void initialize() {
        assert Chat != null : "fx:id=\"Chat\" was not injected: check your FXML file 'game.fxml'.";
        assert CommomGoalCard1 != null : "fx:id=\"CommomGoalCard1\" was not injected: check your FXML file 'game.fxml'.";
        assert CommomGoalCard2 != null : "fx:id=\"CommomGoalCard2\" was not injected: check your FXML file 'game.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'game.fxml'.";
        assert PersonalGoalCard != null : "fx:id=\"PersonalGoalCard\" was not injected: check your FXML file 'game.fxml'.";
        assert Player1Name != null : "fx:id=\"Player1Name\" was not injected: check your FXML file 'game.fxml'.";
        assert Player2Name != null : "fx:id=\"Player2Name\" was not injected: check your FXML file 'game.fxml'.";
        assert Player3Name != null : "fx:id=\"Player3Name\" was not injected: check your FXML file 'game.fxml'.";
        assert Player4Name != null : "fx:id=\"Player4Name\" was not injected: check your FXML file 'game.fxml'.";
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }



}
