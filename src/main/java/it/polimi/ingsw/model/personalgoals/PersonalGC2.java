package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC2 extends PersonalGoalCard {
    private int number = 2;
    public PersonalGC2 () {
        super();
        schema.put(new Position(2, 2), ItemTileType.YELLOW);
        schema.put(new Position(5, 4), ItemTileType.BLUE);
        schema.put(new Position(2, 0), ItemTileType.GREEN);
        schema.put(new Position(3, 4), ItemTileType.WHITE);
        schema.put(new Position(1, 1), ItemTileType.PINK);
        schema.put(new Position(4, 3), ItemTileType.LIGHTBLUE);
    }
    public int getNumber() {
        return number;
    }
}