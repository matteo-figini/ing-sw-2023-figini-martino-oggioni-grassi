package it.polimi.ingsw.controller;

import it.polimi.ingsw.exception.NoScoringTokenAvailableException;
import it.polimi.ingsw.exception.NotEnoughCellsException;
import it.polimi.ingsw.exception.WrongPositionsException;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;
import it.polimi.ingsw.network.message.PickTiles;
import it.polimi.ingsw.view.View;
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
            //virtualView.showGenericMessage("Waiting for other players...");
        } else if (virtualViewMap.size() < game.getChosenPlayersNumber()) {
            // The player is not the first one.
            // We suppose here that the nickname is already checked by the server.
            addVirtualView(nickname, virtualView);
            game.getPlayers().add(new Player(nickname));
            // TODO: Inform the player of the connection.
            //virtualView.showGenericMessage("Waiting for other players...");

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
     * This method starts the game...
     */
    private void startGame () {
        setGameState(GameState.IN_GAME);
        game.startGame();
        broadcastGenericMessage("Game Started");

    }

    /* ---------- MESSAGE SWITCH && STATE HANDLING ---------- */
    /**
     * This method handles a message received from the client switching on the current game state.
     * @param message The message received from the client over the network.
     */
    public void onMessageReceived (Message message) {
        switch (gameState) {
            case LOBBY_STATE:
                //lobbyStateHandler(message);
                break;
            case IN_GAME:
                turnController(message);
                break;
            case LAST_LAP:
                break;
            case END_GAME:
                break;
            default:
                // TODO: segnalare stato di gioco non valido!
        }
    }

    /**
     * This method handles the Lobby state.
     * In this state, the only message allowed is PLAYERSNUMBER_REPLY, since the login is handled directly by the {@code Server}.
     * @param message The message received.
     */
    private void lobbyStateHandler (Message message) {   //utile?
        if (message.getMessageType() == MessageType.PLAYERSNUMBER_REPLY) {
            // Se il numero di giocatori inserito è nel range atteso, imposta il numero di giocatori in Game
            // e invia un messaggio di attesa di altri giocatori
        } else {
            System.out.println("ERROR: Wrong message type (expected: PLAYERSNUMBER_REPLY, actual: " + message.getMessageType().toString() + ")");
        }
    }

    /**
     * This method handles a player's turn.
     * @param message
     */
    private void turnController (Message message) {
        VirtualView currentVirtualView = virtualViewMap.get(activePlayer);

        if (message.getMessageType() == MessageType.PICK_TILES) {
            if (message.getNickname().equals(activePlayer)) {
                PickTiles messageReceived = (PickTiles) message;

                if (game.getPlayerByNickname(activePlayer).getShelf().freeCellsOnColumn(messageReceived.getColumn()) >= messageReceived.getPositionsOfTiles().size()) {
                    // Vi sono sufficienti celle nella shelf. A questo punto controllo che le posizioni coincidano con tessere valide.
                    if (insertTilesInShelf(messageReceived.getPositionsOfTiles(), messageReceived.getColumn())) {
                        // TODO: Mostra la board aggiornata a tutti i client
                        // TODO: Mostra la shelf aggiornata al giocatore corrente
                        checkCommonGoalsCompleted();
                        checkBoardRefillRequested();
                        if (game.getPlayerByNickname(activePlayer).getShelf().isFull()) {
                            setGameState(GameState.LAST_LAP);
                            // TODO: inviare un messaggio in broadcast che informa i giocatori che l'ultimo giro è appena iniziato.
                        }
                    } else {
                        // Eccezione sollevata durante l'inserimento delle tessere.
                        // Notifica al client l'errore e richiedi l'inserimento.
                        currentVirtualView.showGenericMessage("There was a problem during the insertion: maybe" +
                                "positions are not valid or the column hasn't got enough cells!");
                        // TODO: come richiedere al client l'inserimento delle tessere?
                    }
                } else {
                    currentVirtualView.showGenericMessage("There aren't enough free cells on the selected column!");
                }

            } else {
                System.out.println("ERROR: Message from the wrong client (expected: " + activePlayer + ", actual: " + message.getNickname() + ")");
            }
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

    /**
     * This method sends a text message to each client.
     * @param messageString The text message to be sent.
     */
    private void broadcastGenericMessage (String messageString) {
        for (VirtualView virtualView : virtualViewMap.values()) {
            virtualView.showGenericMessage(messageString);
        }
    }

    /**
     * This method extracts the tiles from the board and insert them in the column.
     * @param positions Positions of tiles to extract from the board.
     * @return A boolean indicating if the insertion was successful or not.
     */
    private boolean insertTilesInShelf (List<Position> positions, int column) {
        boolean insertionSuccessful = true;
        List<ItemTile> itemTiles;
        try {
            itemTiles = game.getBoard().pickUpCards(positions);
            game.getPlayerByNickname(activePlayer).getShelf().insertCards(itemTiles, column);
        } catch (WrongPositionsException | NotEnoughCellsException e) {
            System.out.println(e.getMessage());
            insertionSuccessful = false;
        }
        return insertionSuccessful;
    }

    /**
     * This method checks if the active player completed a new common goal.
     * For each of the two common goal cards, the condition is that the player didn't reach the common goal before,
     * and it reach it now; then the score of the player is updated.
     */
    private void checkCommonGoalsCompleted () {
        Player activePlayerGame = game.getPlayerByNickname(activePlayer);
        CommonGoalCard commonGoalCard = game.getCommonGoalCards().get(0);
        int score = 0;

        if (!activePlayerGame.isFirstCommonGoalReached() && commonGoalCard.checkPattern(activePlayerGame.getShelf())) {
            activePlayerGame.setFirstCommonGoalReached();
            try {
                score = commonGoalCard.popScoringToken().getScore();
                activePlayerGame.addScore(score);
            } catch (NoScoringTokenAvailableException e) {
                System.out.println(e.getMessage());
            }
        }

        commonGoalCard = game.getCommonGoalCards().get(1);
        if (!activePlayerGame.isSecondCommonGoalReached() && commonGoalCard.checkPattern(activePlayerGame.getShelf())) {
            activePlayerGame.setSecondCommonGoalReached();
            try {
                score = commonGoalCard.popScoringToken().getScore();
                activePlayerGame.addScore(score);
            } catch (NoScoringTokenAvailableException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * This method checks if a board refill is requested. If it is, proceeds with board refilling.
     */
    private void checkBoardRefillRequested () {
        if (game.getBoard().fillingRequired()) {
            game.refillBoardFromBag();
            System.out.println("Proceeding with board refill...");
            // TODO: mostrare a tutti i client la board aggiornata.
        }
    }

}
