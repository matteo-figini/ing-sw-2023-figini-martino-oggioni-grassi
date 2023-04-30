package it.polimi.ingsw.network.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientManager {


    /* ---------- UTILITY METHODS ---------- */
    /**
     * This method returns true if the IP address specified as parameter is a valid IP address, otherwise it returns false.
     * @param ipAddress The IP address required to be checked.
     * @return {@code true} if the IP address is valid, {@code false} otherwise.
     */
    public static boolean isValidIPAddress (String ipAddress) {
        if (ipAddress == null)
            return false;

        final String IPV4_REGEX_VALIDATOR = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX_VALIDATOR);
        final Matcher matcher = IPV4_PATTERN.matcher(ipAddress);
        return matcher.matches();
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
