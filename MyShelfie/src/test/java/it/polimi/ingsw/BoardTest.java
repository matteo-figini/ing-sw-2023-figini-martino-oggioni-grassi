package it.polimi.ingsw;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.ItemTile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class BoardTest {

    Board board;

    BoardCell[][] boardContent;
    List<ItemTile> tiles;

    //TODO: da completare

    @BeforeEach
    void setUp(){
        int numPlayer = 4;
        this.board = new Board(numPlayer);
        this.boardContent = new BoardCell[9][9];
        this.tiles = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9;j++){
                boardContent[i][j] = new BoardCell(BoardCellType.NOT_PLAYABLE);
            }
        }

        //imposto PLAYABLE le celle della board in base al numero di giocatori
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
        }

        //inserisco nella lista le tiles da aggiungere in base al numero di player
        // (totale celle PLAYABLE della board - celle già presenti sulla board)
        if (numPlayer >= 2){
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.YELLOW));
            tiles.add(new ItemTile(ItemTileType.YELLOW));
            tiles.add(new ItemTile(ItemTileType.YELLOW));
            tiles.add(new ItemTile(ItemTileType.YELLOW));
            tiles.add(new ItemTile(ItemTileType.YELLOW));
            tiles.add(new ItemTile(ItemTileType.YELLOW));
            tiles.add(new ItemTile(ItemTileType.LIGHTBLUE));
            tiles.add(new ItemTile(ItemTileType.LIGHTBLUE));
            tiles.add(new ItemTile(ItemTileType.LIGHTBLUE));
            tiles.add(new ItemTile(ItemTileType.PINK));
            tiles.add(new ItemTile(ItemTileType.PINK));
            tiles.add(new ItemTile(ItemTileType.PINK));
            tiles.add(new ItemTile(ItemTileType.PINK));
            tiles.add(new ItemTile(ItemTileType.PINK));
            tiles.add(new ItemTile(ItemTileType.PINK));
            tiles.add(new ItemTile(ItemTileType.WHITE));
            tiles.add(new ItemTile(ItemTileType.WHITE));
        }
        if(numPlayer >= 3){
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
        }
        if(numPlayer >= 4){
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.GREEN));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
            tiles.add(new ItemTile(ItemTileType.BLUE));
        }

        //inserire 3 tile nella board disposte in modo che si possa fare il refill
        boardContent[3][6].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent[4][7].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent[7][5].addItemTile(new ItemTile(ItemTileType.WHITE));

        board.setBoardContent(boardContent);
    }

    @Test
    void refillBoardTest(){

        System.out.println("PRE-REFILL");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(boardContent[i][j].getItemTile()!=null)
                    System.out.println(" " + i + ";" + j + " " + boardContent[i][j].getItemTile().getItemTileType());
                else
                    System.out.println(" " + i + ";" + j + " " + boardContent[i][j].getItemTile());
            }
        }

        //2 players
        //Assertions.assertEquals(26, board.refillBoard(tiles));
        //3 players
        //Assertions.assertEquals(34, board.refillBoard(tiles));
        //4 players
        Assertions.assertEquals(42, board.refillBoard(tiles));

        System.out.println("POST-REFILL");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(boardContent[i][j].getItemTile()!=null)
                    System.out.println(" " + i + ";" + j + " " + boardContent[i][j].getItemTile().getItemTileType());
                else
                    System.out.println(" " + i + ";" + j + " " + boardContent[i][j].getItemTile());
            }
        }
    }

}