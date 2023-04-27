package it.polimi.ingsw.controller;

import it.polimi.ingsw.exception.NotEnoughCellsException;
import it.polimi.ingsw.exception.WrongPositionsException;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.Position;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;
import it.polimi.ingsw.view.VirtualView;

import java.util.*;

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
        // TODO: Altre cose da istanziare?
        setGameState(GameState.LOBBY_STATE);
    }

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

    /* ---------- VIRTUAL VIEW METHODS ---------- */

    /**
     * This method returns the virtual view map.
     * @return The virtual view map.
     */
    public Map<String, VirtualView> getVirtualViewMap() {
        return virtualViewMap;
    }

    public void addVirtualView (String nickname, VirtualView virtualView) {
        // TODO: connect the observable (game, board, shelf...) with the observer (vv).
        this.virtualViewMap.put(nickname, virtualView);
    }

    /* ---------- MESSAGE SWITCH ---------- */
    /**
     * This method handles a message received from the client switching on the current game state.
     * @param message The message received from the client over the network.
     */
    public void onMessageReceived (Message message) {
        switch (gameState) {
            case LOBBY_STATE:
                break;
            case IN_GAME:
                turnController(message);    // Passa il controllo a turnController.
                break;
            case LAST_LAP:
                break;
            case END_GAME:
                break;
            default:
                // TODO: segnalare stato di gioco non valido!
        }
    }

    /* ---------- LOGIN HANDLER ---------- */
    /**
     * This method handles the login of all the clients. Every client is identified by his nickname and has a virtual view.
     * For each client, it establishes if the client is the first one (and in this case requires the number of the players)
     * and checks if the desired player number is reached, then starts the game.
     * @param nickname The nickname of the client to add to the players' list.
     * @param virtualView The virtual view of the client to add to the virtual views' map.
     */
    public void handleLogin (String nickname, VirtualView virtualView) {
        if (virtualViewMap.isEmpty()) {
            // First player to login. The nickname is always correct!
            addVirtualView(nickname, virtualView);
            game.getPlayers().add(new Player(nickname));
            // TODO: Inform the player of the connection.
            virtualView.askPlayersNumber();
        } else if (virtualViewMap.size() < game.getChosenPlayersNumber()) {
            // The player is not the first one.
            // We suppose here that the nickname is already checked by the server.
            addVirtualView(nickname, virtualView);
            game.getPlayers().add(new Player(nickname));
            // TODO: Inform the player of the connection.

            if (game.getPlayers().size() == game.getChosenPlayersNumber()) {
                // Desired number of players reached.
                // Se implementiamo la persistenza, questo potrebbe essere il punto in cui ripristinare lo stato del gioco.
                // Inizia il gioco.
                startGame();
                // TODO: inviare messaggio di inizio game
            }
        }
    }

    /* ---------- UTILITY METHODS ---------- */

    /**
     * This method starts the game
     */
    private void startGame () {
        setGameState(GameState.IN_GAME);
        game.startGame();
        // TODO: operare sulla classe Game!
    }

    private void turnController (Message message) {
        // TODO: bisogna anche controllare che il messaggio arrivi dal client corretto!
        /*
        Il controller riceve un messaggio contenente le posizioni delle tessere da estrarre dalla board e la colonna
        della shelf nella quale inserire le tessere. Qualora le posizioni non siano valide oppure non vi siano sufficienti
        celle nella colonna (condizioni segnalate con il lancio di un'eccezione), si notifica al client il problema e si chiede
        il reinserimento dei dati.
        Se le posizioni e la colonna sono valide, il server estrae le tessere dalle posizioni specificate nella board e le inserisce
        nella shelf del giocatore.
        In seguito si verificano, per quel giocatore, le singole condizioni di gioco:
        - Si verifica se il giocatore ha soddisfatto uno dei due obiettivi comuni che prima non erano soddisfatti
        - Si veri
         */
        if (message.getMessageType() == MessageType.PICK_TILES) {

        } else {
            System.out.println("ERROR: Wrong message type (expected: PICK_TILES, actual: " + message.getMessageType().toString() + ")");
        }
    }

    private void lastLap(){
        /*
        -si deve continuare a fare i turni ma fermandosi quando si arriva al giocare con la chair
        */
    }

    private void endGame(){
        /*
        -il gioco si interrompe
        -contare tutti i punti di ogni giocatore e proclamare il vincitore
        */
    }

}
