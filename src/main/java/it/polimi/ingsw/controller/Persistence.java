package it.polimi.ingsw.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is used to implement the "persistence" functionality. It contains methods for serializing and deserializing
 * all the game status in a JSON file.
 */
public class Persistence {
    /** Reference to the {@code GameController}. */
    private GameController gameController;

    /** Name of the file containing the current status of the game. */
    public static final String SAVED_MATCH_FILENAME = "match.json";

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
        // Crea l'oggetto JSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        // Crea la stringa con l'oggetto serializzato
        String gameControllerString = gson.toJson(this.gameController);
        System.out.println(gameControllerString);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SAVED_MATCH_FILENAME));
            bufferedWriter.write(gameControllerString);
            bufferedWriter.close();
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
        // TODO: testare il metodo
        Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAVED_MATCH_FILENAME));
            this.gameController = gson.fromJson(reader, GameController.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            this.gameController = null;
        }
        return this.gameController;
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
