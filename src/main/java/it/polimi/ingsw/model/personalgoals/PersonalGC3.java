package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC3 extends PersonalGoalCard {
    private int number = 3;
    public PersonalGC3 () {
        super();
        schema.put(new Position(1, 3), ItemTileType.YELLOW);
        schema.put(new Position(1, 0), ItemTileType.BLUE);
        schema.put(new Position(3, 1), ItemTileType.GREEN);
        schema.put(new Position(5, 0), ItemTileType.WHITE);
        schema.put(new Position(2, 2), ItemTileType.PINK);
        schema.put(new Position(3, 4), ItemTileType.LIGHTBLUE);
    }
    public int getNumber() {
        return number;
    }
}
