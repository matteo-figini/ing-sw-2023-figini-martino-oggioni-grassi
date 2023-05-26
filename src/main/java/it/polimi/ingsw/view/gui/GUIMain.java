package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.network.ClientManager;
import it.polimi.ingsw.view.gui.controllers.LobbyController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Entry point for the JavaFX GUI application.
 */
public class GUIMain extends Application {
    /** Application primary stage. */
    private Stage primaryStage;

    /**
     * Entry point for the JavaFX application
     * @param stage The {@code Stage} for the class.
     * @throws IOException Exception that can be raised in the method.
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = new Stage();

        // Set the GUI class and the ClientManager class
        GUI guiInterface = new GUI(this);
        ClientManager clientManager = new ClientManager(guiInterface);
        guiInterface.setClientManager(clientManager);

        // Load root layout
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/lobby.fxml"));
        Parent root = loader.load();
        LobbyController lobbyController = loader.getController();
        lobbyController.setClientManager(clientManager);

        //Set the scene
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/lobbyStyle.css")).toExternalForm());

        //Set the scene on the stage
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/Publisher material/Icon 50x50px.png"))));
        primaryStage.setTitle("My Shelfie");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
    }

    /**
     * Stop the process when clicking on the top-right 'X' button.
     */
    @Override
    public void stop () {
        Platform.exit();
        System.exit(0);
    }

    /**
     * @return A reference to the primary stage.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}