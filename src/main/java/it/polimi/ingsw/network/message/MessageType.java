package it.polimi.ingsw.network.message;

/**
 * This class represents all the possible message types between a client and server.
 */
public enum MessageType {
    // Fase iniziale di gioco
    LOGIN_REQUEST,
    LOGIN_REPLY,
    PLAYERS_NUMBER_REQUEST,
    WAITING_ROOM_REQUEST,
    GAME_ROOM_REQUEST,
    PLAYERSNUMBER_REPLY,

    // Fase di gioco
    PICK_TILES_REQUEST,
    PICK_TILES_REPLY,
    PLAYER_INFORMATION,
    BOARD_CONTENT,
    COMMON_GOAL_CARD,
    PERSONAL_GOAL_CARD,
    SCORE_BOARD,

    // Utility
    GENERIC_MESSAGE,
    ERROR_MESSAGE,
    PING_MESSAGE,
    PLAYERS_LIST
}
