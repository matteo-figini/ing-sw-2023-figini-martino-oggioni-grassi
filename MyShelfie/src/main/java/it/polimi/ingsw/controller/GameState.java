package it.polimi.ingsw.controller;

/**
 * This enumeration represents all the possible game states.
 */
public enum GameState {
    LOBBY_STATE,    // First state, while waiting the players.
    IN_GAME,        // During the game
    LAST_LAP,       // During the last lap of the game
    END_GAME        // During the end of the game
}
