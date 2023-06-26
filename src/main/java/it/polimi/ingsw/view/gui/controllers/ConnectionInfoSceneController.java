package it.polimi.ingsw.view.gui.controllers;

import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.network.socket.server.SocketServer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class represents the first login scene, where the user inserts the IP address of the server and the port.
 */
public class ConnectionInfoSceneController implements Initializable {
    /** Reference to the {@code ClientManager}. */
    private ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button1;

    @FXML
    private TextField playerIpAddress;

    @FXML
    private TextField playerSocket;

    @FXML
    private ComboBox<String> connectionTypeBox;

    @Override
    public void initialize (URL url, ResourceBundle resources) {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'ConnectionInfoScene.fxml'.";
        assert playerIpAddress != null : "fx:id=\"playerIpAddress\" was not injected: check your FXML file 'ConnectionInfoScene.fxml'.";
        assert playerSocket != null : "fx:id=\"playerSocket\" was not injected: check your FXML file 'ConnectionInfoScene.fxml'.";
        connectionTypeBox.setItems(FXCollections.observableArrayList("Socket", "RMI"));
    }

    private String getPlayerIpAddress() {
        return playerIpAddress.getText();
    }

    private String getPlayerSocket() {
        return playerSocket.getText();
    }

    /**
     * Method activated by the ActionEvent on the button.
     * Try to connect to the server.
     * @param event The event on the button.
     */
    @FXML
    public void askServerInformation(javafx.event.ActionEvent event) {
        String ipAddress, defaultIpAddress = "127.0.0.1";
        int port;
        boolean rmiConnection = false;

        // Insert and verify the IP address and the port
        playerIpAddress.setStyle("-fx-text-fill: red;");
        playerSocket.setStyle("-fx-text-fill: red;");

        if (getPlayerIpAddress().equalsIgnoreCase(""))
            ipAddress = defaultIpAddress;
        else
            ipAddress = getPlayerIpAddress();

        if (getPlayerSocket().equals(""))
            port = SocketServer.SOCKET_SERVER_PORT;
        else {
            try {
                port = Integer.parseInt(getPlayerSocket());
            } catch (NumberFormatException e) {
                port = SocketServer.SOCKET_SERVER_PORT;
            }
        }

        rmiConnection = !connectionTypeBox.getValue().equals("Socket");

        if (ClientManager.isValidIPAddress(ipAddress) && ClientManager.isValidPort(port)) {
            playerIpAddress.setStyle("-fx-text-fill: green");
            playerSocket.setStyle("-fx-text-fill: green;");
            clientManager.onUpdateServerInformation(ipAddress, port, rmiConnection);
        } else {
            playerIpAddress.setText("");
            playerSocket.setText("");
        }
    }

    public void setClientManager (ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
