package it.polimi.ingsw.model.commongoals;

import it.polimi.ingsw.model.CommonGoalCard;
import it.polimi.ingsw.model.Shelf;

// TODO: testare l'algoritmo di controllo delle carte per TriangleGoalCard
public class TriangleGoalCard extends CommonGoalCard {
    /**
     * Constructor that takes in input the number of the players and set the specific stack for scoring tokens.
     * @param numPlayers The number of the players; depending on the value of this parameter, a different scoring token stack is initialized.
     */
    public TriangleGoalCard(int numPlayers) {
        super(numPlayers, "Cinque colonne di altezza crescente o decrescente: a partire dalla prima colonna a sinistra o a destra, " +
                "ogni colonna successiva deve essere formata da una tessera in più. " +
                "Le tessere possono essere di qualsiasi tipo.");
    }

    @Override
    public boolean checkPattern(Shelf shelf) {
        return (checkAscending(shelf) || checkDescending(shelf));
    }

    private boolean checkAscending (Shelf shelf) {
        for (int j = 0; j < Shelf.COLUMNS - 1; j++) {
            if (shelf.freeCellsOnColumn(j) != shelf.freeCellsOnColumn(j+1) - 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDescending (Shelf shelf) {
        for (int j = 0; j < Shelf.COLUMNS - 1; j++) {
            if (shelf.freeCellsOnColumn(j) != shelf.freeCellsOnColumn(j+1) + 1) {
                return false;
            }
        }
        return true;
    }
}
