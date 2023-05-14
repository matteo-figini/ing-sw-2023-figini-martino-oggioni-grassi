package it.polimi.ingsw.model;

import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;

/**
 * This class represents the player and all his attributes.
 */
public class Player  {

    /** Player's personal shelf. */
    private final Shelf shelf;

    /** Player's personal goal card. */
    private PersonalGoalCard personalGoalCard;

    /** Player's nickname. */
    private final String nickname;

    /** Player's score. */
    private int score = 0;

    private boolean firstPlayer = false;

    private ScoringToken firstCommonGoal = null;

    private ScoringToken secondCommonGoal = null;

    private boolean endGameToken = false;
    private boolean onlinePlayer;

    /**
     * This constructor initializes the nickname of the player and his shelf
     * @param nickname nickname of the player
     */
    public Player (String nickname) {
        this.nickname = nickname;
        this.shelf = new Shelf();
        this.onlinePlayer = true;
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
     * @return {@code true} if the first common goal is reached, {@code false} otherwise.
     */
    public boolean isFirstCommonGoalReached() {
        return (this.firstCommonGoal != null);
    }

    /**
     * Set the first common goal reached passing the corresponding scoring token.
     * @param token The token associated to the common goal.
     */
    public void setFirstCommonGoalReached (ScoringToken token) {
        this.firstCommonGoal = token;
    }

    /**
     * @return {@code true} if the second common goal is reached, {@code false} otherwise.
     */
    public boolean isSecondCommonGoalReached() {
        return (this.secondCommonGoal != null);
    }

    /**
     * Set the second common goal reached passing the corresponding scoring token.
     * @param token The token associated to the common goal.
     */
    public void setSecondCommonGoalReached (ScoringToken token) {
        this.secondCommonGoal = token;
    }

    /**
     * @return The {@code ScoringToken} associated to the first common goal.
     */
    public ScoringToken getFirstCommonGoal() {
        return firstCommonGoal;
    }

    /**
     * @return The {@code ScoringToken} associated to the second common goal.
     */
    public ScoringToken getSecondCommonGoal() {
        return secondCommonGoal;
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

    public boolean isOnlinePlayer() {
        return onlinePlayer;
    }

    public void setOnlinePlayer(boolean onlinePlayer) {
        this.onlinePlayer = onlinePlayer;
    }
}