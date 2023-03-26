package it.polimi.ingsw;

public enum PersonalGoalCard implements GoalCard{

    PERSONAL_1(true),

    PERSONAL_2(true),

    PERSONAL_3(true),

    PERSONAL_4(true),

    PERSONAL_5(true),

    PERSONAL_6(true),

    PERSONAL_7(true),

    PERSONAL_8(true),

    PERSONAL_9(true),

    PERSONAL_10(true),

    PERSONAL_11(true),

    PERSONAL_12(true),
    ;

    private boolean available;
    private Player player;

    public PersonalGoalCard(boolean available, Player player){

        this.player = player;
        this.available = available;
    }

    //return true if the personalGoalCard is true
    public boolean isAvailable() {
        return available;
    }

    //set true if personalCommonCard is available
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int checkPattern(Shelf shelf){

    }
}