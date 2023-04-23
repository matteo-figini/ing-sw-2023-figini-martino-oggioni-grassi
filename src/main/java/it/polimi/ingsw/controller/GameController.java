package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
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

    //turnController partirà quando il server gli darà il via, dandogli il nome dell'activePlayer
    private void turnController(String activePlayer){
        /*
        -chiedere al client quali cards prendere
        -controllare che le carte selezionate possano essere prese
        -prendere le suddette cards nell'ordine selezionato
        -inserire le cards nella shelf nella colonna inserita dall'utente, verificando che la colonna abbia abbastanza posti
        -fine turno
        */
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
