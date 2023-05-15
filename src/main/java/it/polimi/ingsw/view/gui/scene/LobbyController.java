package it.polimi.ingsw.view.gui.scene;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LobbyController {

    private Stage PrimaryStage;
    private Scene scene1;
    private Parent root1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button1;
    @FXML
    private TextField numPlayers;
    @FXML
    private TextField playerIpAddress;

    @FXML
    private TextField playerNickname;

    @FXML
    private TextField playerSocket;

    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'lobby.fxml'.";
        assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: check your FXML file 'lobby.fxml'.";
        assert playerIpAddress != null : "fx:id=\"playerIpAddress\" was not injected: check your FXML file 'lobby.fxml'.";
        assert playerNickname != null : "fx:id=\"playerNickname\" was not injected: check your FXML file 'lobby.fxml'.";
        assert playerSocket != null : "fx:id=\"playerSocket\" was not injected: check your FXML file 'lobby.fxml'.";
    }

    public String getPlayerIpAddress() {
        return playerIpAddress.getText();
    }

    public String getPlayerSocket() {
        return playerSocket.getText();
    }

    @FXML
    public void switchToPreGameLobby(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/preGameLobby.fxml"));
        Parent root = loader.load();
        Scene scene1 = new Scene(root);

        scene1.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());
        PrimaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // scene1 = new Scene(root1);
        PrimaryStage.setScene(scene1);
        PrimaryStage.setFullScreen(true);
        PrimaryStage.show();
    }
}
