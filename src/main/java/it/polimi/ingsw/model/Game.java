package it.polimi.ingsw.model;

import it.polimi.ingsw.exception.WrongNumberOfCardsException;
import it.polimi.ingsw.model.commongoals.*;
import it.polimi.ingsw.model.personalgoals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents all the game in terms of player, board and all the model.
 * It can be useful as an entry point for the controller.
 */
public class Game {
    /** Default instance for the game (singleton pattern applied). */
    private static Game gameInstance;

    /** Minimum number of players in the game. */
    final static public int MIN_PLAYERS = 2;

    /** Maximum number of players in the game. */
    final static public int MAX_PLAYERS = 4;

    /** Chosen number of players for the current game. */
    private int numberOfPlayers;

    /** List of the players in the game. */
    private final List<Player> players;

    /** Board of the game. */
    private Board board;

    /** Bag with the item tiles. */
    private final Bag bagTiles;

    /** List of the common goal cards in the game. */
    private final List<CommonGoalCard> commonGoalCards;

    /**
     * Applies the singleton pattern to this class.
     * @return The instance of the game. Ensures that the instance of {@code Game} class is not null.
     */
    public static Game getGameInstance () {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    /**
     * Reset the current game instance.
     * Ensures that the instance of {@code Game} class is null.
     */
    public static void resetGameInstance () {
        gameInstance = null;
    }

    /**
     * Default constructor is private due to singleton pattern applied.
     * It instantiates all the necessary elements for the Game (except for the Board, because it is instantiated only
     * when the current number of players is known).
     */
    private Game () {
        this.players = new ArrayList<>();
        this.bagTiles = new Bag();
        this.commonGoalCards = new ArrayList<>();
    }

    /**
     * Add the {@code CommonGoalCard} passed by parameter to the list of the common goal cards.
     * @param commonGoalCard The common goal card to add in the list.
     */
    public void addCommonGoalCard (CommonGoalCard commonGoalCard) {
        this.commonGoalCards.add(commonGoalCard);
    }

    /**
     * Returns the instance of the player with the nickname specified as parameter if it exists, otherwise it returns null.
     * @param nickname The nickname of the desired player. Requires that is not null.
     * @return A reference to the desired player if it exists, otherwise null.
     */
    public Player getPlayerByNickname (String nickname) {
        for (Player player : players) {
            if (player.getNickname().equalsIgnoreCase(nickname)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Returns true if the nickname specified as parameter is already taken, false otherwise. Since it isn't possible to have
     * two players with the same nickname, it can be useful to check with this method before adding a player.
     * @param nickname The nickname to search. Requires that is not null.
     * @return A boolean that indicates if a player with that nickname already exists.
     */
    public boolean isNicknameTaken (String nickname) {
        return getPlayerByNickname(nickname) != null;
    }

    /**
     * This method prepare the game components after the initialization of the players. In order to start the game,
     * these operations are mandatory:
     * -) Create the board, depending on the number of the players.
     * -) Refill the board from the bag with item tiles.
     * -) Draw & assign 2 common goal cards
     * -) Draw & assign 1 personal goal card for each player.
     */
    public void startGame () {
        this.board = new Board(players.size());
        this.refillBoardFromBag();
        assignsCommonGoalCards();
        assignsPersonalGoalCards();
    }

    /**
     * This method refills the board from the bag. The number of the tiles to move is the minimum value between the number
     * of the free cells on the board and the number of the tiles in the bag.
     * @return The number of the item tiles moved from the bag to the board. A return value of 0 means that a
     * WrongNumberOfCardsException is raised.
     */
    public int refillBoardFromBag () {
        int tilesMoved = 0;
        this.bagTiles.shuffle();
        int tilesToMove = Math.min(board.getFreeCellsOnBoard(), bagTiles.availableTiles());
        try {
            List<ItemTile> tilesExtracted = this.bagTiles.drawTiles(tilesToMove);
            tilesMoved = tilesExtracted.size();
            this.board.refillBoard(tilesExtracted);
        } catch (WrongNumberOfCardsException ex) {
            System.out.println(ex.getMessage());
        }
        return tilesMoved;
    }

    /**
     * This method choose randomly 2 common goal cards from the set of the cards and assigns them to the class attribute.
     * It ensures that the cards generated are different from each other.
     */
    public void assignsCommonGoalCards () {
        int numCards = 2;
        // Genera due numeri casuali compresi tra 1 e 12, che siano diversi tra loro
        List<Integer> numbers = getDifferentRandomNumbersInRange(numCards, 1, 12);
        assert numbers != null;
        for (Integer num : numbers) {
            CommonGoalCard commonGoalCard;
            switch (num) {
                case 1 -> commonGoalCard = new TwoSquaresGoalCard(players.size());
                case 2 -> commonGoalCard = new TwoColumnsGoalCard(players.size());
                case 3 -> commonGoalCard = new FourLinesFourGoalCard(players.size());
                case 4 -> commonGoalCard = new SixCouplesGoalCard(players.size());
                case 5 -> commonGoalCard = new ThreeColumnsGoalCard(players.size());
                case 6 -> commonGoalCard = new TwoRowsGoalCard(players.size());
                case 7 -> commonGoalCard = new FourRowsGoalCard(players.size());
                case 8 -> commonGoalCard = new FourCornersGoalCard(players.size());
                case 9 -> commonGoalCard = new EightEqualsGoalCard(players.size());
                case 10 -> commonGoalCard = new CrossGoalCard(players.size());
                case 11 -> commonGoalCard = new DiagonalFiveGoalCard(players.size());
                default -> commonGoalCard = new TriangleGoalCard(players.size());
            }
            addCommonGoalCard(commonGoalCard);
        }
    }

    /**
     * This method assigns all the personal goal cards to the players. It ensures that each player has got a different
     * personal goal card as in the real game.
     */
    public void assignsPersonalGoalCards () {
        List<Integer> numbers = getDifferentRandomNumbersInRange(players.size(), 1, 12);
        assert numbers != null && numbers.size() == players.size();

        for (Player player : players) {
            PersonalGoalCard card;
            switch (numbers.get(0)) {
                case 1 -> card = new PersonalGC1();
                case 2 -> card = new PersonalGC2();
                case 3 -> card = new PersonalGC3();
                case 4 -> card = new PersonalGC4();
                case 5 -> card = new PersonalGC5();
                case 6 -> card = new PersonalGC6();
                case 7 -> card = new PersonalGC7();
                case 8 -> card = new PersonalGC8();
                case 9 -> card = new PersonalGC9();
                case 10 -> card = new PersonalGC10();
                case 11 -> card = new PersonalGC11();
                default -> card = new PersonalGC12();
            }
            player.setPersonalGoalCard(card);
            numbers.remove(0);
        }
    }

    /**
     * This util method generates a list of "howMany" different random numbers in a range between "min" (inclusive)
     * and "max" (inclusive). If "howMany" parameter is lower than the range specified, it returns null.
     * @param howMany The number of numbers to generate.
     * @param min The minimum value of numbers.
     * @param max The maximum value of numbers.
     * @return A list of integers if "howMany" parameter is greater or equal than the range specified, null otherwise.
     */
    private List<Integer> getDifferentRandomNumbersInRange (int howMany, int min, int max) {
        List<Integer> generatedNumbers = new ArrayList<>();
        Random random = new Random();
        // Se l'intervallo di generazione non è sufficientemente ampio, ritorna errore.
        if ((max - min + 1) < howMany) {
            return null;
        }
        // Genera numeri tra loro diversi e inseriscili nella lista
        // Continua questo processo finché la dimensione della lista è minore del numero di numeri specificati (howMany)
        while (generatedNumbers.size() < howMany) {
            Integer randomNum = random.nextInt(max - min + 1) + 1;
            if (!generatedNumbers.contains(randomNum)) {
                generatedNumbers.add(randomNum);
            }
        }
        return generatedNumbers;
    }

    /* ---------- GETTERS & SETTERS ---------- */
    /**
     * This method returns the list of the players in the game.
     * @return The list of the players in the game.
     */
    public List<Player> getPlayers () {
        return players;
    }

    /**
     * This method creates a new player instance based on the nickname passed as parameter and add it to the players list.
     * @param nickname The nickname of the player. Requires that is not null.
     */
    public void addPlayer (String nickname) {
        Player newPlayer = new Player(nickname);
        this.players.add(newPlayer);
    }

    /**
     * This method returns the chosen number of players in the game.
     * @return The chosen number of players in the game.
     */
    public int getChosenPlayersNumber () {
        return numberOfPlayers;
    }

    /**
     * This method sets the chosen number of players in the game.
     * @param chosenPlayersNumber The desired number of players in the game.
     */
    public void setChosenPlayersNumber (int chosenPlayersNumber) {
        this.numberOfPlayers = chosenPlayersNumber;
    }

    /**
     * This method returns the board in the game.
     * @return The board in the game.
     */
    public Board getBoard () {
        return this.board;
    }

    /**
     * This method returns the bag of the tiles in the game.
     * @return The bag of the tiles in the game.
     */
    public Bag getBagTiles () {
        return this.bagTiles;
    }

    /**
     * Returns the list of the common goal cards in the game.
     * @return The list of the common goal cards in the game.
     */
    public List<CommonGoalCard> getCommonGoalCards () {
        return this.commonGoalCards;
    }

    public Integer getOnlinePlayersNumber () {
        return Math.toIntExact(players.stream().filter(Player::isOnlinePlayer).count());
    }
}