package it.polimi.ingsw;

import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.TwoSquaresGoalCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoSquaresGoalCardTest {

    private Shelf correctShelf;
    private Shelf uncorrectShelf;
    private TwoSquaresGoalCard card = new TwoSquaresGoalCard(2);
    private ShelfCell[][] shelfContent;


    @BeforeEach
    void setupCorrectShelf(){
        //setup della shelf corretta da passare come parametro
        this.correctShelf = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for(int i=0; i<6; i++){
            for(int j=0; j<5;j++){
                shelfContent[i][j] = new ShelfCell();
            }
        }

        // Initialize every cell in the matrix

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.YELLOW));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.BLUE));

        /*shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.PINK));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.PINK));*/

        correctShelf.setShelfContent(shelfContent);
    }

    @BeforeEach
    void setupUncorrectShelf(){
        //setup della shelf scorretta da passare come parametro
        this.uncorrectShelf = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for(int i=0; i<6; i++){
            for(int j=0; j<5;j++){
                shelfContent[i][j] = new ShelfCell();
            }
        }

        // Initialize every cell in the matrix

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.PINK));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.BLUE));

        uncorrectShelf.setShelfContent(shelfContent);
    }

    //in input una shelf con il pattern corretto da verificare
    @Test
    void checkPatternTestTrue(){

        Assertions.assertTrue(card.checkPattern(correctShelf));
    }

    //in input una shelf con il pattern incorretto da verificare
    @Test
    void checkPatternTestFalse(){

        Assertions.assertFalse(card.checkPattern(uncorrectShelf));
    }
}