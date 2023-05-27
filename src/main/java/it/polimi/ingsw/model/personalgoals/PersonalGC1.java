package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC1 extends PersonalGoalCard {
    private int number = 1;
    public PersonalGC1 () {
        super();
        schema.put(new Position(3, 1), ItemTileType.YELLOW);
        schema.put(new Position(0, 2), ItemTileType.BLUE);
        schema.put(new Position(1, 4), ItemTileType.GREEN);
        schema.put(new Position(2, 3), ItemTileType.WHITE);
        schema.put(new Position(0, 0), ItemTileType.PINK);
        schema.put(new Position(5, 2), ItemTileType.LIGHTBLUE);
    }
    public int getNumber() {
        return number;
    }
}
