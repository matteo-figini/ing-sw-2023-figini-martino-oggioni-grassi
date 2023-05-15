package it.polimi.ingsw.view.gui.scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WaitingRoomController {

    private Stage PrimaryStage;
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
        loader.setLocation(getClass().getResource("/fxml/game.fxml"));
        Parent root = loader.load();
        Scene scene1 = new Scene(root);

        scene1.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());
        PrimaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        PrimaryStage.setScene(scene1);
        PrimaryStage.setFullScreen(true);
        PrimaryStage.show();
    }

}