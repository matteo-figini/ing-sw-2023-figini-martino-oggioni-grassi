package it.polimi.ingsw;

import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.ShelfCell;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import it.polimi.ingsw.model.Shelf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;


import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ShelfTest {

    Shelf shelf[][];

    private ShelfCell[][] shelfContent;


    @BeforeEach
    void setup(){
        this.shelf=new Shelf();
        this.shelfContent = new ShelfCell[6][5];
        shelf[6][5] = ItemTileType.BLUE;

    }

    @Test
    void clearShelfTest(){

    }

    @ParameterizedTest
    @Test
    void insertCardsTest(List<ItemTile> cards, int column){
        int firstRowAvailable = 3;

    }

    static Stream<Arguments> insertCards(){
        return Stream.of(
                arguments(ItemTileType.GREEN, 3)
        );
    }

}
