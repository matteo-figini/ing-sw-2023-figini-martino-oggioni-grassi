package it.polimi.ingsw;

import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGC1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains personal goal cards tests.
 * There are 12 distinct personal goal cards in the game.
 * In this class there are seven test methods that test all possible cases.
 */
public class PersonalGoalCardTest {

    //Here you can change PERSONAL_1 with other numbers [1,12] to test all personal goal card patterns
    private final PersonalGoalCard card = new PersonalGC1();

    private Shelf personal6matches;
    private Shelf personal5matches;
    private Shelf personal4matches;
    private Shelf personal3matches;
    private Shelf personal2matches;
    private Shelf personal1matches;
    private Shelf personal0matches;

    private ShelfCell[][] shelfContent;

    @BeforeEach
    void setupPersonal6matchesShelf() {
        this.personal6matches = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.PINK));

        personal6matches.setShelfContent(shelfContent);
    }

    @Test
    void goalsSatisfiedPersona6matches(){

        Assertions.assertEquals(6,card.goalsSatisfied (personal6matches));
    }

    @BeforeEach
    void setupPersonal5matchesShelf() {
        this.personal5matches = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.BLUE));

        personal5matches.setShelfContent(shelfContent);
    }

    @Test
    void goalsSatisfiedPersona5matches(){

        Assertions.assertEquals(5,card.goalsSatisfied (personal5matches));
    }

    @BeforeEach
    void setupPersonal4matchesShelf() {
        this.personal4matches = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.BLUE));

        personal4matches.setShelfContent(shelfContent);
    }

    @Test
    void goalsSatisfiedPersona4matches(){

        Assertions.assertEquals(4,card.goalsSatisfied (personal4matches));
    }

    @BeforeEach
    void setupPersonal3matchesShelf() {
        this.personal3matches = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.BLUE));

        personal3matches.setShelfContent(shelfContent);
    }

    @Test
    void goalsSatisfiedPersonal3matches(){

        Assertions.assertEquals(3,card.goalsSatisfied (personal3matches));
    }

    @BeforeEach
    void setupPersonal2matchesShelf() {
        this.personal2matches = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.BLUE));

        personal2matches.setShelfContent(shelfContent);
    }

    @Test
    void goalsSatisfiedPersonal2matches(){

        Assertions.assertEquals(2,card.goalsSatisfied (personal2matches));
    }

    @BeforeEach
    void setupPersonal1matchesShelf() {
        this.personal1matches = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.BLUE));

        personal1matches.setShelfContent(shelfContent);
    }

    @Test
    void goalsSatisfiedPersonal1matches(){

        Assertions.assertEquals(1,card.goalsSatisfied (personal1matches));
    }

    @BeforeEach
    void setupPersonal0matchesShelf() {
        this.personal0matches = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                shelfContent[i][j] = new ShelfCell();
            }
        }

        shelfContent[5][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[5][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[5][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[4][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][3].setTile(new ItemTile(ItemTileType.LIGHTBLUE));
        shelfContent[4][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[4][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[4][0].setTile(new ItemTile(ItemTileType.BLUE));

        shelfContent[3][4].setTile(new ItemTile(ItemTileType.WHITE));
        shelfContent[3][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[3][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[3][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[2][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][3].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[2][2].setTile(new ItemTile(ItemTileType.YELLOW));
        shelfContent[2][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[2][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[1][4].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][3].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][2].setTile(new ItemTile(ItemTileType.GREEN));
        shelfContent[1][1].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[1][0].setTile(new ItemTile(ItemTileType.GREEN));

        shelfContent[0][4].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][3].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][2].setTile(new ItemTile(ItemTileType.PINK));
        shelfContent[0][1].setTile(new ItemTile(ItemTileType.BLUE));
        shelfContent[0][0].setTile(new ItemTile(ItemTileType.BLUE));

        personal0matches.setShelfContent(shelfContent);
    }

    @Test
    void goalsSatisfiedPersonal0matches(){

        Assertions.assertEquals(0,card.goalsSatisfied (personal0matches));
    }
}
