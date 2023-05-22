package it.polimi.ingsw.view.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import it.polimi.ingsw.view.gui.GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PreGameLobbyController {
    private Consumer<String> onNicknameConfirmedListener;

    private GUI gui;

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

    public GUI getGUI() {
        return gui;
    }

    public void setGUI(GUI gui) {
        this.gui = gui;
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
