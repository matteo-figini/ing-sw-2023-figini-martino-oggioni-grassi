package it.polimi.ingsw;

import it.polimi.ingsw.exception.WrongNumberOfCardsException;
import it.polimi.ingsw.model.Bag;
import it.polimi.ingsw.model.ItemTile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class BagTest {

    private Bag bag;
    private List<ItemTile> returnTilesList;
    int numb = 40;


    @BeforeEach
    void setUp(){
        this.bag = new Bag();
        this.returnTilesList = new ArrayList<>();
    }

    @Test
    void drawTilesTest() throws WrongNumberOfCardsException {

        returnTilesList = bag.drawTiles(numb);
        for(int i=0; i<returnTilesList.size(); i++){
            System.out.println(" " + returnTilesList.get(i).getItemTileType());
        }
    }
}
