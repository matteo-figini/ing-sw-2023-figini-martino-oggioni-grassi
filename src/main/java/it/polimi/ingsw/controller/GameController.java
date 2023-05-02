package it.polimi.ingsw.controller;

import it.polimi.ingsw.exception.NoScoringTokenAvailableException;
import it.polimi.ingsw.exception.NotEnoughCellsException;
import it.polimi.ingsw.exception.WrongPositionsException;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;
import it.polimi.ingsw.network.message.PickTiles;
import it.polimi.ingsw.network.message.PlayersNumberReply;
import it.polimi.ingsw.view.VirtualView;

import java.util.*;

/**
 * This class represents the main class for the controller in the MVC package. It receives the inputs as messages
 * from the view and updates the model, controlling all the game logic.
 */
public class GameController{
    private Game game;              // Entry point for the model.
    private GameState gameState;    // State of the game.
    private String activePlayer;    // Active player.
    private Map<String, VirtualView> virtualViewMap;    // Map of the virtual views.

    private Map<String, Integer> scoreMap;
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
        this.scoreMap = new HashMap<>();
        // TODO: Altre cose da istanziare?
        setGameState(GameState.LOBBY_STATE);
    }

    /* ---------- MESSAGES HANDLER ---------- */
    /**
     * This method handles a message received from the client switching on the current game state.
     * @param message The message received from the client over the network layer.
     */
    public void onMessageReceived (Message message) {
        switch (gameState) {
            case LOBBY_STATE:
                lobbyStateHandler(message);
                break;
            case IN_GAME:
                turnController(message);
                break;
            case LAST_LAP:
                lastLapStateManager(message);
                break;
            case END_GAME:
                // TODO: Teoricamente non dovrebbero arrivare messaggi in questa fase (forse l'inizio di una nuova partita?)
                break;
            default:
                // TODO: segnalare stato di gioco non valido!
        }
    }

    /**
     * This method handles the Lobby state.
     * In this state, the only message allowed is PLAYERSNUMBER_REPLY, since the login is handled directly by the {@code Server}.
     * @param message The message received from the network layer.
     */
    private void lobbyStateHandler (Message message) {
        if (message.getMessageType() == MessageType.PLAYERSNUMBER_REPLY) {
            PlayersNumberReply messageReceived = (PlayersNumberReply) message;
            if (messageReceived.getPlayersNumber() >= Game.MIN_PLAYERS && messageReceived.getPlayersNumber() <= Game.MAX_PLAYERS) {
                game.setChosenPlayersNumber(messageReceived.getPlayersNumber());
                System.out.println("This game will have " + game.getChosenPlayersNumber() + " players.");
            } else {
                // Rimanda la richiesta di invio del numero di giocatori
            }
        } else {
            System.out.println("ERROR: Wrong message type (expected: PLAYERSNUMBER_REPLY, actual: " + message.getMessageType().toString() + ")");
        }
    }
    /*
     * TODO (Problema di concorrenza): potrebbe creare problemi il fatto che nuovi giocatori si connettano mentre il primo giocatore sta ancora decidendo il numero di giocatori?
     */

    /**
     * This method handles a player's turn inside IN_GAME state.
     * Server receives a PICK_TILES request from the active player and controls the execution flow.
     * @param message The message received from the network layer.
     */
    private void turnController (Message message) {
        VirtualView currentVirtualView = virtualViewMap.get(getActivePlayer());

        if (message.getMessageType() == MessageType.PICK_TILES) {
            if (message.getNickname().equals(getActivePlayer())) {
                PickTiles messageReceived = (PickTiles) message;

                if (game.getPlayerByNickname(getActivePlayer()).getShelf().freeCellsOnColumn(messageReceived.getColumn()) >= messageReceived.getPositionsOfTiles().size()) {
                    // Vi sono sufficienti celle nella shelf. A questo punto controllo che le posizioni coincidano con tessere valide.
                    if (insertTilesInShelf(messageReceived.getPositionsOfTiles(), messageReceived.getColumn())) {
                        showBoard();
                        showShelfOfEachPlayer();
                        checkCommonGoalsCompleted();
                        checkBoardRefillRequested();
                        if (game.getPlayerByNickname(getActivePlayer()).getShelf().isFull()) {
                            setGameState(GameState.LAST_LAP);
                            game.getPlayerByNickname(getActivePlayer()).setEndGameToken();
                            broadcastGenericMessage(getActivePlayer() + " completed his shelf. Last lap starts now!");
                        }
                        newTurn();
                    } else {
                        currentVirtualView.showGenericMessage("There was a problem during the insertion: maybe " +
                                "positions are not valid or the column hasn't got enough cells!");
                        askActivePlayerColumnAndPosition();
                    }
                } else {
                    currentVirtualView.showGenericMessage("There aren't enough free cells on the selected column!");
                }

            } else {
                System.out.println("ERROR: Message from the wrong client (expected: " + getActivePlayer() + ", actual: " + message.getNickname() + ")");
            }
        } else {
            System.out.println("ERROR: Wrong message type (expected: PICK_TILES, actual: " + message.getMessageType().toString() + ")");
        }
    }

    private void lastLapStateManager (Message message) {
        VirtualView currentVirtualView = virtualViewMap.get(getActivePlayer());
        if (message.getMessageType() == MessageType.PICK_TILES) {
            if (message.getNickname().equals(getActivePlayer())) {
                PickTiles messageReceived = (PickTiles) message;

                if (game.getPlayerByNickname(getActivePlayer()).getShelf().freeCellsOnColumn(messageReceived.getColumn()) >= messageReceived.getPositionsOfTiles().size()) {
                    // Vi sono sufficienti celle nella shelf. A questo punto controllo che le posizioni coincidano con tessere valide.
                    if (insertTilesInShelf(messageReceived.getPositionsOfTiles(), messageReceived.getColumn())) {
                        showBoard();
                        showShelfOfEachPlayer();
                        checkCommonGoalsCompleted();
                        checkBoardRefillRequested();
                        if (game.getPlayerByNickname(getNextPlayer()).isFirstPlayer()) {
                            setGameState(GameState.END_GAME);
                            broadcastGenericMessage("Next player has the chair: the game finishes!");
                            endGame();
                        } else {
                            newTurn();
                        }
                    } else {
                        currentVirtualView.showGenericMessage("There was a problem during the insertion: maybe" +
                                "positions are not valid or the column hasn't got enough cells!");
                        askActivePlayerColumnAndPosition();
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

    /**
     * This method ends the game, calculating the points for each player.
     */
    private void endGame () {
        for (Player player : game.getPlayers()) {
            player.addScore(player.getShelf().pointsFromAdjacencies());     // Aggiungi i punti delle adiacenze
            player.addScore(player.getPersonalGoalCard().pointsFromGoals(player.getPersonalGoalCard().goalsSatisfied(player.getShelf())));  // Aggiungi gli obiettivi personali
            if (player.hasEndGameToken()) {
                player.addScore(1);     // Points from the end game token
            }
        }

        /*
         * Poi, cerca il giocatore con punteggio più alto:
         * - Se il giocatore con punteggio più alto è unico, lui è il vincitore della partita.
         * - Altrimenti, in caso di parità, il vincitore è colui che è più lontano dal giocatore con la sedia.
         * Infine, termina la partita (es. resettando l'istanza di Game e facendo altre cose...).
         * TODO: da definire cosa succede nel dopo-partita: nuova partita oppure interruzione di tutto quanto?
         */
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
            game.addPlayer(nickname);
            virtualView.askPlayersNumber();
            virtualView.showGenericMessage("Waiting for other players...");
        } else if (virtualViewMap.size() < game.getChosenPlayersNumber()) {
            // The player is not the first one. We suppose here that the nickname is already checked by the server.
            addVirtualView(nickname, virtualView);
            game.addPlayer(nickname);
            virtualView.showGenericMessage("Waiting for other players...");
            if (game.getPlayers().size() == game.getChosenPlayersNumber()) {
                broadcastGenericMessage("All the players are connected.");
                // Desired number of players reached.
                // Se implementiamo la persistenza, questo potrebbe essere il punto in cui ripristinare lo stato del gioco.
                // Inizia il gioco.
                startGame();
            }
        }
    }

    public boolean checkNicknameAvailability (String nickname, List<Player> players, VirtualView virtualView){
        //implement input controller to get the nickname
        // TODO: what does do this method? Is it necessary to pass the list of the players, while the controller already knows them?
        return false;
    }

    /* ---------- TURN HANDLING ---------- */
    /**
     * This method returns the next active player (without changing it in the game).
     * @return The name of the next active player.
     */
    private String getNextPlayer () {
        Player player = game.getPlayerByNickname(getActivePlayer());
        int indexOfPlayer = game.getPlayers().indexOf(player);
        if (indexOfPlayer == game.getPlayers().size() - 1) {
            indexOfPlayer = 0;
        } else {
            indexOfPlayer++;
        }
        return game.getPlayers().get(indexOfPlayer).getNickname();
    }

    /**
     * This method returns the nickname of a player, chosen randomly inside the list of the players.
     * @return The nickname of the randomly chosen player.
     */
    private String chooseRandomPlayer () {
        Random random = new Random();
        int indexOfFirstPlayer = random.nextInt(game.getPlayers().size());  // To generate number between 0 and the number of player - 1
        return game.getPlayers().get(indexOfFirstPlayer).getNickname();
    }

    /**
     * This method evolves the turn of the player, passing on the next one and notifying the players.
     */
    private void newTurn () {
        setActivePlayer(getNextPlayer());
        broadcastGenericMessage("Turn of " + getActivePlayer());
        askActivePlayerColumnAndPosition();
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
     * This method returns the map of the virtual view of every player.
     * @return the VirtualView map.
     */
    public Map<String, VirtualView> getVirtualView(){
        return this.virtualViewMap;
    }

    /**
     * This private method sets the current state of the game. It is private because only the class itself can change
     * the state of the game.
     * @param gameState The new state of the game.
     */
    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * This method returns the name of the current active player.
     * @return A string containing the name of the current active player.
     */
    public String getActivePlayer() {
        return activePlayer;
    }

    /**
     * This method sets the name of the current active player with the value passed as parameter if it exists.
     * @param player The name of the current active player.
     */
    public void setActivePlayer (String player) {
        if (game.getPlayerByNickname(player) != null) {
            this.activePlayer = player;
        }
    }

    public List<Player> getPlayers(){
        return game.getPlayers();
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
        this.virtualViewMap.put(nickname, virtualView);
    }

    public void removeVirtualView (String nickname, VirtualView vv){
        this.virtualViewMap.remove(nickname, vv);
    }

    /* ---------- UTILITY METHODS ---------- */
    /**
     * This method starts the game...
     */
    private void startGame () {
        setGameState(GameState.IN_GAME);
        game.startGame();
        // TODO: mostrare a tutti gli utenti la board
        // TODO: mostrare a tutti gli utenti le shelf
        // TODO: mostrare a tutti gli utenti le carte obiettivo comune
        // TODO: mostrare a ciascun utente la propria carta obiettivo personale
        broadcastGenericMessage("Game Started");

        // TODO: gestione del nuovo turno
        setActivePlayer(chooseRandomPlayer());  // Choose the first player
        broadcastGenericMessage("Turn of " + getActivePlayer());
        askActivePlayerColumnAndPosition();
    }

    /**
     * This method shows to each player the updated board.
     */
    private void showBoard () {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            virtualView.showBoardContent(game.getBoard().getBoardContentCopy());
        }
    }

    /**
     * This method shows to each player the shelf of every player.
     */
    private void showShelfOfEachPlayer () {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            for (Player playerShelf : game.getPlayers()) {
                virtualView.showShelfContent(playerShelf.getShelf().getShelfContentCopy(), playerShelf.getNickname());
            }
        }
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
     * This method sends a request to the active player to choose the item tiles it wants to pick up from the board
     * and the column it wants to insert them.
     */
    private void askActivePlayerColumnAndPosition () {
        VirtualView virtualView = virtualViewMap.get(getActivePlayer());
        System.out.println(getActivePlayer() + " is required to select column and position.");
        virtualView.askColumnAndPositions();
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
            game.getPlayerByNickname(getActivePlayer()).getShelf().insertCards(itemTiles, column);
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
        Player activePlayerModel = game.getPlayerByNickname(getActivePlayer());
        CommonGoalCard commonGoalCard = game.getCommonGoalCards().get(0);
        int score = 0;

        // Controllo del primo obiettivo comune
        if (!activePlayerModel.isFirstCommonGoalReached() && commonGoalCard.checkPattern(activePlayerModel.getShelf())) {
            activePlayerModel.setFirstCommonGoalReached();
            try {
                score = commonGoalCard.popScoringToken().getScore();
                activePlayerModel.addScore(score);
            } catch (NoScoringTokenAvailableException e) {
                System.out.println(e.getMessage());
            }
        }

        // Controllo del secondo obiettivo comune
        commonGoalCard = game.getCommonGoalCards().get(1);
        if (!activePlayerModel.isSecondCommonGoalReached() && commonGoalCard.checkPattern(activePlayerModel.getShelf())) {
            activePlayerModel.setSecondCommonGoalReached();
            try {
                score = commonGoalCard.popScoringToken().getScore();
                activePlayerModel.addScore(score);
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
            broadcastGenericMessage("Proceeding with board refill...");
            // TODO: mostrare a tutti i client la board aggiornata.
        }
    }

    public void addScore (String nickname, Integer finalScore) {
        this.scoreMap.put(nickname, finalScore);
    }

    public void removeScore (String nickname, Integer finalScore){
        this.scoreMap.remove(nickname, finalScore);
    }

    public Map<String, Integer> getScoreMap() {
        return scoreMap;
    }
}
