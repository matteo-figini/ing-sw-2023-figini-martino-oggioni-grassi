package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC4 extends PersonalGoalCard {
    public PersonalGC4 () {
        super();
        schema.put(new Position(0, 4), ItemTileType.YELLOW);
        schema.put(new Position(2, 2), ItemTileType.BLUE);
        schema.put(new Position(4, 2), ItemTileType.GREEN);
        schema.put(new Position(4, 1), ItemTileType.WHITE);
        schema.put(new Position(3, 3), ItemTileType.PINK);
        schema.put(new Position(2, 0), ItemTileType.LIGHTBLUE);
    }
}
