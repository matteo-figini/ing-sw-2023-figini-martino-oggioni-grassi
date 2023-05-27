package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;
import it.polimi.ingsw.model.Shelf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This enumeration represents the personal goal cards.
 * There are 12 distinct personal goal cards in the game, so this enumeration can have 12 possible instances.
 * Every instance of the enumeration reimplements the method that check how many goals are satisfied.
 */
public abstract class PersonalGoalCard implements Serializable {
    private int number;
    protected Map <Position, ItemTileType> schema;

    /**
     * The default constructor initializes the Map containing positions of goals.
     */
    public PersonalGoalCard () {
        schema = new HashMap<>();
    }

    /**
     * This method checks how many goals are satisfied on the shelf passed as parameter.
     * @param shelf The player's shelf. Requires that shelf is not null.
     * @return The number of the goals satisfied. Ensures that is an integer value between 0 and 6.
     */
    public int goalsSatisfied (Shelf shelf) {
        int goalsSatisfied = 0;
        for (Map.Entry <Position, ItemTileType> mapElement : schema.entrySet()) {
            int i = mapElement.getKey().getX();
            int j = mapElement.getKey().getY();
            if (!shelf.getShelfContent()[i][j].isFree() && shelf.getShelfContent()[i][j].getTile().getItemTileType() == mapElement.getValue())
                goalsSatisfied++;
        }
        return goalsSatisfied;
    }

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

    public Map<Position, ItemTileType> getSchema() {
        return schema;
    }

    public int getNumber() {
        return number;
    }
}