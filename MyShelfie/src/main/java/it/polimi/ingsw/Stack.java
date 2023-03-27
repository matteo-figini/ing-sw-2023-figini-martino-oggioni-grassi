package it.polimi.ingsw;

public class Stack {

    private ScoringToken[] scoringTokens;
    private int top;

    public Stack(int size){
        scoringTokens = new ScoringToken[size];
        top = -1;
    }

    public void push(ScoringToken token){
        if (top == scoringTokens.length - 1){
            throw new IllegalStateException("Stack is full");
        }
        top++;
        scoringTokens[top] = token;
    }

    public ScoringToken pop(){
        if (top == - 1){
            throw new IllegalStateException("Stack is empty");
        }
        ScoringToken token = scoringTokens[top];
        scoringTokens[top] = null;
        top--;
        return token;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top + 1;
    }
}