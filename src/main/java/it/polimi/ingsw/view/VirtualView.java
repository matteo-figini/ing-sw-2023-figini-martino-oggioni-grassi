package it.polimi.ingsw.view;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.message.*;
import it.polimi.ingsw.network.socket.server.ClientHandler;

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
        clientHandler.sendMessage(new PlayersNumberRequest());
    }

    @Override
    public void askColumnAndPositions() {
        clientHandler.sendMessage(new PickTilesRequest());
    }

    @Override
    public void showLoginResponse (boolean validNickname, boolean connectionEstablished) {
        clientHandler.sendMessage(new LoginResponse(validNickname, connectionEstablished));
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

    @Override
    public void showCommonGoalCard(CommonGoalCard commonGoalCard) {
        clientHandler.sendMessage(new CommonGoalCardMessage(commonGoalCard));
    }

    @Override
    public void showPersonalGoalCard(PersonalGoalCard personalGoalCard) {
        clientHandler.sendMessage(new PersonalGoalCardMessage(personalGoalCard));
    }


    //TODO: implementare tutti i metodi show();
}
