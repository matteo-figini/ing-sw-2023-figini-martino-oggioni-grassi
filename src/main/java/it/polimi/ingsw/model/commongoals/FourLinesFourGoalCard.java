package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.Shelf;

public class FourLinesFourGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public FourLinesFourGoalCard(int numPlayers) {
        super(numPlayers , "Quattro gruppi separati formati ciascuno da quattro tessere adiacenti dello stesso tipo, disposte " + "" +
                "in orizzontale oppure in verticale. Le tessere di un gruppo possono essere diverse da quelle di un altro gruppo.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        int groupsFound = 0;
        char[][] support = new char[Shelf.ROWS][Shelf.COLUMNS];
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                support[i][j] = 'U';
            }
        }

        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                if (!shelf.getShelfContent()[i][j].isFree() && support[i][j] == 'U') {
                    if ((j < Shelf.COLUMNS - 3) && !(shelf.getShelfContent()[i][j + 1].isFree()) &&
                            (shelf.getShelfContent()[i][j + 1].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType()) &&
                            (support[i][j + 1] == 'U') &&
                            !(shelf.getShelfContent()[i][j + 2].isFree()) &&
                            (shelf.getShelfContent()[i][j + 2].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType()) &&
                            (support[i][j + 2] == 'U') &&
                            !(shelf.getShelfContent()[i][j + 3].isFree()) &&
                            (shelf.getShelfContent()[i][j + 3].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType()) &&
                            (support[i][j + 3] == 'U')) {
                        support[i][j + 1] = 'V';
                        support[i][j + 2] = 'V';
                        support[i][j + 3] = 'V';
                        groupsFound++;
                    } else if ((i < Shelf.ROWS - 3) && !(shelf.getShelfContent()[i + 1][j].isFree()) &&
                            (shelf.getShelfContent()[i + 1][j].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType()) &&
                            (support[i + 1][j] == 'U') &&
                            !(shelf.getShelfContent()[i + 2][j].isFree()) &&
                            (shelf.getShelfContent()[i + 2][j].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType()) &&
                            (support[i + 2][j] == 'U') &&
                            !(shelf.getShelfContent()[i + 3][j].isFree()) &&
                            (shelf.getShelfContent()[i + 3][j].getTile().getItemTileType() == shelf.getShelfContent()[i][j].getTile().getItemTileType()) &&
                            (support[i + 3][j] == 'U')) {
                        support[i + 1][j] = 'V';
                        support[i + 2][j] = 'V';
                        support[i + 3][j] = 'V';
                        groupsFound++;
                    }
                }
                support[i][j] = 'V';
            }
        }

        return (groupsFound >= 4);
    }
}
