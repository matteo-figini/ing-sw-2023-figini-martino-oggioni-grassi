package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC7 extends PersonalGoalCard {
    private int number = 7;
    public PersonalGC7 () {
        super();
        schema.put(new Position(4, 4), ItemTileType.YELLOW);
        schema.put(new Position(1, 3), ItemTileType.BLUE);
        schema.put(new Position(0, 0), ItemTileType.GREEN);
        schema.put(new Position(5, 2), ItemTileType.WHITE);
        schema.put(new Position(2, 1), ItemTileType.PINK);
        schema.put(new Position(3, 0), ItemTileType.LIGHTBLUE);
    }
    public int getNumber() {
        return number;
    }
}
