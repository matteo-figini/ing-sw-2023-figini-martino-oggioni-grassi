package it.polimi.ingsw.model;

/**
 * This enumeration represents the personal goal cards.
 * There are 12 distinct personal goal cards in the game, so this enumeration can have 12 possible instances.
 */
// TODO: implementare i metodi specifici di controllo delle carte.
/* TODO: l'implementazione dei metodi specifici di controllo delle carte può essere realizzata anche con strutture apposite,
    ad esempio un file esterno da cui è possibile ricavare le informazioni specifiche per quel pattern e applicarle al codice. */
public enum PersonalGoalCard {
    PERSONAL_1 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_2 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_3 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_4 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_5 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_6 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_7 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_8 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_9 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_10 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_11 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
        }
    },

    PERSONAL_12 {
        @Override
        public int goalsSatisfied(Shelf shelf) {
            return 0;
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
        // TODO: si potrebbe migliorare l'implementazione di questo metodo, ad esempio, con una HashMap.
        int points = 0;
        switch (goals) {
            case 1:
                points = 1;
                break;
            case 2:
                points = 2;
                break;
            case 3:
                points = 4;
                break;
            case 4:
                points = 6;
                break;
            case 5:
                points = 9;
                break;
            case 6:
                points = 12;
                break;
            default:
                // Si dovrebbe finire in questa situazione se e solo se goals = 0.
                // In questo caso, il numero di punti rimane invariato.
        }
        return points;
    }
}