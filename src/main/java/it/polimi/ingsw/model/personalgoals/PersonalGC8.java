package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC8 extends PersonalGoalCard {

    /**
     * Construct the schema for the first {@code PersonalGoalCard}.
     */
    public PersonalGC8 () {
        super(8);
        schema.put(new Position(5, 3), ItemTileType.YELLOW);
        schema.put(new Position(0, 4), ItemTileType.BLUE);
        schema.put(new Position(1, 1), ItemTileType.GREEN);
        schema.put(new Position(4, 3), ItemTileType.WHITE);
        schema.put(new Position(3, 0), ItemTileType.PINK);
        schema.put(new Position(2, 2), ItemTileType.LIGHTBLUE);
    }
}
