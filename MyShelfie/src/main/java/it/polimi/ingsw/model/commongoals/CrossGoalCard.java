package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.*;

// TODO: testare l'algoritmo di controllo delle carte per CrossGoalCard
public class CrossGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public CrossGoalCard(int numPlayers) {
        super(numPlayers, "Cinque tessere dello stesso tipo che formano una X.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        for (int i = 0; i < Shelf.ROWS - 2; i++) {
            for (int j = 0; j < Shelf.COLUMNS - 2; j++) {
                if (!shelf.getShelfContent()[i][j].isFree() &&
                        !shelf.getShelfContent()[i+1][j+1].isFree() &&
                        shelf.getShelfContent()[i+1][j+1].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType() &&
                        !shelf.getShelfContent()[i+2][j+2].isFree() &&
                        shelf.getShelfContent()[i+2][j+2].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType() &&
                        !shelf.getShelfContent()[i][j+2].isFree() &&
                        shelf.getShelfContent()[i][j+2].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType() &&
                        !shelf.getShelfContent()[i+2][j].isFree() &&
                        shelf.getShelfContent()[i+2][j].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType()) {
                    return true;
                }
            }
        }
        return false;
    }


}
