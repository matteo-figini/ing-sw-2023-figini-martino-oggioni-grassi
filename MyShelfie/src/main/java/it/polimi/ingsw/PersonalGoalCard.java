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

    private boolean available;

    public PersonalGoalCard(boolean available){

        this.available = available;
    }

    public int checkPattern(Shelf shelf){

    }
}