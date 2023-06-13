package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.view.View;
import it.polimi.ingsw.view.gui.controllers.GameSceneController;
import it.polimi.ingsw.view.gui.controllers.NicknameRequestSceneController;
import it.polimi.ingsw.view.gui.controllers.NumPlayerRequestSceneController;
import it.polimi.ingsw.view.gui.controllers.WaitingRoomSceneController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private NicknameRequestSceneController nicknameRequestSceneController;
    private GameSceneController gameSceneController;
    private List<String> nicknameList;

    /**
     * This constructor takes in input the reference to the current {@code GUIMain} object.
     * @param guiMainReference The reference to the current {@code GUIMain} object.
     */
    public GUI (GUIMain guiMainReference) {
        this.guiMain = guiMainReference;
    }

    @Override
    public void askNickname() throws IOException {
        // When the server requires the client nickname, switch to the Nickname Request scene.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/NicknameRequestScene.fxml"));
        Parent root = loader.load();

        nicknameRequestSceneController = loader.getController();
        nicknameRequestSceneController.setOnNicknameConfirmedListener(this::onNicknameConfirmed);

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
    }

    private void onNicknameConfirmed (String nickname) {
        clientManager.onUpdateNickname(nickname);
    }

    @Override
    public void askPlayersNumber() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/NumPlayerRequestScene.fxml"));
            Parent root = loader.load();

            NumPlayerRequestSceneController controller = loader.getController();
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

    @Override
    public void waitingRoom() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/WaitingRoomScene.fxml"));
            Parent root = loader.load();

            WaitingRoomSceneController controller = loader.getController();
            controller.setClientManager(clientManager);

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

    public void switchToWaitingRoom () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/WaitingRoomScene.fxml"));
            Parent root = loader.load();

            WaitingRoomSceneController controller = loader.getController();
            controller.setClientManager(clientManager);

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
    public void switchToGameRoom(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/GameScene.fxml"));
            Parent root = loader.load();

            this.gameSceneController = loader.getController();
            this.gameSceneController.setClientManager(clientManager);

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
        if (gameSceneController != null) {
            gameSceneController.enablePickingUp();
        }
    }

    @Override
    public void showLoginResponse (boolean validNickname, boolean connectionEstablished) {
        if (nicknameRequestSceneController != null && !validNickname) {
            Platform.runLater(() -> {
                nicknameRequestSceneController.setInformationMessage("Invalid nickname, please try again");
                nicknameRequestSceneController.resetPlayerNickname();
            });
        }
    }

    @Override
    public void showGenericMessage(String genericMessage) {
        // TODO: modificare la stampa del messaggio
        System.out.println(genericMessage);
        if(gameSceneController !=null) {
            showUpdateChat(genericMessage);
        }
    }

    @Override
    public void showPlayersList(List<String> players) {
        nicknameList = new ArrayList<>(players);
    }

    @Override
    public void showBoardContent(BoardCell[][] boardContent) {
        Platform.runLater(() -> gameSceneController.updateBoardContent(boardContent));
    }

    @Override
    public void showPlayerInformation(String player, ShelfCell[][] shelfContent, ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken) {
        Platform.runLater(() -> gameSceneController.updateShelfContent(player, shelfContent, firstCommonGoal, secondCommonGoal, hasEndGameToken));
    }

    @Override
    public void showCommonGoalCard(CommonGoalCard commonGoalCard, Integer progressiveCard) {
        Platform.runLater(() -> {
            gameSceneController.updateCommonGoalCard(commonGoalCard, progressiveCard);
        });
    }

    @Override
    public void showPersonalGoalCard(PersonalGoalCard personalGoalCard, String cardOwner) {
        gameSceneController.hideShelf(nicknameList.size());
        gameSceneController.showShelfNicknames(nicknameList);
        Platform.runLater(() -> {
            gameSceneController.updatePersonalGoalCard(personalGoalCard);
        });
    }

    @Override
    public void showScoreBoard(Map<String, Integer> scoreBoardMap) {
        if (gameSceneController != null) {
            gameSceneController.updateFinalScoreBoard(scoreBoardMap);
        }
    }

    public void showUpdateChat(String message) {
        gameSceneController.updateMessageBox(message);
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

}
