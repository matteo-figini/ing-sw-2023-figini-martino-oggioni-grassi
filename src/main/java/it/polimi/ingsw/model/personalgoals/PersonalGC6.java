package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC6 extends PersonalGoalCard {

    /**
     * Construct the schema for the 6th {@code PersonalGoalCard}.
     */
    public PersonalGC6 () {
        super(6);
        schema.put(new Position(4, 1), ItemTileType.YELLOW);
        schema.put(new Position(4, 3), ItemTileType.BLUE);
        schema.put(new Position(0, 4), ItemTileType.GREEN);
        schema.put(new Position(2, 3), ItemTileType.WHITE);
        schema.put(new Position(5, 0), ItemTileType.PINK);
        schema.put(new Position(0, 2), ItemTileType.LIGHTBLUE);
    }
}
