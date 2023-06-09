package it.polimi.ingsw.view;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ScoringToken;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.message.*;
import it.polimi.ingsw.network.ClientHandler;

import java.util.List;
import java.util.Map;

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
    public void askNickname () { }

    @Override
    public void askPlayersNumber () {
        clientHandler.sendMessage(new PlayersNumberRequest());
    }

    @Override
    public void waitingRoom() {
        clientHandler.sendMessage((new WaitingRoomRequest()));
    }

    @Override
    public void switchToGameRoom(){
        clientHandler.sendMessage((new GameRoomRequest()));
    }

    @Override
    public void askColumnAndPositions() {
        clientHandler.sendMessage(new PickTilesRequest());
    }

    @Override
    public void showLoginResponse (boolean validNickname, boolean connectionEstablished) {
        clientHandler.sendMessage(new LoginResponseMessage(validNickname, connectionEstablished));
    }

    @Override
    public void showGenericMessage (String genericMessage) {
        clientHandler.sendMessage(new GenericMessage(genericMessage));
    }

    @Override
    public void showPlayersList(List<String> players) {
        clientHandler.sendMessage(new PlayersListMessage(players));
    }

    @Override
    public void showBoardContent(BoardCell[][] boardContent) {
        clientHandler.sendMessage(new BoardContent(boardContent));
    }

    @Override
    public void showPlayerInformation(String player, ShelfCell[][] shelfContent, ScoringToken firstCommonGoal, ScoringToken secondCommonGoal, boolean hasEndGameToken) {
        clientHandler.sendMessage(new PlayerInformation(player, shelfContent, firstCommonGoal, secondCommonGoal, hasEndGameToken));
    }

    @Override
    public void showCommonGoalCard(CommonGoalCard commonGoalCard, Integer progressiveCard) {
        clientHandler.sendMessage(new CommonGoalCardMessage(commonGoalCard, progressiveCard));
    }

    @Override
    public void showPersonalGoalCard(PersonalGoalCard personalGoalCard, String cardOwner) {
        clientHandler.sendMessage(new PersonalGoalCardMessage(personalGoalCard, cardOwner));
    }

    @Override
    public void showScoreBoard(Map<String, Integer> scoreBoardMap) {
        clientHandler.sendMessage(new ScoreBoardMessage(scoreBoardMap));
    }
}
