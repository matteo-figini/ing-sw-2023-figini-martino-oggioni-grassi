package it.polimi.ingsw.network.message;

public class ErrorMessage extends Message {
    private final String errorDescription;
    public ErrorMessage(String nickname, String errorDescription) {
        super (nickname, MessageType.ERROR_MESSAGE);
        this.errorDescription = errorDescription;
    }

    /**
     * @return The string representing an error description.
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errorDescription='" + errorDescription + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
