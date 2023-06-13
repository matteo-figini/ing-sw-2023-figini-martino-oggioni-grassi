package it.polimi.ingsw.view.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * This class represents the controller for the scene where the nickname is asked.
 */
public class NicknameRequestSceneController {
    private Consumer<String> onNicknameConfirmedListener;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button2;

    @FXML
    private TextField playerNickname;

    @FXML
    private Label infoLabel;

    @FXML
    void initialize() {
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'NicknameRequestScene.fxml'.";
        assert playerNickname != null : "fx:id=\"playerNickname\" was not injected: check your FXML file 'NicknameRequestScene.fxml'.";
    }

    public void setOnNicknameConfirmedListener(Consumer<String> listener) {
        this.onNicknameConfirmedListener = listener;
    }

    public String getPlayerNickname() {
        return playerNickname.getText();
    }

    public void resetPlayerNickname () {
        playerNickname.setText("");
    }

    @FXML
    public void askNicknameInformation(javafx.event.ActionEvent event) {
        String nickname = getPlayerNickname();
        if (onNicknameConfirmedListener != null) {
            onNicknameConfirmedListener.accept(nickname);
        }
    }

    public void setInformationMessage (String message) {
        infoLabel.setText(message);
    }
}
