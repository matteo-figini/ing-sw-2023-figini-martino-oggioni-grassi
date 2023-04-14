package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.view.VirtualView;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the main class for the controller in the MVC package. It receives the inputs as messages
 * from the view and updates the model, controlling all the game logic.
 */
public class GameController {
    private Game game;              // Entry point for the model.
    private GameState gameState;    // State of the game.
    private String activePlayer;    // Active player.
    private Map<String, VirtualView> virtualViewMap;    // Map of the virtual views.

    /**
     * Default constructor for the {@code GameController} class.
     * Every action is demanded to {@code initGameController} method that creates the game controller class.
     */
    public GameController () {
        initGameController();
    }

    /**
     * Private method that initializes the {@code GameController} class.
     */
    private void initGameController () {
        this.game = Game.getGameInstance();
        this.virtualViewMap = new HashMap<>();      // Potrebbe dare problemi di concorrenza?
        // Altre cose da istanziare
        setGameState(GameState.LOBBY_STATE);
    }

    /*
    Per strutturare il controller, pensavo di realizzare qualcosa del tipo:
    -) un metodo riceve i messaggi: in base allo stato corrente del gioco, i messaggi vengono delegati ad un metodo (uno per gli stati);
    -) ciascuno dei metodi che riceve il messaggio controlla
    E' necessario controllare il mittente dei messaggi, per garantire che il mittente dei messaggi sia il giocatore attualmente attivo.
     */

    /* ---------- GETTERS & SETTERS ---------- */
    /**
     * This method returns the current state of the game.
     * @return The current state of the game.
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * This private method sets the current state of the game.
     * It is private because only the class itself can change the state of the game.
     * @param gameState The new state of the game.
     */
    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * This method returns the virtual view map.
     * @return The virtual view map.
     */
    public Map<String, VirtualView> getVirtualViewMap() {
        return virtualViewMap;
    }

    /* ---------- UTILITY METHODS ---------- */

}
