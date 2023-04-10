package it.polimi.ingsw.model;
import it.polimi.ingsw.exception.WrongNumberOfCardsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the bag containing the tiles.
 */
public class Bag {
    private List<ItemTile> itemTileList = new ArrayList<>();
    private final int cardForType = 22;
    private final int typesOfCards = 6;

    /**
     * The default constructor fills the list of the item tiles with 22 cards for each one of the 6 types.
     * After the initialization, cards are shuffled.
     */
    public Bag () {
        for (int i = 0; i < typesOfCards; i++) {
            for (int j = 0; j < cardForType; j++) {
                switch (i) {
                    case 0:
                        itemTileList.add(new ItemTile(ItemTileType.GREEN));
                        break;
                    case 1:
                        itemTileList.add(new ItemTile(ItemTileType.BLUE));
                        break;
                    case 2:
                        itemTileList.add(new ItemTile(ItemTileType.PINK));
                        break;
                    case 3:
                        itemTileList.add(new ItemTile(ItemTileType.LIGHTBLUE));
                        break;
                    case 4:
                        itemTileList.add(new ItemTile(ItemTileType.WHITE));
                        break;
                    case 5:
                        itemTileList.add(new ItemTile(ItemTileType.YELLOW));
                        break;
                }

            }
        }
        this.shuffle();
    }

    /**
     * This method shuffles the cards inside the bag.
     */
    public void shuffle() {
        Collections.shuffle(itemTileList);
    }

    /**
     * Extract a number of the cards from the bag specified by the parameter.
     * @param tilesToExtract the number of the cards that will be extracted from the bag.
     * @return a list of random cards extracted from the bag.
     * @throws WrongNumberOfCardsException in case of the number of the cards to extract is not positive or greater than
     * the available size.
     */
    public List<ItemTile> drawTiles (int tilesToExtract) throws WrongNumberOfCardsException {
        List<ItemTile> tilesList = new ArrayList<>();
        ItemTile tile;
        if (tilesToExtract <= 0 || tilesToExtract > this.availableTiles()) {
            throw new WrongNumberOfCardsException();
        }
        for (int i = 0; i < tilesToExtract; i++) {
            tile = this.itemTileList.remove(0);
            tilesList.add(tile);
        }
        return tilesList;
    }

    /**
     * Returns the number of available tiles inside the bag.
     * @return the number of available tiles inside the bag.
     */
    public int availableTiles(){
        return itemTileList.size();
    }
}