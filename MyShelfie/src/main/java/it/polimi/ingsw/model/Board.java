package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.List;

public class Board{
    private BoardCell[][] boardContent;
    private int freeCellsOnBoard;

    /**
     * This constructor creates all the board cells depending on how many players are there.
     * @param numPlayer the number of the players in the game.
     */
    public Board (int numPlayer){
        boardContent = new BoardCell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardContent[i][j] = new BoardCell(BoardCellType.NOT_PLAYABLE);
            }
        }
        /* TODO: il metodo della scimmia per inizializzare le caselle funziona relativamente.
            Si potrebbe migliorare l'implementazione, ad esempio, inserendo i dati di configurazione in un file. */
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


    public BoardCell[][] getBoardContent() {
        return boardContent;
    }

    /**
     * Refills the board with the tiles specified in the list passed as parameter.
     * @param tiles the tiles to put in the board.
     * @return the number of the tiles inserted.
     */
    public int refillBoard (List<ItemTile> tiles){
        int numOfTilesInserted = 0;
        ItemTile tile;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
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
    public List<ItemTile> pickUpCards(List<Position> positions) {
        // TODO: lanciare eccezione nel caso in cui le celle specificate non siano corrette (es. non ci sono lati liberi nelle celle).
        BoardCell cell;
        List<ItemTile> tilesPickedUp = new ArrayList<>();
        for (int pos = 0; pos < positions.size(); pos++) {
            cell = boardContent[positions.get(pos).getX()][positions.get(pos).getY()];
            if (cell.isPlayable() && !cell.isFree()) {
                tilesPickedUp.add(cell.getItemTile());
                cell.freeCell();
            }
        }
        return tilesPickedUp;
    }

    /**
     * Checks if a complete filling is required.
     * @return a boolean indicating if filling is required.
     */
    public boolean fillingRequired() {
        boolean required = true;
        for (int i = 0; i < 9 && required; i++) {
            for (int j = 0; j < 9 && required; j++) {
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
     * @param position
     * @return
     */
    private int freeSides (Position position) {
        int sides = 0;
        // Controllo della cella "in alto"
        if (position.getX() > 0
                && boardContent[position.getX() - 1][position.getY()].isPlayable()
                && boardContent[position.getX() - 1][position.getY()].isFree()) {
            sides++;
        }
        // Controllo della cella "in basso"
        if (position.getX() < 8
                && boardContent[position.getX() + 1][position.getY()].isPlayable()
                && boardContent[position.getX() + 1][position.getY()].isFree()) {
            sides++;
        }
        // Controllo della cella "a sinistra"
        if (position.getY() > 0
                && boardContent[position.getX()][position.getY() - 1].isPlayable()
                && boardContent[position.getX()][position.getY() - 1].isFree()) {
            sides++;
        }
        // Controllo della cella "a destra"
        if (position.getY() < 8
                && boardContent[position.getX()][position.getY() + 1].isPlayable()
                && boardContent[position.getX()][position.getY() + 1].isFree()) {
            sides++;
        }
        return sides;
    }

    /**
     * This method counts the number of playable sides around a specified cell
     * @param position indicates the coordinates of the cell in the board
     * @return the number of playable sides
     */
    private int playableSide (Position position) {
        int playable = 0;
        // Controllo della cella "in alto"
        if (position.getX() > 0
                && boardContent[position.getX() - 1][position.getY()].isPlayable()) {
            playable++;
        }
        // Controllo della cella "in basso"
        if (position.getX() < 8
                && boardContent[position.getX() + 1][position.getY()].isPlayable()) {
            playable++;
        }
        // Controllo della cella "a sinistra"
        if (position.getY() > 0
                && boardContent[position.getX()][position.getY() - 1].isPlayable()) {
            playable++;
        }
        // Controllo della cella "a destra"
        if (position.getY() < 8
                && boardContent[position.getX()][position.getY() + 1].isPlayable()) {
            playable++;
        }
        return playable;
    }
}