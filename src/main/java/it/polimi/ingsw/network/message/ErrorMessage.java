package it.polimi.ingsw.network.message;

/**
 * This class represents a textual message due to an error.
 */
public class ErrorMessage extends Message {
    private final String errorDescription;

    /**
     * Creates the corresponding {@code ErrorMessage}.
     * @param nickname Sender.
     * @param errorDescription Description of the error.
     */
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
