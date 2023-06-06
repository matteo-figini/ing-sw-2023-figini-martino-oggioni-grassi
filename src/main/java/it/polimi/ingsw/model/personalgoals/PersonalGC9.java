package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC9 extends PersonalGoalCard {

    /**
     * Construct the schema for the 9th {@code PersonalGoalCard}.
     */
    public PersonalGC9 () {
        super(9);
        schema.put(new Position(0, 2), ItemTileType.YELLOW);
        schema.put(new Position(5, 0), ItemTileType.BLUE);
        schema.put(new Position(2, 2), ItemTileType.GREEN);
        schema.put(new Position(3, 4), ItemTileType.WHITE);
        schema.put(new Position(4, 4), ItemTileType.PINK);
        schema.put(new Position(4, 1), ItemTileType.LIGHTBLUE);
    }
}
