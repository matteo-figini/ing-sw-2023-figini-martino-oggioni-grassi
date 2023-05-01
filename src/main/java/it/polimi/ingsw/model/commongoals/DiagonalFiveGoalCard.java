package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.Shelf;

// TODO: testare l'algoritmo di controllo delle carte per DiagonalFiveGoalCard
public class DiagonalFiveGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public DiagonalFiveGoalCard(int numPlayers) {
        super(numPlayers, "Cinque tessere dello stesso tipo che formano una diagonale.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        return startDescendingDiagonalFrom(shelf, 0) || startDescendingDiagonalFrom(shelf, 1) ||
                startAscendingDiagonalFrom(shelf, Shelf.ROWS - 1) || startAscendingDiagonalFrom(shelf, Shelf.ROWS - 2);
    }

    private boolean startDescendingDiagonalFrom (Shelf shelf, int i) {
        return !shelf.getShelfContent()[i + 1][1].isFree() && shelf.getShelfContent()[i + 1][1].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i + 2][2].isFree() && shelf.getShelfContent()[i + 2][2].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i + 3][3].isFree() && shelf.getShelfContent()[i + 3][3].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i + 4][4].isFree() && shelf.getShelfContent()[i + 4][4].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType();
    }

    private boolean startAscendingDiagonalFrom (Shelf shelf, int i) {
        return !shelf.getShelfContent()[i - 1][1].isFree() && shelf.getShelfContent()[i - 1][1].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i - 2][2].isFree() && shelf.getShelfContent()[i - 2][2].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i - 3][3].isFree() && shelf.getShelfContent()[i - 3][3].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType() &&
                !shelf.getShelfContent()[i - 4][4].isFree() && shelf.getShelfContent()[i - 4][4].getTile().getItemTileType() == shelf.getShelfContent()[i][0].getTile().getItemTileType();
    }
}
