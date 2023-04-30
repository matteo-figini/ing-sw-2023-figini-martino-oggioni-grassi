package it.polimi.ingsw.view;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.network.server.ClientHandler;
import it.polimi.ingsw.network.message.BoardContent;
import it.polimi.ingsw.network.message.GenericMessage;
import it.polimi.ingsw.network.message.ShelfContent;

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
    public void askColumnAndPositions() {
        // TODO: implementare il metodo askUserColumnAndPositions() per VV
    }

    @Override
    public void showGenericMessage (String genericMessage) {
        clientHandler.sendMessage(new GenericMessage(genericMessage));
    }

    @Override
    public void showBoardContent(BoardCell[][] boardContent) {
        clientHandler.sendMessage(new BoardContent(boardContent));
    }

    @Override
    public void showShelfContent(ShelfCell[][] shelfContent, String player) {
        clientHandler.sendMessage(new ShelfContent(shelfContent, player));
    }

    //TODO: implementare tutti i metodi show();
}
