package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.message.GenericMessage;
import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.View;
import it.polimi.ingsw.view.gui.controlles.LobbyController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI implements View {
    private ClientManager clientManager;

    @Override
    public void askNickname() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/preGameLobby.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());
        Stage primaryStage = new Stage();
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/Publisher material/Icon 50x50px.png")));
        primaryStage.setTitle("My Shelfie");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
    }

    @Override
    public void askPlayersNumber() {

    }

    @Override
    public void askColumnAndPositions() {

    }

    @Override
    public void showLoginResponse(boolean validNickname, boolean connectionEstablished) {

    }

    @Override
    public void showGenericMessage(String genericMessage) {
        // TODO: modificare la stampa del messaggio
        System.out.println(genericMessage);
    }

    @Override
    public void showBoardContent(BoardCell[][] boardContent) {

    }

    @Override
    public void showShelfContent(ShelfCell[][] shelfContent, String nickname) {

    }

    @Override
    public void showCommonGoalCard(CommonGoalCard commonGoalCard) {

    }

    @Override
    public void showPersonalGoalCard(PersonalGoalCard personalGoalCard) {

    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }


}
