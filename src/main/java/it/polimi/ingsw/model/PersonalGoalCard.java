package it.polimi.ingsw.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This enumeration represents the personal goal cards.
 * There are 12 distinct personal goal cards in the game, so this enumeration can have 12 possible instances.
 * Every instance of the enumeration reimplements the method that check how many goals are satisfied.
 */
/* TODO: l'implementazione dei metodi specifici di controllo delle carte può essere realizzata anche con strutture apposite,
    ad esempio un file esterno da cui è possibile ricavare le informazioni specifiche per quel pattern e applicarle al codice. */
public enum PersonalGoalCard {
    PERSONAL_1 {
        @Override
        public int goalsSatisfied (Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[0][0].isFree() && shelf.getShelfContent()[0][0].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[0][2].isFree() && shelf.getShelfContent()[0][2].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[1][4].isFree() && shelf.getShelfContent()[1][4].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[2][3].isFree() && shelf.getShelfContent()[2][3].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[3][1].isFree() && shelf.getShelfContent()[3][1].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[5][2].isFree() && shelf.getShelfContent()[5][2].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_2 {
        @Override
        public int goalsSatisfied (Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[1][1].isFree() && shelf.getShelfContent()[1][1].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[5][4].isFree() && shelf.getShelfContent()[5][4].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[2][0].isFree() && shelf.getShelfContent()[2][0].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[3][4].isFree() && shelf.getShelfContent()[3][4].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[2][2].isFree() && shelf.getShelfContent()[2][2].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[4][3].isFree() && shelf.getShelfContent()[4][3].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_3 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[2][2].isFree() && shelf.getShelfContent()[2][2].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[1][0].isFree() && shelf.getShelfContent()[1][0].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[3][1].isFree() && shelf.getShelfContent()[3][1].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[5][0].isFree() && shelf.getShelfContent()[5][0].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[1][3].isFree() && shelf.getShelfContent()[1][3].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[3][4].isFree() && shelf.getShelfContent()[3][4].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_4 {
        @Override
        public int goalsSatisfied (Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[3][3].isFree() && shelf.getShelfContent()[3][3].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[2][2].isFree() && shelf.getShelfContent()[2][2].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[4][2].isFree() && shelf.getShelfContent()[4][2].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[4][1].isFree() && shelf.getShelfContent()[4][1].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[0][4].isFree() && shelf.getShelfContent()[0][4].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[2][0].isFree() && shelf.getShelfContent()[2][0].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_5 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[4][4].isFree() && shelf.getShelfContent()[4][4].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[3][1].isFree() && shelf.getShelfContent()[3][1].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[5][3].isFree() && shelf.getShelfContent()[5][3].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[3][2].isFree() && shelf.getShelfContent()[3][2].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[5][0].isFree() && shelf.getShelfContent()[5][0].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[1][1].isFree() && shelf.getShelfContent()[1][1].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_6 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[5][0].isFree() && shelf.getShelfContent()[5][0].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[4][3].isFree() && shelf.getShelfContent()[4][3].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[0][4].isFree() && shelf.getShelfContent()[0][4].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[2][3].isFree() && shelf.getShelfContent()[2][3].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[4][1].isFree() && shelf.getShelfContent()[4][1].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[0][2].isFree() && shelf.getShelfContent()[0][2].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_7 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[2][1].isFree() && shelf.getShelfContent()[2][1].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[1][3].isFree() && shelf.getShelfContent()[1][3].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[0][0].isFree() && shelf.getShelfContent()[0][0].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[5][2].isFree() && shelf.getShelfContent()[5][2].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[4][4].isFree() && shelf.getShelfContent()[4][4].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[3][0].isFree() && shelf.getShelfContent()[3][0].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_8 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[3][0].isFree() && shelf.getShelfContent()[3][0].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[0][4].isFree() && shelf.getShelfContent()[0][4].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[1][1].isFree() && shelf.getShelfContent()[1][1].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[4][3].isFree() && shelf.getShelfContent()[4][3].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[5][3].isFree() && shelf.getShelfContent()[5][3].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[2][2].isFree() && shelf.getShelfContent()[2][2].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_9 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[4][4].isFree() && shelf.getShelfContent()[4][4].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[5][0].isFree() && shelf.getShelfContent()[5][0].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[2][2].isFree() && shelf.getShelfContent()[2][2].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[3][4].isFree() && shelf.getShelfContent()[3][4].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[0][2].isFree() && shelf.getShelfContent()[0][2].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[4][1].isFree() && shelf.getShelfContent()[4][1].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_10 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[5][3].isFree() && shelf.getShelfContent()[5][3].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[4][1].isFree() && shelf.getShelfContent()[4][1].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[3][3].isFree() && shelf.getShelfContent()[3][3].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[2][0].isFree() && shelf.getShelfContent()[2][0].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[1][1].isFree() && shelf.getShelfContent()[1][1].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[0][4].isFree() && shelf.getShelfContent()[0][4].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_11 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[0][2].isFree() && shelf.getShelfContent()[0][2].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[3][2].isFree() && shelf.getShelfContent()[3][2].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[4][4].isFree() && shelf.getShelfContent()[4][4].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[1][1].isFree() && shelf.getShelfContent()[1][1].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[2][0].isFree() && shelf.getShelfContent()[2][0].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[5][3].isFree() && shelf.getShelfContent()[5][3].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    },

    PERSONAL_12 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            int goals = 0;
            if (!shelf.getShelfContent()[1][1].isFree() && shelf.getShelfContent()[1][1].getTile().getItemTileType() == ItemTileType.PINK)
                goals++;
            if (!shelf.getShelfContent()[2][2].isFree() && shelf.getShelfContent()[2][2].getTile().getItemTileType() == ItemTileType.BLUE)
                goals++;
            if (!shelf.getShelfContent()[5][0].isFree() && shelf.getShelfContent()[5][0].getTile().getItemTileType() == ItemTileType.GREEN)
                goals++;
            if (!shelf.getShelfContent()[0][2].isFree() && shelf.getShelfContent()[0][2].getTile().getItemTileType() == ItemTileType.WHITE)
                goals++;
            if (!shelf.getShelfContent()[4][4].isFree() && shelf.getShelfContent()[4][4].getTile().getItemTileType() == ItemTileType.YELLOW)
                goals++;
            if (!shelf.getShelfContent()[3][3].isFree() && shelf.getShelfContent()[3][3].getTile().getItemTileType() == ItemTileType.LIGHTBLUE)
                goals++;
            return goals;
        }
    };

    /**
     * This abstract method checks how many goals are satisfied based on the shelf passed as parameter.
     * Each instance of the enumeration reimplements the method, based on the specific goals of each card.
     * @param shelf the player's shelf. Requires that shelf is not null.
     * @return the number of the goals satisfied. Ensures that is an integer value between 0 and 6.
     */
    public abstract int goalsSatisfied (Shelf shelf);

    /**
     * This method converts the number of the goals in the corresponding points.
     * @param goals The number of the goals satisfied. Requires that goals is an integer between 0 and 6 (maximum number of goals).
     * @return The corresponding points (a value between 0 and 12).
     */
    public int pointsFromGoals (int goals) {
        Map<Integer, Integer> scoreMap = new HashMap<>();
        scoreMap.put(0, 0);
        scoreMap.put(1, 1);
        scoreMap.put(2, 2);
        scoreMap.put(3, 4);
        scoreMap.put(4, 6);
        scoreMap.put(5, 9);
        scoreMap.put(6, 12);
        return scoreMap.get(goals);
    }
}