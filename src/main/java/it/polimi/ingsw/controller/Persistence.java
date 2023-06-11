package it.polimi.ingsw.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class is used to implement the "persistence" functionality. It contains methods for serializing and deserializing
 * all the game status in a JSON file.
 */
public class Persistence {
    /** Reference to the {@code GameController}. */
    private GameController gameController;

    /** Name of the file containing the current status of the game. */
    public static final String SAVED_MATCH_FILENAME = "match.data";

    /**
     * Constructs the {@code Persistence} class with a new {@code GameController}.
     */
    public Persistence () {
        this.gameController = new GameController();
    }

    /**
     * Constructs the {@code Persistence} class passing the current {@code GameController}.
     * @param gameController Reference to the {@code GameController}.
     */
    public Persistence (GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * Saves a JSON representation of the {@code GameController} attribute of the class inside the text file
     * SAVED_MATCH_FILENAME.
     */
    public void store () {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SAVED_MATCH_FILENAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.gameController);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the JSON data of the {@code GameController} class from SAVED_MATCH_FILENAME and save it to the
     * attribute of type {@code GameController}.
     * @return A reference to the {@code GameController} attribute: if the read failed, it returns {@code null} value.
     */
    public GameController restore () {
        try {
            FileInputStream fileInputStream = new FileInputStream(SAVED_MATCH_FILENAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.gameController = (GameController) objectInputStream.readObject();
            objectInputStream.close();

            return this.getGameController();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: a new game will be created.");
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Delete the saved match file, if it exists, otherwise nothing changes.
     */
    public void delete () {
        File file = new File(SAVED_MATCH_FILENAME);
        try {
            Files.deleteIfExists(Path.of(SAVED_MATCH_FILENAME));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return A reference to the {@code GameController} class.
     */
    public GameController getGameController () {
        return this.gameController;
    }

}
