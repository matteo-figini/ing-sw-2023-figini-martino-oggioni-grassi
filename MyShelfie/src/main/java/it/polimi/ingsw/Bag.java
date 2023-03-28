package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private Game game;
    private List<ItemTile> itemTileList;
    private int cardNumber;

    public Bag () {
        cardNumber = 132;
        // TODO: inizializzare tutte le 132 tessere nel sacchetto.
    }

    public void addTiles (ItemTileType color) {
        for(int i = 0; i < 22; i++){
            itemTileList.add(new ItemTile(color));
        }
    }

    public void shuffle() {
        Collections.shuffle(itemTileList);
    }

    public ItemTile drawTile () {
        if (itemTileList.size() > 0) {
            return itemTileList.remove(0);
        } else {
            return null;
        }
    }

    //useless (?)
    public List<ItemTile> extractCards(int n){

    }

    public int availableCards(){
        return cardNumber;
    }
}