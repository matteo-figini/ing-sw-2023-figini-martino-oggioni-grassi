package it.polimi.ingsw;

import it.polimi.ingsw.exception.WrongPositionsException;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class BoardTest {

    Board board1;
    Board board2;
    Board board3;
    Board board4;

    BoardCell[][] boardContent1;

    BoardCell[][] boardContent2;
    BoardCell[][] boardContent3;
    BoardCell[][] boardContent4;
    List<ItemTile> tiles;

    List<Position> positions = new ArrayList<>();

    List<ItemTile> tilesPickedUp = new ArrayList<>();

    int numPlayer = 4;

    Position nofreesides;
    Position onefreeside;
    Position twofreesides;
    Position threefreesides;
    Position fourfreesides;

    //TODO: da completare

    @BeforeEach
    void setUpRefillBoardTest(){
        this.board1 = new Board(numPlayer);
        this.boardContent1 = new BoardCell[9][9];
        this.tiles = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9;j++){
                boardContent1[i][j] = new BoardCell(BoardCellType.NOT_PLAYABLE);
            }
        }

        //imposto PLAYABLE le celle della board in base al numero di giocatori
        if (numPlayer >= 2) {
            boardContent1[1][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[1][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[2][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[2][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[2][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[6][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[6][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[6][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[7][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[7][5] = new BoardCell(BoardCellType.PLAYABLE);
        }
        if (numPlayer >= 3) {
            boardContent1[0][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[2][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[2][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[6][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[6][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[8][5] = new BoardCell(BoardCellType.PLAYABLE);
        }
        if (numPlayer >= 4) {
            boardContent1[0][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[1][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[3][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[4][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[5][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[7][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent1[8][4] = new BoardCell(BoardCellType.PLAYABLE);
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
        boardContent1[3][6].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent1[4][7].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent1[7][5].addItemTile(new ItemTile(ItemTileType.WHITE));

        board1.setBoardContent(boardContent1);
    }

    @Test
    void refillBoardTest(){

        System.out.println("PRE-REFILL");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(boardContent1[i][j].getItemTile()!=null)
                    System.out.println(" " + i + ";" + j + " " + boardContent1[i][j].getItemTile().getItemTileType());
                else
                    System.out.println(" " + i + ";" + j + " " + boardContent1[i][j].getItemTile());
            }
        }

        //2 players
        if(numPlayer==2)
            Assertions.assertEquals(26, board1.refillBoard(tiles));
        //3 players
        if(numPlayer==3)
            Assertions.assertEquals(34, board1.refillBoard(tiles));
        //4 players
        if(numPlayer==4)
            Assertions.assertEquals(42, board1.refillBoard(tiles));

        System.out.println("POST-REFILL");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(boardContent1[i][j].getItemTile()!=null)
                    System.out.println(" " + i + ";" + j + " " + boardContent1[i][j].getItemTile().getItemTileType());
                else
                    System.out.println(" " + i + ";" + j + " " + boardContent1[i][j].getItemTile());
            }
        }
    }

   @BeforeEach
    void setUpPlayableSideTest(){
        if(numPlayer==2){
            nofreesides = new Position(0,0);
            onefreeside = new Position(1,2);
            twofreesides = new Position(1,3);
            threefreesides = new Position(2,3);
            fourfreesides = new Position(2,4);
        }
       if(numPlayer==3){
           nofreesides = new Position(7,1);
           onefreeside = new Position(7,2);
           twofreesides = new Position(2,2);
           threefreesides = new Position(1,3);
           fourfreesides = new Position(6,5);
       }
       if(numPlayer==4){
           nofreesides = new Position(1,7);
           onefreeside = new Position(0,2);
           twofreesides = new Position(0,5);
           threefreesides = new Position(3,7);
           fourfreesides = new Position(4,7);
       }

       this.board2 = new Board(numPlayer);
       this.boardContent2 = new BoardCell[9][9];

       for(int i=0; i<9; i++){
           for(int j=0; j<9;j++){
               boardContent2[i][j] = new BoardCell(BoardCellType.NOT_PLAYABLE);
           }
       }

       //imposto PLAYABLE le celle della board in base al numero di giocatori
       if (numPlayer >= 2) {
           boardContent2[1][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[1][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[2][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[2][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[2][5] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][2] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][5] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][6] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][7] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][1] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][2] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][5] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][6] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][7] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][1] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][2] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][5] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][6] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[6][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[6][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[6][5] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[7][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[7][5] = new BoardCell(BoardCellType.PLAYABLE);
       }
       if (numPlayer >= 3) {
           boardContent2[0][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[2][2] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[2][6] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][8] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][0] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[6][2] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[6][6] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[8][5] = new BoardCell(BoardCellType.PLAYABLE);
       }
       if (numPlayer >= 4) {
           boardContent2[0][4] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[1][5] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[3][1] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][0] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[4][8] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[5][7] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[7][3] = new BoardCell(BoardCellType.PLAYABLE);
           boardContent2[8][4] = new BoardCell(BoardCellType.PLAYABLE);
       }

       board2.setBoardContent(boardContent2);
    }

    @Test
    void playableSideTest(){
        Assertions.assertEquals(4,board2.playableSide(fourfreesides));
        Assertions.assertEquals(3,board2.playableSide(threefreesides));
        Assertions.assertEquals(2,board2.playableSide(twofreesides));
        Assertions.assertEquals(1,board2.playableSide(onefreeside));
        Assertions.assertEquals(0,board2.playableSide(nofreesides));
    }

    @BeforeEach
    void setUpPickUpCardsTest(){

        positions.add( new Position(4,4));
        positions.add( new Position(4,5));
        positions.add( new Position(5,5));


        this.board3 = new Board(numPlayer);
        this.boardContent3 = new BoardCell[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9;j++){
                boardContent3[i][j] = new BoardCell(BoardCellType.NOT_PLAYABLE);
            }
        }

        //imposto PLAYABLE le celle della board in base al numero di giocatori
        if (numPlayer >= 2) {
            boardContent3[1][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[1][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[2][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[2][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[2][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[6][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[6][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[6][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[7][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[7][5] = new BoardCell(BoardCellType.PLAYABLE);
        }
        if (numPlayer >= 3) {
            boardContent3[0][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[2][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[2][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[6][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[6][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[8][5] = new BoardCell(BoardCellType.PLAYABLE);
        }
        if (numPlayer >= 4) {
            boardContent3[0][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[1][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[3][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[4][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[5][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[7][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent3[8][4] = new BoardCell(BoardCellType.PLAYABLE);
        }

        boardContent3[5][5].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent3[4][4].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent3[4][5].addItemTile(new ItemTile(ItemTileType.WHITE));

        board3.setBoardContent(boardContent3);


    }

    @Test
    void pickUpCardsTest() throws WrongPositionsException {

        tilesPickedUp = board3.pickUpCards(positions);

        System.out.println("Posizioni: ");
        for(int i=0; i<tilesPickedUp.size();i++){
            System.out.println(" " + tilesPickedUp.get(i).getItemTileType());
        }

    }

    @BeforeEach
    void setUpFillingRequiredTest(){
        board4 = new Board(numPlayer);

        this.boardContent4 = new BoardCell[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9;j++){
                boardContent4[i][j] = new BoardCell(BoardCellType.NOT_PLAYABLE);
            }
        }

        //imposto PLAYABLE le celle della board in base al numero di giocatori
        if (numPlayer >= 2) {
            boardContent4[1][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[1][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[2][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[2][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[2][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[6][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[6][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[6][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[7][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[7][5] = new BoardCell(BoardCellType.PLAYABLE);
        }
        if (numPlayer >= 3) {
            boardContent4[0][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[2][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[2][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[6][2] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[6][6] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[8][5] = new BoardCell(BoardCellType.PLAYABLE);
        }
        if (numPlayer >= 4) {
            boardContent4[0][4] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[1][5] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[3][1] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][0] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[4][8] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[5][7] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[7][3] = new BoardCell(BoardCellType.PLAYABLE);
            boardContent4[8][4] = new BoardCell(BoardCellType.PLAYABLE);
        }

        //caso TRUE
        /*boardContent[1][3].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent[3][7].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent[6][5].addItemTile(new ItemTile(ItemTileType.WHITE));*/

        //caso FALSE
        boardContent4[5][5].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent4[5][4].addItemTile(new ItemTile(ItemTileType.WHITE));
        boardContent4[3][6].addItemTile(new ItemTile(ItemTileType.WHITE));

        board4.setBoardContent(boardContent4);
    }

    @Test
    void FillingRequiredTest(){
        //caso TRUE
        //Assertions.assertTrue(board4.fillingRequired());

        //caso FALSE
        Assertions.assertFalse(board4.fillingRequired());

    }
}
