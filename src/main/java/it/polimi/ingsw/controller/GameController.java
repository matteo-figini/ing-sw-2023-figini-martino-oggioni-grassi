package it.polimi.ingsw.controller;

import it.polimi.ingsw.exception.NoScoringTokenAvailableException;
import it.polimi.ingsw.exception.NotEnoughCellsException;
import it.polimi.ingsw.exception.WrongPositionsException;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.network.message.Message;
import it.polimi.ingsw.network.message.MessageType;
import it.polimi.ingsw.network.message.PickTilesResponse;
import it.polimi.ingsw.network.message.PlayersNumberResponse;
import it.polimi.ingsw.view.VirtualView;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class represents the main class for the controller in the MVC package. Main action of the game controller are:
 * - Receiving the messages from the client and take decisions based on the message type and the game state;
 * - Sending the model updates to all the clients;
 * - Handle the game logic.
 */
public class GameController implements Serializable {
    @Serial
    private static final long serialVersionUID = 34793873212834L;

    /** Entry class {@code Game} for the model. */
    private Game game;

    /** State of the game. */
    private GameState gameState;

    /** Name of the current active player. */
    private String activePlayer;

    /** Map of the virtual views (key: player's nickname, value: {@code VirtualView}). */
    private transient Map<String, VirtualView> virtualViewMap;    // Map of the virtual views.

    /** {@code true} if the game is currently suspended, {@code false} otherwise (default situation) */
    private boolean gameSuspended;

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
        this.virtualViewMap = new HashMap<>();
        this.gameSuspended = false;
        setGameState(GameState.LOBBY_STATE);
    }

    /* ---------- MESSAGE HANDLER ---------- */
    /**
     * Handles a received message and take actions based on the current game state.
     * @param message The message received from the client over the network layer.
     */
    public void onMessageReceived (Message message) {
        if (!isGameSuspended()) {
            System.out.println(gameState.toString());
            switch (gameState) {
                case LOBBY_STATE -> lobbyStateManager(message);
                case IN_GAME -> turnController(message);
                case LAST_LAP -> lastLapStateManager(message);
                case END_GAME -> endGameStateManager(message);
            }
        } else {
            System.out.println("Can't receive message since the game is suspended.");
        }
    }

    /**
     * Take actions based on a message arrived in {@code LOBBY_STATE} state.
     * @param message The message received. Requires that the number of the players is between {@code Game.MIN_PLAYERS}
     * and {@code Game.MAX_PLAYERS} parameters.
     */
    private void lobbyStateManager (Message message) {
        if (message.getMessageType() == MessageType.PLAYERSNUMBER_REPLY) {
            PlayersNumberResponse messageReceived = (PlayersNumberResponse) message;
            game.setChosenPlayersNumber(messageReceived.getPlayersNumber());
            System.out.println("This game will have " + game.getChosenPlayersNumber() + " players.");
        } else {
            System.out.println("ERROR: Wrong message type (expected: PLAYERS_NUMBER_REPLY, actual: " + message.getMessageType().toString() + ")");
        }
    }

    /**
     * Take actions based on a message arrived in {@code IN_GAME} state.
     * @param message The message received. If the message is a {@code PICK_TILES_REPLY} check the game logic and proceed with
     *                the game.
     */
    private void turnController (Message message) {
        VirtualView currentVirtualView = virtualViewMap.get(getActivePlayer());

        if (message.getMessageType() == MessageType.PICK_TILES_REPLY) {
            if (message.getNickname().equals(getActivePlayer())) {
                PickTilesResponse messageReceived = (PickTilesResponse) message;

                if (game.getPlayerByNickname(getActivePlayer()).getShelf().freeCellsOnColumn(messageReceived.getColumn()) >= messageReceived.getPositionsOfTiles().size()) {
                    // Vi sono sufficienti celle nella shelf. A questo punto controllo che le posizioni coincidano con tessere valide.
                    if (insertTilesInShelf(messageReceived.getPositionsOfTiles(), messageReceived.getColumn())) {
                        checkCommonGoalsCompleted();
                        checkBoardRefillRequested();
                        showGameInformation();
                        if (game.getPlayerByNickname(getActivePlayer()).getShelf().isFull()) {
                            game.getPlayerByNickname(getActivePlayer()).setEndGameToken();
                            if (game.getPlayerByNickname(getNextPlayer()).isFirstPlayer()) {
                                setGameState(GameState.END_GAME);
                                broadcastMessage(getActivePlayer() + " completed his shelf and " +
                                        getNextPlayer() + " is the first player: the game ends!");
                                terminateGame();
                            } else {
                                setGameState(GameState.LAST_LAP);
                                broadcastMessage(getActivePlayer() + " completed his shelf. Last lap starts now!");
                                newTurn();
                            }
                        } else {
                            newTurn();
                        }
                    } else {
                        currentVirtualView.showGenericMessage("There was a problem during the insertion: maybe " +
                                "positions are not valid or the column hasn't got enough cells!");
                        showGameInformation(getActivePlayer());
                        askActivePlayerColumnAndPosition();
                    }
                } else {
                    currentVirtualView.showGenericMessage("There aren't enough free cells on the selected column!");
                    askActivePlayerColumnAndPosition();
                }

            } else {
                System.out.println("ERROR: Message from the wrong client (expected: " + getActivePlayer() + ", actual: " + message.getNickname() + ")");
            }
        } else {
            System.out.println("ERROR: Wrong message type (expected: PICK_TILES, actual: " + message.getMessageType().toString() + ")");
        }
    }

    /**
     * Take actions based on a message arrived in {@code LAST_LAP} state.
     * @param message The message received.
     */
    private void lastLapStateManager (Message message) {
        VirtualView currentVirtualView = virtualViewMap.get(getActivePlayer());
        if (message.getMessageType() == MessageType.PICK_TILES_REPLY) {
            if (message.getNickname().equals(getActivePlayer())) {
                PickTilesResponse messageReceived = (PickTilesResponse) message;

                if (game.getPlayerByNickname(getActivePlayer()).getShelf().freeCellsOnColumn(messageReceived.getColumn()) >= messageReceived.getPositionsOfTiles().size()) {
                    // Vi sono sufficienti celle nella shelf. A questo punto controllo che le posizioni coincidano con tessere valide.
                    if (insertTilesInShelf(messageReceived.getPositionsOfTiles(), messageReceived.getColumn())) {
                        showGameInformation();
                        checkCommonGoalsCompleted();
                        checkBoardRefillRequested();
                        if (game.getPlayerByNickname(getNextPlayer()).isFirstPlayer()) {
                            setGameState(GameState.END_GAME);
                            broadcastMessage("Next player has the chair: the game finishes!");
                            terminateGame();
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
                    askActivePlayerColumnAndPosition();
                }

            } else {
                System.out.println("ERROR: Message from the wrong client (expected: " + activePlayer + ", actual: " + message.getNickname() + ")");
            }
        } else {
            System.out.println("ERROR: Wrong message type (expected: PICK_TILES, actual: " + message.getMessageType().toString() + ")");
        }
    }

    /**
     * Take actions based on a message arrived in {@code END_GAME} state.
     * @param message The message received.
     */
    private void endGameStateManager (Message message) {
        // TODO: this method doesn't have a body: fill it or delete it.
    }

    /**
     * This method terminates the game: for each player total score is computed and after that sends a message
     * to all the players containing the score board. After this, the game is resetted to the initial state, the
     * file containing the stored match is deleted and a message is sent to all the clients.
     */
    private void terminateGame () {
        for (Player player : game.getPlayers()) {
            player.addScore(player.getShelf().pointsFromAdjacencies());     // Aggiungi i punti delle adiacenze
            player.addScore(player.getPersonalGoalCard().pointsFromGoals(player.getPersonalGoalCard().goalsSatisfied(player.getShelf())));  // Aggiungi gli obiettivi personali
            if (player.hasEndGameToken()) {
                player.addScore(1);     // Points from the end game token
            }
        }

        Map <String, Integer> scoreMap = new HashMap<>();
        Map <String, Integer> sortedScoreMap = new LinkedHashMap<>();
        List <Integer> scoreList = new ArrayList<>();

        for (Player player : game.getPlayers()) {
            scoreMap.put(player.getNickname(), player.getScore());
        }
        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            scoreList.add(entry.getValue());
        }
        scoreList.sort(Collections.reverseOrder());
        for (int num : scoreList) {
            for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedScoreMap.put(entry.getKey(), num);
                }
            }
        }
        showScoreBoard(sortedScoreMap);

        Game.resetGameInstance();
        // Delete the stored match
        Persistence persistence = new Persistence();
        persistence.delete();

        broadcastMessage("Game finished! Thanks for playing with us.");
        System.exit(0);
        // sendExitMessage();
    }

    private void sendExitMessage () {
        for (Map.Entry<String, VirtualView> entry : virtualViewMap.entrySet()) {

        }
    }

    /* ---------- LOGIN HANDLER ---------- */
    /**
     * Handles the login of a new player. Requires to be in {@code LOBBY_STATE} state, so the client connected represents
     * a new player.
     * Creates the corresponding player and associates the virtual view and the player to the nickname passed as parameter.
     * If the players connected are the same number of the chosen players number, starts the game.
     * @param nickname The nickname of the new player.
     * @param virtualView The virtual view of the new player.
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
            virtualView.waitingRoom();
            broadcastMessage("Players connected: " + virtualViewMap.size() + "/" + game.getChosenPlayersNumber());
            if (getOnlinePlayers().size() == game.getChosenPlayersNumber()) {
                broadcastMessage("All the players are connected.");

                Persistence persistence = new Persistence();
                GameController savedGameController = persistence.restore();

                if (savedGameController != null &&
                        this.getNicknameOfAllPlayer().containsAll(savedGameController.getNicknameOfAllPlayer()) &&
                        savedGameController.getNicknameOfAllPlayer().containsAll(this.getNicknameOfAllPlayer())) {
                    for (Map.Entry<String, VirtualView> entry : virtualViewMap.entrySet()){
                        entry.getValue().switchToGameRoom();
                    }
                    showPlayersNicknames();
                    System.out.println("Restoring match from \"" + Persistence.SAVED_MATCH_FILENAME + "\"");
                    restorePreviousGame(savedGameController);
                    showGameInformation();

                    System.out.println("From the saved game, active player is " + savedGameController.activePlayer);

                    setActivePlayer(savedGameController.getActivePlayer());
                    broadcastMessage("Turn of " + getActivePlayer());
                    askActivePlayerColumnAndPosition();
                } else {
                    startGame();
                }
            }
        }
    }

    private void restorePreviousGame (GameController previousGame) {
        // Ripristino:
        // [OK] In GameController: gameState, activePlayer, gameSuspended
        // In Game: numberOfPlayers, listOfPlayers, board, bag, cgc
        // In Player: shelf, pgc, nickname, score, firstplayer, fcgc, scgc, endGameToken, onlinePlayer
        this.gameState = previousGame.gameState;
        this.activePlayer = previousGame.activePlayer;
        this.gameSuspended = previousGame.gameSuspended;
        System.out.println("Game State: " + this.gameState + ", active player: " + this.activePlayer + ", susp: " + this.gameSuspended);

        this.game.restorePreviousGame(previousGame.game);
    }

    /**
     * Handles the reconnection of a client that was disconnected.
     * Requires that exists a player with the same nickname and the game state is {@code IN_GAME} or {@code LAST_LAP}.
     * Associates the nickname passed as parameter with the corresponding virtual view, then: if there are at least
     * two online players, the game can continue.
     * @param nickname The nickname of the reconnected player.
     * @param virtualView The virtual view of the reconnected player.
     */
    public void handleReconnection (String nickname, VirtualView virtualView) {
        addVirtualView(nickname, virtualView);
        game.getPlayerByNickname(nickname).setOnlinePlayer(true);
        broadcastMessage("Player reconnected: " + nickname);
        showGameInformation();
        if (virtualViewMap.size() == 2) {
            // Game can continue because there are two online players.
            gameSuspended = false;
            newTurn();
        }
    }


    /**
     * This method checks if the nickname passed as parameter is a valid nickname.
     * @param nickname The nickname that will be checked.
     * @param virtualView The virtual view of the client (useful for notifying the result).
     * @return {@code true} if "nickname" is a valid nickname, {@code false} otherwise.
     */
    public boolean checkNicknameAvailability (String nickname, VirtualView virtualView) {
        if (nickname == null || nickname.isEmpty() || nickname.equalsIgnoreCase("SERVER")) {
            virtualView.showGenericMessage("Forbidden name.");
            return false;
        }
        if (game.isNicknameTaken(nickname)) {
            virtualView.showGenericMessage("Nickname already in use by another player.");
            return false;
        }
        return true;
    }

    /* ---------- TURN HANDLING ---------- */
    /**
     * This method returns the next active player (without changing it in the game).
     * @return The name of the next active player.
     */
    private String getNextPlayer () {
        Player player = game.getPlayerByNickname(getActivePlayer());
        int indexOfPlayer = game.getPlayers().indexOf(player);
        do {
            indexOfPlayer++;
            if (indexOfPlayer == game.getPlayers().size())
                indexOfPlayer = 0;
        } while (!game.getPlayers().get(indexOfPlayer).isOnlinePlayer());
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
        broadcastMessage("Turn of " + getActivePlayer());

        Persistence persistence = new Persistence(this);
        persistence.store();

        askActivePlayerColumnAndPosition();
    }

    /* ---------- VIRTUAL VIEW METHODS ---------- */
    /**
     * This method returns the virtual view map.
     * @return The virtual view map.
     */
    public Map<String, VirtualView> getVirtualViewMap() {
        return virtualViewMap;
    }

    /**
     * This method associates the {@code nickname} (key) with the {@code virtualView} (value).
     * @param nickname The nickname of the player.
     * @param virtualView The virtual view of the player.
     */
    public void addVirtualView (String nickname, VirtualView virtualView) {
        this.virtualViewMap.put(nickname, virtualView);
    }

    /**
     * This method removes the virtual view of the client with {@code nickname} specified, only if it is correctly mapped
     * on the virtual view map.
     * @param nickname The nickname of the client that will be removed.
     * @param virtualView The virtual view of the client that will be removed.
     */
    public void removeVirtualView (String nickname, VirtualView virtualView){
        this.virtualViewMap.remove(nickname, virtualView);
    }

    /* ---------- UTILITY METHODS ---------- */
    /**
     * This method starts the game.
     */
    private void startGame () {
        for (Map.Entry<String, VirtualView> entry : virtualViewMap.entrySet()){
            entry.getValue().switchToGameRoom();
        }

        setGameState(GameState.IN_GAME);
        game.startGame();
        System.out.println("Game starting with " + game.getPlayers().size() + " players.");
        showPlayersNicknames();
        showGameInformation();
        broadcastMessage("Game Started");

        setActivePlayer(chooseRandomPlayer());                          // Choose the first player
        game.getPlayerByNickname(getActivePlayer()).setFirstPlayer();   // Set the active player as the first one.
        broadcastMessage("Turn of " + getActivePlayer());

        askActivePlayerColumnAndPosition();
    }

    private void showPlayersNicknames () {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            if (virtualView != null) {
                virtualView.showPlayersList(getNicknameOfAllPlayer());
            }
        }
    }

    private List<String> getNicknameOfAllPlayer () {
        return game.getPlayers().stream()
                .map(Player::getNickname)
                .collect(Collectors.toList());
    }

    /**
     * This method is used to show to each player:
     * - The game board
     * - The shelf of each player
     * - The common goal cards
     * - The player's personal goal card
     */
    private void showGameInformation () {
        showBoard();
        showShelfOfEachPlayer();
        showCommonGoalCards();
        showPersonalGoalCards();
    }

    private void showGameInformation (String nickname) {
        VirtualView virtualView = virtualViewMap.get(nickname);
        showBoard(virtualView);
        showShelfOfEachPlayer(virtualView);
        showCommonGoalCards(virtualView);
        showPersonalGoalCards(nickname);
    }

    /**
     * This method shows to each player the updated board content.
     */
    private void showBoard () {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            if (virtualView != null) {
                virtualView.showBoardContent(game.getBoard().getBoardContentCopy());
            }
        }
    }

    /**
     * Show to the player with the specified {@code VirtualView} passed as parameter the Board
     * @param virtualView
     */
    private void showBoard (VirtualView virtualView) {
        if (virtualView != null) {
            virtualView.showBoardContent(game.getBoard().getBoardContentCopy());
        }
    }

    /**
     * This method shows to each player the shelf content of every player.
     */
    private void showShelfOfEachPlayer () {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            for (Player playerShelf : game.getPlayers()) {
                if (virtualView != null) {
                    virtualView.showPlayerInformation(
                            playerShelf.getNickname(),
                            playerShelf.getShelf().getShelfContentCopy(),
                            playerShelf.getFirstCommonGoal(),
                            playerShelf.getSecondCommonGoal(),
                            playerShelf.hasEndGameToken());
                }
            }
        }
    }

    /**
     *
     * @param virtualView
     */
    private void showShelfOfEachPlayer (VirtualView virtualView) {
        if (virtualView != null) {
            for (Player playerShelf : game.getPlayers()) {
                virtualView.showPlayerInformation(
                        playerShelf.getNickname(),
                        playerShelf.getShelf().getShelfContentCopy(),
                        playerShelf.getFirstCommonGoal(),
                        playerShelf.getSecondCommonGoal(),
                        playerShelf.hasEndGameToken());
            }
        }
    }

    /**
     * Sends a message to each player sending a copy of each {@code CommonGoalCard}.
     */
    private void showCommonGoalCards () {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            if (virtualView != null) {
                for (CommonGoalCard commonGoalCard : game.getCommonGoalCards()) {
                    virtualView.showCommonGoalCard(commonGoalCard, game.getCommonGoalCards().indexOf(commonGoalCard) + 1);
                }
            }
        }
    }

    /**
     *
     * @param virtualView
     */
    private void showCommonGoalCards (VirtualView virtualView) {
        if (virtualView != null) {
            for (CommonGoalCard commonGoalCard : game.getCommonGoalCards()) {
                virtualView.showCommonGoalCard(commonGoalCard, game.getCommonGoalCards().indexOf(commonGoalCard) + 1);
            }
        }
    }

    /**
     * Sends a message to each player with a copy of the corresponding {@code PersonalGoalCard}.
     */
    private void showPersonalGoalCards () {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            if (virtualView != null) {
                virtualView.showPersonalGoalCard(player.getPersonalGoalCard(), player.getNickname());
            }
        }
    }

    private void showPersonalGoalCards (String nickname) {
        Player player = game.getPlayerByNickname(nickname);
        VirtualView virtualView = virtualViewMap.get(nickname);
        if (player != null && virtualView != null) {
            virtualView.showPersonalGoalCard(player.getPersonalGoalCard(), player.getNickname());
        }
    }

    /**
     * Sends a message to each player with the final score board.
     * @param scoreBoardMap The {@code Map} containing the score board.
     */
    private void showScoreBoard (Map<String, Integer> scoreBoardMap) {
        for (Player player : game.getPlayers()) {
            VirtualView virtualView = virtualViewMap.get(player.getNickname());
            if (virtualView != null) {
                virtualView.showScoreBoard(scoreBoardMap);
            }
        }
    }

    /**
     * This method sends a text message to each client.
     * @param messageString The text message to be sent.
     */
    public void broadcastMessage (String messageString) {
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
     * and it reach it now; then the score of the player is updated and the related points are associated to the player.
     */
    private void checkCommonGoalsCompleted () {
        Player activePlayerModel = game.getPlayerByNickname(getActivePlayer());
        CommonGoalCard commonGoalCard = game.getCommonGoalCards().get(0);
        int score;

        // Controllo del primo obiettivo comune
        if (!activePlayerModel.isFirstCommonGoalReached() && commonGoalCard.checkPattern(activePlayerModel.getShelf())) {
            try {
                ScoringToken token = commonGoalCard.popScoringToken();
                activePlayerModel.setFirstCommonGoalReached(token);
                score = token.score();
                broadcastMessage( activePlayer + " earned " + score + " points completing the first common goal!");
                activePlayerModel.addScore(score);
            } catch (NoScoringTokenAvailableException e) {
                System.out.println(e.getMessage());
            }
        }

        // Controllo del secondo obiettivo comune
        commonGoalCard = game.getCommonGoalCards().get(1);
        if (!activePlayerModel.isSecondCommonGoalReached() && commonGoalCard.checkPattern(activePlayerModel.getShelf())) {
            try {
                ScoringToken token = commonGoalCard.popScoringToken();
                activePlayerModel.setSecondCommonGoalReached(token);
                score = token.score();
                broadcastMessage( activePlayer + " earned " + score + " points completing the second common goal!");
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
            broadcastMessage("Proceeding with board refill...");
            showBoard();
        }
    }

    public void setPlayerOffline (String nickname) {
        virtualViewMap.remove(nickname);
        if (game.getPlayerByNickname(nickname) != null) {
            game.getPlayerByNickname(nickname).setOnlinePlayer(false);
        }
        if (game.getOnlinePlayersNumber() == 1) {
            gameSuspended = true;
            broadcastMessage("Game suspended: there's only " + game.getOnlinePlayersNumber() + " player connected.");
        } else {
            if (nickname.equals(activePlayer) && (gameState.equals(GameState.IN_GAME) || gameState.equals(GameState.LAST_LAP))) {
                // If the player disconnected is not the current player, starts a new turn anyway!
                broadcastMessage("Since " + nickname + " is disconnected, the next player is: " + getNextPlayer());
                newTurn();
            }
        }
    }

    /* ---------- GETTERS & SETTERS ---------- */
    /**
     * @return The current state of the game.
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * @param gameState The new state of the game.
     */
    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * @return A string containing the name of the current active player.
     */
    public String getActivePlayer() {
        return activePlayer;
    }

    /**
     * This method sets the name of the current active player with the value passed as parameter if it exists.
     * @param nickname The name of the current active player.
     */
    public void setActivePlayer (String nickname) {
        Player player = game.getPlayerByNickname(nickname);
        if (player != null && player.isOnlinePlayer()) {
            this.activePlayer = nickname;
        }
    }

    /**
     * @return {@code true} if the game is actually suspended, {@code false} otherwise.
     */
    public boolean isGameSuspended() {
        return gameSuspended;
    }

    /**
     * @return A list of the online players' nicknames.
     */
    public List<String> getOnlinePlayers () {
        return game.getPlayers().stream()
                .filter(Player::isOnlinePlayer)
                .map(Player::getNickname)
                .collect(Collectors.toList());
    }

    /**
     * @return A list of the offline players' nicknames.
     */
    public List<String> getOfflinePlayers () {
        return game.getPlayers().stream()
                .filter(player -> !player.isOnlinePlayer())
                .map(Player::getNickname)
                .collect(Collectors.toList());
    }

    /**
     * Remove the player with the nickname passed as parameter from the player's list if it exists.
     * @param nickname The nickname of the player to be removed.
     */
    public void removePlayer (String nickname) {
        Player playerToRemove = game.getPlayerByNickname(nickname);
        if (playerToRemove != null) {
            game.getPlayers().remove(playerToRemove);
        } else {
            System.out.println("Can't remove the player " + nickname + " because it doesn't exist!");
        }
    }
}
