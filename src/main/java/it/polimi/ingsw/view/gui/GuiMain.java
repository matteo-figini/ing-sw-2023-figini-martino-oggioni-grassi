package it.polimi.ingsw.view.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/lobby.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/lobbyStyle.css").toExternalForm());
        /*
        Modo alternativo per applicare lo stesso css a più scene
        String css = this.getClass().getResource("lobbyStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        scene2.getStylesheets().add(css);
        */

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

