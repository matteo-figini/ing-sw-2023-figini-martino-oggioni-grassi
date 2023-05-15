package it.polimi.ingsw.view.gui.scene;

import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.View;
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

public class LobbyController{

    private Stage PrimaryStage;
    private Scene scene1;
    private Parent root1;

    public ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Submit1;

    @FXML
    private Button button1;

    @FXML
    private TextField playerIpAddress;

    @FXML
    private TextField playerSocket;

    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'lobby.fxml'.";
        assert playerIpAddress != null : "fx:id=\"playerIpAddress\" was not injected: check your FXML file 'lobby.fxml'.";
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

    @FXML
    public void askServerInformation(javafx.event.ActionEvent event) throws IOException{
        String ipAddress, defaultIpAddress = "127.0.0.1";
        int port, defaultPort = 5000;
        boolean validInput = false;

        // Insert and verify the IP address and the port
        playerIpAddress.setStyle("-fx-text-fill: red;");
        playerSocket.setStyle("-fx-text-fill: red;");

        if (getPlayerIpAddress().equalsIgnoreCase(""))
            ipAddress = defaultIpAddress;
        else
            ipAddress = getPlayerIpAddress();

        if (getPlayerSocket().equals(""))
            port = defaultPort;
        else
            port = Integer.parseInt(getPlayerSocket());

        if (ClientManager.isValidIPAddress(getPlayerIpAddress()) && ClientManager.isValidPort(port)) {
            playerIpAddress.setStyle("-fx-text-fill: green");
            playerSocket.setStyle("-fx-text-fill: green;");

        }


    }

}
