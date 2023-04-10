package it.polimi.ingsw;

import it.polimi.ingsw.model.ItemTile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import it.polimi.ingsw.model.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardTest {

    Board board;
    List<ItemTile> tiles;

    //TODO: da completare

    @BeforeEach
    void setUp(){
        board = new Board(2);
        //board = new Board(3);
        //board = new Board(4);
        tiles = new ArrayList<>();

        //inserire 3 carte nella board sparse

    }

    //controllare che la refillBoardTest metta le carte nelle posizioni playable che erano disponibili e non altrove
    @Test
    void refillBoardTest(){

        Assertions.assertEquals(26, board.refillBoard(tiles));
    }

}
