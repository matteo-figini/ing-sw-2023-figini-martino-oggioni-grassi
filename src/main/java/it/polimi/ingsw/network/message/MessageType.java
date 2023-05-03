package it.polimi.ingsw.network.message;

/**
 * This class represents all the possible message types between client and server.
 */
public enum MessageType {
    // Fase iniziale di gioco
    LOGIN_REQUEST,
    LOGIN_REPLY,
    PLAYERSNUMBER_REQUEST,
    PLAYERSNUMBER_REPLY,

    // Fase di gioco
    PICK_TILES_REQUEST,
    PICK_TILES_REPLY,
    SHELF_CONTENT,
    BOARD_CONTENT,


    // Utility
    GENERIC_MESSAGE,
    ERROR_MESSAGE,
    PING_MESSAGE
}
