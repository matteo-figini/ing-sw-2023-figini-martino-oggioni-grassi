package it.polimi.ingsw.network.client;

public class ClientManager {


    /* ---------- UTILITY METHODS ---------- */
    /**
     * This method returns true if the IP address specified as parameter is a valid IP address, otherwise it returns false.
     * @param ipAddress The IP address required to be checked.
     * @return {@code true} if the IP address is valid, {@code false} otherwise.
     */
    public static boolean isValidIPAddress (String ipAddress) {
        // TODO: implementare il metodo di controllo dell'indirizzo IP (espressione regolare?)
        return true;
    }

    /**
     * This method returns true if the port specified as parameter is a valid port, otherwise it returns false.
     * Port must be included in the range [1024, 65536) to be valid.
     * @param port The port required to be checked.
     * @return {@code true} if the port is valid, {@code false} otherwise.
     */
    public static boolean isValidPort (int port) {
        return (port >= 1024 && port < 65536);
    }
}
