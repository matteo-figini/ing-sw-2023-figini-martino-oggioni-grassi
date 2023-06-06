package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC12 extends PersonalGoalCard {

    /**
     * Construct the schema for the 12th {@code PersonalGoalCard}.
     */
    public PersonalGC12 () {
        super(12);
        schema.put(new Position(4, 4), ItemTileType.YELLOW);
        schema.put(new Position(2, 2), ItemTileType.BLUE);
        schema.put(new Position(5, 0), ItemTileType.GREEN);
        schema.put(new Position(0, 2), ItemTileType.WHITE);
        schema.put(new Position(1, 1), ItemTileType.PINK);
        schema.put(new Position(3, 3), ItemTileType.LIGHTBLUE);
    }
}