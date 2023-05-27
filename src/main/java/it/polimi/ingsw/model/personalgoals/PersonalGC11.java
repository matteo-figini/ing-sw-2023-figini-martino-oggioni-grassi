package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC11 extends PersonalGoalCard {
    private int number = 11;
    public PersonalGC11 () {
        super();
        schema.put(new Position(2, 0), ItemTileType.YELLOW);
        schema.put(new Position(3, 2), ItemTileType.BLUE);
        schema.put(new Position(4, 4), ItemTileType.GREEN);
        schema.put(new Position(1, 1), ItemTileType.WHITE);
        schema.put(new Position(0, 2), ItemTileType.PINK);
        schema.put(new Position(5, 3), ItemTileType.LIGHTBLUE);
    }
    public int getNumber() {
        return number;
    }
}
