package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Collections;

public class Bag{

    private Game game;
    private ArrayList<ItemTile> itemTileList;
    public Bag(Game game){
        itemTileList = new ArrayList<>();
        for(ObjectCardType color : ObjectCardType.values()){
            addTiles(color);
        }
        this.game = game;
    }

    public void addTiles(ObjectCardType color){
        for(int i=0; i<22;i++){
            itemTileList.add(new ItemTile(color));
        }
    }

    public void shuffle(){
        Collections.shuffle(itemTileList);
    }

    public ItemTile drawTile(){
        if(itemTileList.size() > 0){
            return itemTileList.remove(0);
        }else{
            return null;
        }
    }

    public List<ObjectCard> extractCards(int n){

    }

    public int availableCards(){

    }
}