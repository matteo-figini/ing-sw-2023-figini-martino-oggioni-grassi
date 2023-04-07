package it.polimi.ingsw;

import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.EightEqualsGoalCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EightEqualsGoalCardTest {

    private Shelf correctShelf;
    private Shelf uncorrectShelf;
    private EightEqualsGoalCard card;
    private ShelfCell[][] shelfContent;


    @BeforeEach
    void setupCorrectShelf(){
        //setup della shelf corretta da passare come parametro
        this.correctShelf = new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        // Initialize every cell in the matrix

        //qui bisogna inizializzare

        correctShelf.setShelfContent(shelfContent);
    }

    @BeforeEach
    void setupUncorrectShelf(){
        //setup della shelf scorretta da passare come parametro
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