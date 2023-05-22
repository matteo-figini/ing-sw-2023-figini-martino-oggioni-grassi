package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.View;
import it.polimi.ingsw.view.gui.controllers.PreGameLobbyController;
import it.polimi.ingsw.view.gui.controllers.NumPlayerController;
import it.polimi.ingsw.view.gui.controllers.WaitingRoomController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class implements the {@code View} interface in order to provide all the functionalities for the graphical view
 * of the MVC pattern.
 */
public class GUI implements View {

    /** Reference to the current {@code ClientManager} of the specified client. */
    private ClientManager clientManager;

    /** Reference to the {@code GUIMain} class. */
    private GUIMain guiMain;

    /**
     * This constructor takes in input the reference to the current {@code GUIMain} object.
     * @param guiMainReference The reference to the current {@code GUIMain} object.
     */
    public GUI (GUIMain guiMainReference) {
        this.guiMain = guiMainReference;
    }

    @Override
    public void askNickname() throws IOException {
        // When the server requires the client nickname, switch to the preGameLobby state.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/preGameLobby.fxml"));
        Parent root = loader.load();

        PreGameLobbyController preGameLobbyController = loader.getController();
        preGameLobbyController.setOnNicknameConfirmedListener(this::onNicknameConfirmed);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/lobbyStyle.css")).toExternalForm());
        Stage stage = guiMain.getPrimaryStage();
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/Publisher material/Icon 50x50px.png"))));
        stage.setTitle("My Shelfie");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    private void onNicknameConfirmed (String nickname) {
        clientManager.onUpdateNickname(nickname);
    }

    @Override
    public void askPlayersNumber() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/numPlayer.fxml"));
            Parent root = loader.load();

            NumPlayerController controller = loader.getController();
            controller.setClientManager(clientManager);
            controller.setGUI(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());

            Platform.runLater(() -> {
                Stage stage = guiMain.getPrimaryStage();
                stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/Publisher material/Icon 50x50px.png"))));
                stage.setTitle("My Shelfie");
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("");
                stage.show();
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void switchToWaitingRoom () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/waitingRoom.fxml"));
            Parent root = loader.load();

            WaitingRoomController controller = loader.getController();
            controller.setClientManager(clientManager);
            // controller.setGUI(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/lobbyStyle.css")).toExternalForm());

            Platform.runLater(() -> {
                Stage stage = guiMain.getPrimaryStage();
                stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/Publisher material/Icon 50x50px.png"))));
                stage.setTitle("My Shelfie");
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("");
                stage.show();
            });
        } catch(IOException e) {
            System.out.println("Error");
        }
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

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

}
