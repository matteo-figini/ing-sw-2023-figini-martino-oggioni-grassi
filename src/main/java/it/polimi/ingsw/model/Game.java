package it.polimi.ingsw.model;

import it.polimi.ingsw.exception.WrongNumberOfCardsException;
import it.polimi.ingsw.model.commongoals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: da revisionare

// TODO: singleton pattern?
/**
 * This class represents all the game in terms of player, board and all the model.
 * It can be useful as an entry point for the controller.
 */
public class Game {
    private static Game gameInstance;   // Default instance for the game (singleton pattern applied).
    final static public int MIN_PLAYERS = 2;
    final static public int MAX_PLAYERS = 4;

    private int numberOfPlayers;    // This attribute represents the chosen number of players for the game.
    private boolean lastLap;    // This attribute is 'true' whether the game is at the last lap, 'false' otherwise.
    private final List<Player> players;   // This list represents the players in the game.
    private Board board;    // This attribute represents the board of the game.
    private final Bag bagTiles;    // This attribute represents the bag with the item tiles.
    private final List<CommonGoalCard> commonGoalCards;   // This list represents the (two) common goal cards in the game.

    // TODO: istanziare la board una volta che il numero di giocatori è chiaro!

    /**
     * This method apply the singleton pattern to this class.
     * @return The instance of the game.
     */
    public static Game getGameInstance () {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    /**
     * Default constructor is private due to singleton pattern applied. It instantiates all the necessary elements for
     * the Game.
     */
    private Game () {
        this.lastLap = false;
        this.players = new ArrayList<>();
        this.bagTiles = new Bag();
        this.commonGoalCards = new ArrayList<>();
    }



    /**
     * This method creates a new player instance based on the nickname passed as parameter and add it to the players list.
     * @param nickname The nickname of the player. Requires that is not null.
     */
    public void addPlayer (String nickname) {
        Player newPlayer = new Player(nickname);
        this.players.add(newPlayer);
    }


    public void addCommonGoalCard(CommonGoalCard commonGoalCard){
        this.commonGoalCards.add(commonGoalCard);
    }

    /**
     * This method indicates if it is the last lap of the match.
     * @return A boolean indicating if it is the last lap.
     */
    public boolean isLastLap() {
        return lastLap;
    }

    /**
     * This method sets the attribute "lastLap" to true, so it means that this is the final lap of the match.
     * Ensures that isLastLap() returns true.
     */
    public void setLastLap () {
        this.lastLap = true;
    }

    /**
     * Returns the instance of the player with the nickname specified as parameter if it exists, otherwise it returns null.
     * @param nickname The nickname of the desired player. Requires that is not null.
     * @return A reference to the desired player if it exists, otherwise null.
     */
    public Player getPlayerByNickname (String nickname) {
        for (Player player : players) {
            if (player.getNickname().equals(nickname)) {
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
        assert players.size() >= MIN_PLAYERS && players.size() <= MAX_PLAYERS;

        this.board = new Board(players.size());
        this.refillBoardFromBag();
        assignsCommonGoalCards();
        assignsPersonalGoalCards();
    }

    /**
     * This method checks if this turn is the last one because of one player fills completely his shelf.
     * @return A boolean value indicating if this turn is the last one.
     */
    public boolean checkLastLapCondition () {
        if (!lastLap) {
            for (Player player : players) {
                if (player.getShelf().isFull()) {
                    lastLap = true;
                    break;
                }
            }
        }
        return lastLap;
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
        assert numbers.size() == numCards;
        for (Integer num : numbers) {
            CommonGoalCard commonGoalCard;
            if (num == 1) {
                commonGoalCard = new TwoSquaresGoalCard(players.size());
            } else if (num == 2) {
                commonGoalCard = new TwoColumnsGoalCard(players.size());
            } else if (num == 3) {
                commonGoalCard = new FourLinesFourGoalCard(players.size());
            } else if (num == 4) {
                commonGoalCard = new SixCouplesGoalCard(players.size());
            } else if (num == 5) {
                commonGoalCard = new ThreeColumnsGoalCard(players.size());
            } else if (num == 6) {
                commonGoalCard = new TwoRowsGoalCard(players.size());
            } else if (num == 7) {
                commonGoalCard = new FourRowsGoalCard(players.size());
            } else if (num == 8) {
                commonGoalCard = new FourCornersGoalCard(players.size());
            } else if (num == 9) {
                commonGoalCard = new EightEqualsGoalCard(players.size());
            } else if (num == 10) {
                commonGoalCard = new CrossGoalCard(players.size());
            } else if (num == 11) {
                commonGoalCard = new DiagonalFiveGoalCard(players.size());
            } else {
                commonGoalCard = new TriangleGoalCard(players.size());
            }
            commonGoalCards.add(commonGoalCard);
        }
        assert commonGoalCards.size() == numCards;
    }

    /**
     * This method assigns all the personal goal cards to the players. It ensures that each player has got a different
     * personal goal card as in the real game.
     */
    public void assignsPersonalGoalCards () {
        List<Integer> numbers = getDifferentRandomNumbersInRange(players.size(), 1, PersonalGoalCard.values().length);
        assert numbers != null && numbers.size() == players.size();

        for (Player player : players) {
            PersonalGoalCard card;
            if (numbers.get(0) == 1) {
                card = PersonalGoalCard.PERSONAL_1;
            } else if (numbers.get(0) == 2) {
                card = PersonalGoalCard.PERSONAL_2;
            } else if (numbers.get(0) == 3) {
                card = PersonalGoalCard.PERSONAL_3;
            } else if (numbers.get(0) == 4) {
                card = PersonalGoalCard.PERSONAL_4;
            } else if (numbers.get(0) == 5) {
                card = PersonalGoalCard.PERSONAL_5;
            } else if (numbers.get(0) == 6) {
                card = PersonalGoalCard.PERSONAL_6;
            } else if (numbers.get(0) == 7) {
                card = PersonalGoalCard.PERSONAL_7;
            } else if (numbers.get(0) == 8) {
                card = PersonalGoalCard.PERSONAL_8;
            } else if (numbers.get(0) == 9) {
                card = PersonalGoalCard.PERSONAL_9;
            } else if (numbers.get(0) == 10) {
                card = PersonalGoalCard.PERSONAL_10;
            } else if (numbers.get(0) == 11) {
                card = PersonalGoalCard.PERSONAL_11;
            } else {
                card = PersonalGoalCard.PERSONAL_12;
            }
            player.setPersonalGoalCard(card);
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
        Random random = new Random();     // SecureRandom reduce the possibility of generating repeated values.

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
}