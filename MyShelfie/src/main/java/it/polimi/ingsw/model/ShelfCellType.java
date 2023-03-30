package it.polimi.ingsw.model;

/**
 * This enumeration represents all the possible status for a single shelf cell.
 * A single shelf cell can be:
 * -) FREE, if there are no item tiles connected,
 * -) BUSY, if it's not free.
 */
public enum ShelfCellType {
    FREE,
    BUSY
}