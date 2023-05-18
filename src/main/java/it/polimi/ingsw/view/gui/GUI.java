package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.message.GenericMessage;
import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.View;
import it.polimi.ingsw.view.gui.controlles.LobbyController;
import it.polimi.ingsw.view.gui.controlles.PreGameLobbyController;
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
    private PreGameLobbyController preGameLobbyController;
    private GuiMain guiMain = new GuiMain();

    public void setStage(Stage stage) {
        guiMain.setPrimaryStage(stage);
    }

    @Override
    public void askNickname() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/preGameLobby.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());
        Stage stage = guiMain.getPrimaryStage();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/Publisher material/Icon 50x50px.png")));
        stage.setTitle("My Shelfie");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();

        preGameLobbyController = loader.getController();
        preGameLobbyController.setOnNicknameConfirmedListener(this::onNicknameConfirmed);
    }


    private void onNicknameConfirmed(String nickname) {
        clientManager.onUpdateNickname(nickname);
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
    public void showPersonalGoalCard(PersonalGoalCard personalGoalCard, String cardOwner) {

    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public PreGameLobbyController getPreGameLobbyController() {
        return preGameLobbyController;
    }

}
