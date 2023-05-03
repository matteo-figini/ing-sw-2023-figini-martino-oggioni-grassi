package it.polimi.ingsw.model;

import java.io.Serializable;

/**
 * This enumeration represents the status of the board cell type.
 * Status can be: NOT PLAYABLE and PLAYABLE.
 */
public enum BoardCellType implements Serializable {
    NOT_PLAYABLE,
    PLAYABLE;
}