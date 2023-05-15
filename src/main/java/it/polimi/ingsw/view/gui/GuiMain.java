package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiMain extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        //TODO: Collegare la view di ogni giocatore
        /*
        Gui view = new Gui();
        ClientController clientController = new ClientController(view);
        view.addObserver(clientController);
        */

        //Load root layout
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/lobby.fxml"));
        Parent root = loader.load();

        /*
        MenuSceneController controller = loader.getController();
        controller.addObserver(clientController);
        */

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

}