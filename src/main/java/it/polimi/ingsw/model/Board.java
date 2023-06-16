package it.polimi.ingsw.model;

import it.polimi.ingsw.exception.WrongPositionsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represent a board game with his content.
 */
public class Board implements Serializable {
    /** Matrix of {@code BoardCell} as the content of the board. */
    private BoardCell[][] boardContent;

    /** Number of free cells on the board. */
    private int freeCellsOnBoard;

    /** Maximum number of rows in the matrix of {@code BoardCell}. */
    final public static int MAX_ROWS = 9;

    /** Maximum number of columns in the matrix of {@code BoardCell}. */
    final public static int MAX_COLUMNS = 9;

    /**
     * This constructor creates all the board cells depending on how many players are there.
     * @param numPlayer the number of the players in the game.
     */
    public Board (int numPlayer) {
        boardContent = new BoardCell[MAX_ROWS][MAX_COLUMNS];
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                boardContent[i][j] = new BoardCell(BoardCellType.NOT_PLAYABLE);
            }
        }

        if (numPlayer >= 2) {
            boardContent[1][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[1][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[2][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[2][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[2][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[6][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[6][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[6][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[7][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[7][5] = new BoardCell(BoardCellType.PLAYABLE);
            freeCellsOnBoard = 29;
        }
        if (numPlayer >= 3) {
            boardContent[0][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[2][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[2][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[6][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[6][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[8][5] = new BoardCell(BoardCellType.PLAYABLE);
            freeCellsOnBoard += 8;
        }
        if (numPlayer >= 4) {
            boardContent[0][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[1][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[3][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[4][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[5][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[7][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent[8][4] = new BoardCell(BoardCellType.PLAYABLE);
            freeCellsOnBoard += 8;
        }
    }

    /**
     * Returns the number of the free cells on board.
     * It can be useful when a refill is mandatory, to know how many cards put in.
     * @return the number of the free cells on board.
     */
    public int getFreeCellsOnBoard() {
        return freeCellsOnBoard;
    }

    /**
     * @return A reference to the board content.
     */
    public BoardCell[][] getBoardContent() {
        return boardContent;
    }

    /**
     * Return a matrix representing a copy of the board content.
     * Since {@code ItemTile} is an immutable class, the item tile contained (if exists) is the same reference to the
     * original one, while the board cell is a copy since {@code BoardCell} is not an immutable class.
     * @return A matrix representing a copy of the board content.
     */
    public BoardCell[][] getBoardContentCopy () {
        BoardCell[][] boardCopy = new BoardCell[MAX_ROWS][MAX_COLUMNS];
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                boardCopy[i][j] = new BoardCell(boardContent[i][j].getType());
                if (boardContent[i][j].isPlayable() && !boardContent[i][j].isFree())
                    boardCopy[i][j].addItemTile(boardContent[i][j].getItemTile());
            }
        }
        return boardCopy;
    }

    /**
     * Set the board content to the specified board content passed as parameter.
     * @param boardContent The matrix of {@code BoardCell} containing the board.
     */
    public void setBoardContent(BoardCell[][] boardContent) {
        this.boardContent = boardContent;
    }

    /**
     * Refills the board with the tiles specified in the list passed as parameter.
     * @param tiles the tiles to put in the board.
     * @return the number of the tiles inserted.
     */
    public int refillBoard (List<ItemTile> tiles){
        int numOfTilesInserted = 0;
        ItemTile tile;
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                if (boardContent[i][j].isPlayable() && boardContent[i][j].isFree() && tiles.size() > 0) {
                    tile = tiles.remove(0);
                    boardContent[i][j].addItemTile(tile);
                    numOfTilesInserted++;
                }
            }
        }
        return numOfTilesInserted;
    }

    /**
     * Returns the list of item tiles in the positions specified by the parameter and remove them from the board.
     * @param positions Positions in the board where to take the cards. Requires that all the coordinates are inside the board.
     * @return Cards picked up from the board.
     */
    public List<ItemTile> pickUpCards(List<Position> positions) throws WrongPositionsException {
        BoardCell cell;
        List<ItemTile> tilesPickedUp = new ArrayList<>();
        if (!correctPositionsOfTiles(positions)) {
            throw new WrongPositionsException();
        }
        for (Position position : positions) {
            cell = boardContent[position.x()][position.y()];
            if (cell.isPlayable() && !cell.isFree()) {
                tilesPickedUp.add(cell.getItemTile());
                cell.removeItemTile();
            }
        }
        return tilesPickedUp;
    }

    /**
     * This method checks that the list of the positions passed as parameter satisfies the conditions specified by the game rules.
     * More specifically, there are some conditions to verify:
     * 1) Positions in the list must exist in the board and there is a tile in each position.
     * 2) Positions must be aligned and adjacent (see {@code alignedAndClosePositions()} for further details.
     * 3) Each tile in the position specified must have at least one free side.
     * @param positions The list of the positions specified by parameter
     * @return A boolean indicating if the requirements are satisfied.
     */
    private boolean correctPositionsOfTiles (List<Position> positions) {
        for (Position pos : positions) {
            if (pos.x() < 0 || pos.x() >= MAX_ROWS || pos.y() < 0 || pos.y() >= MAX_COLUMNS ||
                    boardContent[pos.x()][pos.y()].isFree() ||
                    !boardContent[pos.x()][pos.y()].isPlayable()) {
                return false;
            }
        }
        if (!alignedAndClosePositions(positions)) {
            return false;
        }
        for (Position pos : positions) {
            if (pos.x() > 0 && pos.x() < MAX_ROWS-1 && pos.y() > 0 && pos.y() < MAX_COLUMNS-1 &&
                playableSide(pos) == 4 && freeSides(pos) == 0)
                return false;
        }
        return true;
    }

    /**
     * Checks if a complete filling is required.
     * @return a boolean indicating if filling is required.
     */
    public boolean fillingRequired() {
        boolean required = true;
        for (int i = 0; i < MAX_ROWS && required; i++) {
            for (int j = 0; j < MAX_COLUMNS && required; j++) {
                if (boardContent[i][j].isPlayable() && !boardContent[i][j].isFree() &&
                    freeSides(new Position(i, j)) != playableSide(new Position(i, j))) {
                    required = false;
                }
            }
        }
        return required;
    }

    /**
     * This method checks the number of the free (and playable) sides around the cell specified by the parameter.
     * @param position The position on the board to check.
     * @return The number of free sides around the position passed as parameter.
     */
    private int freeSides (Position position) {
        int sides = 0;
        // Controllo della cella "in alto"
        if (position.x() > 0
                && boardContent[position.x() - 1][position.y()].isPlayable()
                && boardContent[position.x() - 1][position.y()].isFree()) {
            sides++;
        }
        // Controllo della cella "in basso"
        if (position.x() < MAX_ROWS-1
                && boardContent[position.x() + 1][position.y()].isPlayable()
                && boardContent[position.x() + 1][position.y()].isFree()) {
            sides++;
        }
        // Controllo della cella "a sinistra"
        if (position.y() > 0
                && boardContent[position.x()][position.y() - 1].isPlayable()
                && boardContent[position.x()][position.y() - 1].isFree()) {
            sides++;
        }
        // Controllo della cella "a destra"
        if (position.y() < MAX_COLUMNS-1
                && boardContent[position.x()][position.y() + 1].isPlayable()
                && boardContent[position.x()][position.y() + 1].isFree()) {
            sides++;
        }
        return sides;
    }

    /**
     * This method counts the number of playable sides around a specified cell
     * @param position indicates the coordinates of the cell in the board
     * @return the number of playable sides
     */
    public int playableSide(Position position) {
        int playable = 0;
        // Controllo della cella "in alto"
        if (position.x() > 0
                && boardContent[position.x() - 1][position.y()].isPlayable()) {
            playable++;
        }
        // Controllo della cella "in basso"
        if (position.x() < MAX_ROWS-1
                && boardContent[position.x() + 1][position.y()].isPlayable()) {
            playable++;
        }
        // Controllo della cella "a sinistra"
        if (position.y() > 0
                && boardContent[position.x()][position.y() - 1].isPlayable()) {
            playable++;
        }
        // Controllo della cella "a destra"
        if (position.y() < MAX_COLUMNS-1
                && boardContent[position.x()][position.y() + 1].isPlayable()) {
            playable++;
        }
        return playable;
    }

    /**
     * This method checks that the specified positions passed by parameter are:
     * -) on the same row and in adjacent columns, or:
     * -) on the same column and in adjacent rows.
     * @param positions The positions to check.
     * @return A boolean indicating if the list of positions specified as parameter contains aligned and adjacent positions.
     * Ensures that the list passed as parameter is not edited by the method.
     */
    private boolean alignedAndClosePositions (final List<Position> positions) {
        boolean alignedTilesForRow = true;
        boolean alignedTilesForCol = true;

        for (int i = 0; i < positions.size() - 1 && alignedTilesForRow; i++) {
            if (positions.get(i).x() != positions.get(i + 1).x()) {
                alignedTilesForRow = false;
            }
        }
        if (alignedTilesForRow) {
            // Ordinamento per colonna
            List<Position> positionsAlignedForCol = new ArrayList<>(positions);
            Collections.sort (positionsAlignedForCol, (p1, p2) -> {
                if (p1.y() < p2.y()) return -1;
                else if (p1.y() > p2.y()) return 1;
                else return 0;
            });

            for (int i = 0; i < positionsAlignedForCol.size() - 1 && alignedTilesForRow; i++) {
                if (positionsAlignedForCol.get(i).y() != positionsAlignedForCol.get(i + 1).y() - 1) {
                    alignedTilesForRow = false;
                }
            }
        }

        if (!alignedTilesForRow) {
            for (int i = 0; i < positions.size() - 1 && alignedTilesForCol; i++) {
                if (positions.get(i).y() != positions.get(i + 1).y()) {
                    alignedTilesForCol = false;
                }
            }
            if (alignedTilesForCol) {
                // Ordinamento per colonna
                List<Position> positionsAlignedForCol = new ArrayList<>(positions);
                Collections.sort (positionsAlignedForCol, (p1, p2) -> {
                    if (p1.x() < p2.x()) return -1;
                    else if (p1.x() > p2.x()) return 1;
                    else return 0;
                });

                for (int i = 0; i < positionsAlignedForCol.size() - 1 && alignedTilesForCol; i++) {
                    if (positionsAlignedForCol.get(i).x() + 1 != positionsAlignedForCol.get(i + 1).x()) {
                        alignedTilesForCol = false;
                    }
                }
            }
        }
        return (alignedTilesForRow || alignedTilesForCol);
    }
}