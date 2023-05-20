package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.network.socket.client.ClientManager;
import it.polimi.ingsw.view.gui.controllers.LobbyController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiMain extends Application {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = new Stage();
        GUI guiInterface = new GUI();
        ClientManager clientManager = new ClientManager(guiInterface);
        guiInterface.setClientManager(clientManager);
        guiInterface.setStage(primaryStage);

        //Load root layout
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/lobby.fxml"));
        Parent root = loader.load();
        LobbyController lobbyController = loader.getController();
        lobbyController.setClientManager(clientManager);

        //Set the scene
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());

        //Set the scene on the stage
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/Publisher material/Icon 50x50px.png")));
        primaryStage.setTitle("My Shelfie");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

}