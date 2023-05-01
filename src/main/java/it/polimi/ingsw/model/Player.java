package it.polimi.ingsw.model;

import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;

/**
 * This class represents the player and all his attributes
 */
public class Player  {
    private Shelf shelf;
    private PersonalGoalCard personalGoalCard;

    private String nickname;

    private int score = 0;

    private boolean firstPlayer = false;

    private boolean firstCommonGoalReached = false;

    private boolean secondCommonGoalReached = false;

    private boolean endGameToken = false;

    /**
     * This constructor initializes the nickname of the player and his shelf
     * @param nickname nickname of the player
     */
    public Player (String nickname) {
        this.nickname = nickname;
        this.shelf = new Shelf();
    }

    /**
     * This method indicates if the player is the first
     * @return a boolean that is true if the player is the first
     */
    public boolean isFirstPlayer() {
        return firstPlayer;
    }

    /**
     * This method sets the player as the first
     */
    public void setFirstPlayer () {
        this.firstPlayer = true;
    }

    /**
     * This method says if the player has reached the goal mentioned in the first Common Goal Card
     * @return a boolean stating true if the goal is reached
     */
    public boolean isFirstCommonGoalReached() {
        return firstCommonGoalReached;
    }

    /**
     * This method changes the state of the parameter stating if the first Common Goal is reached
     */
    public void setFirstCommonGoalReached () {
        this.firstCommonGoalReached = true;
    }

    /**
     * This method says if the player has reached the goal mentioned in the second Common Goal Card
     * @return a boolean stating true if the goal is reached
     */
    public boolean isSecondCommonGoalReached() {
        return secondCommonGoalReached;
    }

    /**
     * This method changes the state of the parameter stating if the second Common Goal is reached
     */
    public void setSecondCommonGoalReached () {
        this.secondCommonGoalReached = true;
    }

    /**
     * This method says if the player owns the End Game Card
     * @return a boolean indicating whether the player has it or not
     */
    public boolean hasEndGameToken() {
        return endGameToken;
    }

    /**
     * This method sets the state of owning the End Game Card to true
     */
    public void setEndGameToken () {
        this.endGameToken = true;
    }

    /**
     * This method gets the current score of the player
     * @return an integer indicating the current score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * This method increments the score of the player
     * @param score indicates the new score of the player
     */
    public void addScore (int score) {
        this.score += score;
    }

    /**
     * This method returns the nickname of the player
     * @return a String containing the nickname of the player
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method sets the personal goal card of the player to the value passed as parameter.
     * @param card The personal goal card of the player.
     */
    public void setPersonalGoalCard (PersonalGoalCard card) {
        this.personalGoalCard = card;
    }

    public PersonalGoalCard getPersonalGoalCard (){
        return personalGoalCard;
    }

    public Shelf getShelf () {
        return this.shelf;
    }


}