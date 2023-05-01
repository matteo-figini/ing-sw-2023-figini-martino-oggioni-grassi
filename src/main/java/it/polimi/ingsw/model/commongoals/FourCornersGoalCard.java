package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.Shelf;

// TODO: testare l'algoritmo di controllo delle carte per FourCornersGoalCard
public class FourCornersGoalCard extends CommonGoalCard {

    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public FourCornersGoalCard(int numPlayers) {
        super(numPlayers, "Quattro tessere dello stesso tipo ai quattro angoli della libreria.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        return !shelf.getShelfContent()[0][0].isFree() &&
                !shelf.getShelfContent()[Shelf.ROWS - 1][0].isFree() &&
                !shelf.getShelfContent()[Shelf.ROWS - 1][Shelf.COLUMNS - 1].isFree() &&
                !shelf.getShelfContent()[0][Shelf.COLUMNS - 1].isFree() &&
                shelf.getShelfContent()[Shelf.ROWS - 1][0].getTile().getItemTileType() == shelf.getShelfContent()[0][0].getTile().getItemTileType() &&
                shelf.getShelfContent()[Shelf.ROWS - 1][Shelf.COLUMNS - 1].getTile().getItemTileType() == shelf.getShelfContent()[0][0].getTile().getItemTileType() &&
                shelf.getShelfContent()[0][Shelf.COLUMNS - 1].getTile().getItemTileType() == shelf.getShelfContent()[0][0].getTile().getItemTileType();
    }
}
