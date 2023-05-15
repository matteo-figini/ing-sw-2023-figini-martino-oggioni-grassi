package it.polimi.ingsw.view.gui.scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private Stage PrimaryStage;
    private Scene scene1;
    private Parent root1;

    private ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button2;

    @FXML
    private TextField numPlayers;

    @FXML
    private TextField playerNickname;

    @FXML
    void initialize() {
        if (3<5) {    //TODO: inserire condizione (true se è il primo giocatore, false se è uno di quelli successivi)
            setShowFrame(true);
        }
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'preGameLobby.fxml'.";
        assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: check your FXML file 'preGameLobby.fxml'.";
        assert playerNickname != null : "fx:id=\"playerNickname\" was not injected: check your FXML file 'preGameLobby.fxml'.";

    }

    public BooleanProperty showFrameProperty() {
        return showFrame;
    }

    public boolean isShowFrame() {
        return showFrame.get();
    }

    public void setShowFrame(boolean showSection) {
        showFrame.set(showSection);
    }

    public String getPlayersNumber() {
        return numPlayers.getText();
    }

    public String getPlayerNickname() {
        return playerNickname.getText();
    }

    public void switchToWaitingRoom(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/waitingRoom.fxml"));
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
    public void askNicknameInformation(javafx.event.ActionEvent event) throws IOException{
        String nickname;
        int nPlayers;

        nickname = getPlayerNickname();
        if (!getPlayersNumber().equalsIgnoreCase("")) {
            nPlayers = Integer.parseInt(getPlayersNumber());
            clientManager.onUpdatePlayersNumber(nPlayers);
        }
        clientManager.onUpdateNickname(nickname);




    }
}
