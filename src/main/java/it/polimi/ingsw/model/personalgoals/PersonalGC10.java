package it.polimi.ingsw.model.personalgoals;

import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.Position;

public class PersonalGC10 extends PersonalGoalCard {
    private int number = 10;
    public PersonalGC10 () {
        super();
        schema.put(new Position(1, 1), ItemTileType.YELLOW);
        schema.put(new Position(4, 1), ItemTileType.BLUE);
        schema.put(new Position(3, 3), ItemTileType.GREEN);
        schema.put(new Position(2, 0), ItemTileType.WHITE);
        schema.put(new Position(5, 3), ItemTileType.PINK);
        schema.put(new Position(0, 4), ItemTileType.LIGHTBLUE);
    }
    public int getNumber() {
        return number;
    }
}
