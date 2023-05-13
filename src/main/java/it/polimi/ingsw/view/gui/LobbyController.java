package it.polimi.ingsw.view.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LobbyController {

    private Stage stage1;
    private Scene scene1;
    private Parent root1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
    }

    @FXML
    public void switchToWaitingRoom(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/waitingRoom.fxml"));
        Parent root1 = loader.load();
        Scene scene1 = new Scene(root1);

        scene1.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());
        stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
    }
}
