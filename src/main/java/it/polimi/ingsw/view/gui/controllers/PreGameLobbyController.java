package it.polimi.ingsw.view.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import it.polimi.ingsw.view.gui.GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * This class represents the controller for the scene where the nickname is asked.
 */
public class PreGameLobbyController {
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
    void initialize() {
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'preGameLobby.fxml'.";
        assert playerNickname != null : "fx:id=\"playerNickname\" was not injected: check your FXML file 'preGameLobby.fxml'.";
    }

    public void setOnNicknameConfirmedListener(Consumer<String> listener) {
        this.onNicknameConfirmedListener = listener;
    }

    public String getPlayerNickname() {
        return playerNickname.getText();
    }

    @FXML
    public void askNicknameInformation(javafx.event.ActionEvent event) throws IOException{
        String nickname = getPlayerNickname();
        if (onNicknameConfirmedListener != null) {
            onNicknameConfirmedListener.accept(nickname);
        }
    }
}
