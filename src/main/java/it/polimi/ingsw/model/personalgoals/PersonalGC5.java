package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC5 extends PersonalGoalCard {

    /**
     * Construct the schema for the fifth {@code PersonalGoalCard}.
     */
    public PersonalGC5 () {
        super(5);
        schema.put(new Position(5, 0), ItemTileType.YELLOW);
        schema.put(new Position(3, 1), ItemTileType.BLUE);
        schema.put(new Position(5, 3), ItemTileType.GREEN);
        schema.put(new Position(3, 2), ItemTileType.WHITE);
        schema.put(new Position(4, 4), ItemTileType.PINK);
        schema.put(new Position(1, 1), ItemTileType.LIGHTBLUE);
    }
}
