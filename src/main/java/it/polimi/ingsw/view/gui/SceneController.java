package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.observer.ViewObservable;
import it.polimi.ingsw.view.gui.scene.GenericSceneController;
import javafx.scene.Scene;

/**
 * This class implements the controller of a generic scene.
 */
public class SceneController extends ViewObservable {

    private static Scene activeScene;
    private static GenericSceneController activeController;

    /**
     * Returns the active scene.
     * @return active scene.
     */
    public static Scene getActiveScene(){
        return activeScene;
    }

    /**
     * Returns the active controller.
     * @return active controller.
     */
    public static GenericSceneController getActiveController(){
        return activeController;
    }

}
