package it.polimi.ingsw.view;

import it.polimi.ingsw.network.client.ClientHandler;
import it.polimi.ingsw.network.message.GenericMessage;

/**
 * This class offer a mirror of a single client view for the server.
 * It implements the View interface (basically, every method is an invocation to the specific client handler).
 */
public class VirtualView implements View {

    private final ClientHandler clientHandler;

    public VirtualView(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    @Override
    public void askNickname () {
        // TODO: implementare il metodo askNickname() per VV
    }

    @Override
    public void askPlayersNumber () {
        // TODO: implementare il metodo askPlayersNumber() per VV
    }

    @Override
    public void askUserColumnAndPositions() {
        // TODO: implementare il metodo askUserColumnAndPositions() per VV
    }

    @Override
    public void showGenericMessage (String genericMessage) {
        clientHandler.sendMessage(new GenericMessage(genericMessage));
    }

    //TODO: implementare tutti i metodi show();
}
