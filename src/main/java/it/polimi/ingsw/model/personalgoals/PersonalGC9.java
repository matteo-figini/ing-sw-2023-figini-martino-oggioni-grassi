package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC9 extends PersonalGoalCard {
    private int number = 9;
    public PersonalGC9 () {
        super();
        schema.put(new Position(0, 2), ItemTileType.YELLOW);
        schema.put(new Position(5, 0), ItemTileType.BLUE);
        schema.put(new Position(2, 2), ItemTileType.GREEN);
        schema.put(new Position(3, 4), ItemTileType.WHITE);
        schema.put(new Position(4, 4), ItemTileType.PINK);
        schema.put(new Position(4, 1), ItemTileType.LIGHTBLUE);
    }
    public int getNumber() {
        return number;
    }
}
