package it.polimi.ingsw;

import it.polimi.ingsw.exception.NotEnoughCellsException;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class ShelfTest {
    private Shelf shelf;
    private Shelf shelf1;
    private Shelf shelf2;
    private ShelfCell[][] shelfContent;
    private ShelfCell[][] shelfContent1;
    private ShelfCell[][] shelfContent2;

    private List<ItemTile> tilesList;

    int column;

    @BeforeEach
    void setUpPointsFromAdjacenciesTest(){
        this.shelf = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for(int i=0; i<6; i++){
            for(int j=0; j<5;j++){
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.PINK));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.LIGHTBLUE));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.LIGHTBLUE));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.LIGHTBLUE));

        shelf.setShelfContent(shelfContent);
    }

    @BeforeEach
    void setUpPointsFromAdjacenciesTest2(){
        this.shelf2 = new Shelf();
        this.shelfContent2 = new ShelfCell[6][5];
        for(int i=0; i<6; i++){
            for(int j=0; j<5;j++){
                shelfContent2[i][j] = new ShelfCell();
            }
        }

        shelfContent2[5][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[5][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent2[5][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent2[5][1].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent2[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent2[4][4].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent2[4][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent2[4][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[4][1].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent2[4][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent2[3][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent2[3][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[3][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[3][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent2[3][0].setTile(new ItemTile(ItemTileType.PINK));

        shelfContent2[2][4].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent2[2][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent2[2][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent2[2][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent2[2][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent2[1][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[1][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[1][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent2[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent2[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent2[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent2[0][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent2[0][1].setTile(new ItemTile(ItemTileType.YELLOW));
        // shelfContent2[0][0].setTile(new ItemTile(ItemTileType.LIGHTBLUE));

        shelf2.setShelfContent(shelfContent2);
    }

    @Test
    void pointsFromAdjacenciesTest2(){
        Assertions.assertEquals(16,shelf2.pointsFromAdjacencies());
    }

    @Test
    void pointsFromAdjacenciesTest(){
        Assertions.assertEquals(15,shelf.pointsFromAdjacencies());
    }

    @BeforeEach
    void setUpInsertCards(){
        column = 1;
        this.tilesList = new ArrayList<>();
        this.shelf1 = new Shelf();
        this.shelfContent1 = new ShelfCell[6][5];

        for(int i=0; i<6; i++){
            for(int j=0; j<5;j++){
                shelfContent1[i][j] = new ShelfCell();
            }
        }

        shelfContent1[5][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent1[5][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent1[5][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent1[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent1[5][0].setTile(new ItemTile(ItemTileType.PINK));

        shelfContent1[4][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent1[4][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent1[4][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent1[4][1].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent1[4][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent1[3][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent1[3][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent1[3][2].setTile(new ItemTile(ItemTileType.YELLOW));
        //shelfContent1[3][1].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent1[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        //shelfContent1[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent1[2][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent1[2][2].setTile(new ItemTile(ItemTileType.BLUE));
        //shelfContent1[2][1].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent1[2][0].setTile(new ItemTile(ItemTileType.LIGHTBLUE));

        //shelfContent1[1][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent1[1][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent1[1][2].setTile(new ItemTile(ItemTileType.BLUE));
        //shelfContent1[1][1].setTile(new ItemTile(ItemTileType.PINK));
        //shelfContent1[1][0].setTile(new ItemTile(ItemTileType.LIGHTBLUE));

        //shelfContent1[0][4].setTile(new ItemTile(ItemTileType.GREEN));
        //shelfContent1[0][3].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent1[0][2].setTile(new ItemTile(ItemTileType.BLUE));
        //shelfContent1[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        //shelfContent1[0][0].setTile(new ItemTile(ItemTileType.LIGHTBLUE));

        shelf1.setShelfContent(shelfContent1);

        tilesList.add(new ItemTile(ItemTileType.GREEN));
        tilesList.add(new ItemTile(ItemTileType.BLUE));
        tilesList.add(new ItemTile(ItemTileType.PINK));
    }

    @Test
    void insertCardsTest() throws NotEnoughCellsException{

        System.out.println("PRE-INSERT");
        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(shelfContent1[i][j].getTile()!=null)
                    System.out.println(" " + i + ";" + j + " " + shelfContent1[i][j].getTile().getItemTileType());
                else
                    System.out.println(" " + i + ";" + j + " " + shelfContent1[i][j].getTile());
            }
        }

        shelf1.insertCards(tilesList,column);

        System.out.println("POST-INSERT");
        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(shelfContent1[i][j].getTile()!=null)
                    System.out.println(" " + i + ";" + j + " " + shelfContent1[i][j].getTile().getItemTileType());
                else
                    System.out.println(" " + i + ";" + j + " " + shelfContent1[i][j].getTile());
            }
        }
    }
}

