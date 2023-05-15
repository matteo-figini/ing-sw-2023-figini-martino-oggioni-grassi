package it.polimi.ingsw.observer;

import it.polimi.ingsw.model.ItemTile;
import it.polimi.ingsw.model.Position;
import it.polimi.ingsw.network.message.Message;

import java.util.List;
import java.util.Map;

/**
* Custom observer interface for views
*/
public interface ViewObserver {

    void onUpdateServerInfo(Map<String, String> serverInfo);

    void onUpdateNickname(String nickname);

    void onUpdatePlayersNumber(int playersNumber);

    void onUpdatePickTilesBoard(List<ItemTile> cards);

    void onUpdatePickTilesShelf(List<ItemTile> cards, int column);

    void update (Message message);

    void onDisconnection();

}
