package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.Shelf;

public class DiagonalFiveGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public DiagonalFiveGoalCard(int numPlayers) {
        super(numPlayers, "Cinque tessere dello stesso tipo che formano una diagonale.", 11);
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        return startDescendingDiagonalFrom(shelf, 0) || startDescendingDiagonalFrom(shelf, 1) ||
                startAscendingDiagonalFrom(shelf, Shelf.ROWS - 1) || startAscendingDiagonalFrom(shelf, Shelf.ROWS - 2);
    }

    // TODO: add Javadoc for the method
    private boolean startDescendingDiagonalFrom (Shelf shelf, int i) {
        if (shelf.getShelfContent()[i + 1][1].isFree() ||
                shelf.getShelfContent()[i + 2][2].isFree() ||
                shelf.getShelfContent()[i + 3][3].isFree() ||
                shelf.getShelfContent()[i + 4][4].isFree())
            return false;
        return !shelf.getShelfContent()[i + 1][1].isFree() && shelf.getShelfContent()[i + 1][1].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i + 2][2].isFree() && shelf.getShelfContent()[i + 2][2].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i + 3][3].isFree() && shelf.getShelfContent()[i + 3][3].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i + 4][4].isFree() && shelf.getShelfContent()[i + 4][4].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType();
    }

    // TODO: add Javadoc for the method
    private boolean startAscendingDiagonalFrom (Shelf shelf, int i) {
        if (shelf.getShelfContent()[i - 1][1].isFree() ||
                shelf.getShelfContent()[i - 2][2].isFree() ||
                shelf.getShelfContent()[i - 3][3].isFree() ||
                shelf.getShelfContent()[i - 4][4].isFree())
            return false;
        return !shelf.getShelfContent()[i - 1][1].isFree() && shelf.getShelfContent()[i - 1][1].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i - 2][2].isFree() && shelf.getShelfContent()[i - 2][2].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i - 3][3].isFree() && shelf.getShelfContent()[i - 3][3].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i - 4][4].isFree() && shelf.getShelfContent()[i - 4][4].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType();
    }
}
