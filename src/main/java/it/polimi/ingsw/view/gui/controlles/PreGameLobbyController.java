package it.polimi.ingsw.view.gui.controlles;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import it.polimi.ingsw.network.socket.client.ClientManager;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PreGameLobbyController {

    private BooleanProperty showFrame = new SimpleBooleanProperty(false);
    private Consumer<String> onNicknameConfirmedListener;
    private ClientManager clientManager;

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
        //assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: check your FXML file 'preGameLobby.fxml'.";
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
