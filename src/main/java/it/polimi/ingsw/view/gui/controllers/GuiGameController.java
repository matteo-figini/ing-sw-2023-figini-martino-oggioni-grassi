package it.polimi.ingsw.view.gui.controllers;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import it.polimi.ingsw.model.BoardCell;
import it.polimi.ingsw.model.ItemTileType;
import it.polimi.ingsw.model.ScoringToken;
import it.polimi.ingsw.model.ShelfCell;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.ClientManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class GuiGameController {
    private ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ImageView Board00;

    @FXML
    private ImageView Board01;

    @FXML
    private ImageView Board02;

    @FXML
    private ImageView Board03;

    @FXML
    private ImageView Board04;

    @FXML
    private ImageView Board05;

    @FXML
    private ImageView Board06;

    @FXML
    private ImageView Board07;

    @FXML
    private ImageView Board08;

    @FXML
    private ImageView Board10;

    @FXML
    private ImageView Board11;

    @FXML
    private ImageView Board12;

    @FXML
    private ImageView Board13;

    @FXML
    private ImageView Board14;

    @FXML
    private ImageView Board15;

    @FXML
    private ImageView Board16;

    @FXML
    private ImageView Board17;

    @FXML
    private ImageView Board18;

    @FXML
    private ImageView Board20;

    @FXML
    private ImageView Board21;

    @FXML
    private ImageView Board22;

    @FXML
    private ImageView Board23;

    @FXML
    private ImageView Board24;

    @FXML
    private ImageView Board25;
    @FXML
    private ImageView Board26;

    @FXML
    private ImageView Board27;

    @FXML
    private ImageView Board28;

    @FXML
    private ImageView Board30;

    @FXML
    private ImageView Board31;

    @FXML
    private ImageView Board32;

    @FXML
    private ImageView Board33;

    @FXML
    private ImageView Board34;

    @FXML
    private ImageView Board35;

    @FXML
    private ImageView Board36;

    @FXML
    private ImageView Board37;

    @FXML
    private ImageView Board38;

    @FXML
    private ImageView Board40;

    @FXML
    private ImageView Board41;

    @FXML
    private ImageView Board42;

    @FXML
    private ImageView Board43;

    @FXML
    private ImageView Board44;

    @FXML
    private ImageView Board45;

    @FXML
    private ImageView Board46;

    @FXML
    private ImageView Board47;

    @FXML
    private ImageView Board48;

    @FXML
    private ImageView Board50;

    @FXML
    private ImageView Board51;

    @FXML
    private ImageView Board52;

    @FXML
    private ImageView Board53;

    @FXML
    private ImageView Board54;

    @FXML
    private ImageView Board55;

    @FXML
    private ImageView Board56;

    @FXML
    private ImageView Board57;

    @FXML
    private ImageView Board58;

    @FXML
    private ImageView Board60;

    @FXML
    private ImageView Board61;

    @FXML
    private ImageView Board62;

    @FXML
    private ImageView Board63;

    @FXML
    private ImageView Board64;

    @FXML
    private ImageView Board65;

    @FXML
    private ImageView Board66;

    @FXML
    private ImageView Board67;

    @FXML
    private ImageView Board68;

    @FXML
    private ImageView Board70;

    @FXML
    private ImageView Board71;

    @FXML
    private ImageView Board72;

    @FXML
    private ImageView Board73;

    @FXML
    private ImageView Board74;

    @FXML
    private ImageView Board75;

    @FXML
    private ImageView Board76;

    @FXML
    private ImageView Board77;

    @FXML
    private ImageView Board78;

    @FXML
    private ImageView Board80;

    @FXML
    private ImageView Board81;

    @FXML
    private ImageView Board82;

    @FXML
    private ImageView Board83;

    @FXML
    private ImageView Board84;

    @FXML
    private ImageView Board85;

    @FXML
    private ImageView Board86;

    @FXML
    private ImageView Board87;

    @FXML
    private ImageView Board88;
    @FXML
    private Text Chat;

    @FXML
    private ImageView CommonGoalCard1;

    @FXML
    private ImageView CommonGoalCard2;

    @FXML
    private Button ExitButton;

    @FXML
    private ImageView PersonalGoalCard;

    @FXML
    private Text Player1Name;

    @FXML
    private Text Player2Name;

    @FXML
    private Text Player3Name;

    @FXML
    private Text Player4Name;

    @FXML
    private GridPane gridPane;

    @FXML
    void initialize() {
        assert Board00 != null : "fx:id=\"Board00\" was not injected: check your FXML file 'game.fxml'.";
        assert Board01 != null : "fx:id=\"Board01\" was not injected: check your FXML file 'game.fxml'.";
        assert Board02 != null : "fx:id=\"Board02\" was not injected: check your FXML file 'game.fxml'.";
        assert Board03 != null : "fx:id=\"Board03\" was not injected: check your FXML file 'game.fxml'.";
        assert Board04 != null : "fx:id=\"Board04\" was not injected: check your FXML file 'game.fxml'.";
        assert Board05 != null : "fx:id=\"Board05\" was not injected: check your FXML file 'game.fxml'.";
        assert Board06 != null : "fx:id=\"Board06\" was not injected: check your FXML file 'game.fxml'.";
        assert Board07 != null : "fx:id=\"Board07\" was not injected: check your FXML file 'game.fxml'.";
        assert Board08 != null : "fx:id=\"Board08\" was not injected: check your FXML file 'game.fxml'.";
        assert Board10 != null : "fx:id=\"Board10\" was not injected: check your FXML file 'game.fxml'.";
        assert Board11 != null : "fx:id=\"Board11\" was not injected: check your FXML file 'game.fxml'.";
        assert Board12 != null : "fx:id=\"Board12\" was not injected: check your FXML file 'game.fxml'.";
        assert Board13 != null : "fx:id=\"Board13\" was not injected: check your FXML file 'game.fxml'.";
        assert Board14 != null : "fx:id=\"Board14\" was not injected: check your FXML file 'game.fxml'.";
        assert Board15 != null : "fx:id=\"Board15\" was not injected: check your FXML file 'game.fxml'.";
        assert Board16 != null : "fx:id=\"Board16\" was not injected: check your FXML file 'game.fxml'.";
        assert Board17 != null : "fx:id=\"Board17\" was not injected: check your FXML file 'game.fxml'.";
        assert Board18 != null : "fx:id=\"Board18\" was not injected: check your FXML file 'game.fxml'.";
        assert Board20 != null : "fx:id=\"Board20\" was not injected: check your FXML file 'game.fxml'.";
        assert Board21 != null : "fx:id=\"Board21\" was not injected: check your FXML file 'game.fxml'.";
        assert Board22 != null : "fx:id=\"Board22\" was not injected: check your FXML file 'game.fxml'.";
        assert Board23 != null : "fx:id=\"Board23\" was not injected: check your FXML file 'game.fxml'.";
        assert Board24 != null : "fx:id=\"Board24\" was not injected: check your FXML file 'game.fxml'.";
        assert Board25 != null : "fx:id=\"Board25\" was not injected: check your FXML file 'game.fxml'.";
        assert Board26 != null : "fx:id=\"Board26\" was not injected: check your FXML file 'game.fxml'.";
        assert Board27 != null : "fx:id=\"Board27\" was not injected: check your FXML file 'game.fxml'.";
        assert Board28 != null : "fx:id=\"Board28\" was not injected: check your FXML file 'game.fxml'.";
        assert Board30 != null : "fx:id=\"Board30\" was not injected: check your FXML file 'game.fxml'.";
        assert Board31 != null : "fx:id=\"Board31\" was not injected: check your FXML file 'game.fxml'.";
        assert Board32 != null : "fx:id=\"Board32\" was not injected: check your FXML file 'game.fxml'.";
        assert Board33 != null : "fx:id=\"Board33\" was not injected: check your FXML file 'game.fxml'.";
        assert Board34 != null : "fx:id=\"Board34\" was not injected: check your FXML file 'game.fxml'.";
        assert Board35 != null : "fx:id=\"Board35\" was not injected: check your FXML file 'game.fxml'.";
        assert Board36 != null : "fx:id=\"Board36\" was not injected: check your FXML file 'game.fxml'.";
        assert Board37 != null : "fx:id=\"Board37\" was not injected: check your FXML file 'game.fxml'.";
        assert Board38 != null : "fx:id=\"Board38\" was not injected: check your FXML file 'game.fxml'.";
        assert Board40 != null : "fx:id=\"Board40\" was not injected: check your FXML file 'game.fxml'.";
        assert Board41 != null : "fx:id=\"Board41\" was not injected: check your FXML file 'game.fxml'.";
        assert Board42 != null : "fx:id=\"Board42\" was not injected: check your FXML file 'game.fxml'.";
        assert Board43 != null : "fx:id=\"Board43\" was not injected: check your FXML file 'game.fxml'.";
        assert Board44 != null : "fx:id=\"Board44\" was not injected: check your FXML file 'game.fxml'.";
        assert Board45 != null : "fx:id=\"Board45\" was not injected: check your FXML file 'game.fxml'.";
        assert Board46 != null : "fx:id=\"Board46\" was not injected: check your FXML file 'game.fxml'.";
        assert Board47 != null : "fx:id=\"Board47\" was not injected: check your FXML file 'game.fxml'.";
        assert Board48 != null : "fx:id=\"Board48\" was not injected: check your FXML file 'game.fxml'.";
        assert Board50 != null : "fx:id=\"Board50\" was not injected: check your FXML file 'game.fxml'.";
        assert Board51 != null : "fx:id=\"Board51\" was not injected: check your FXML file 'game.fxml'.";
        assert Board52 != null : "fx:id=\"Board52\" was not injected: check your FXML file 'game.fxml'.";
        assert Board53 != null : "fx:id=\"Board53\" was not injected: check your FXML file 'game.fxml'.";
        assert Board54 != null : "fx:id=\"Board54\" was not injected: check your FXML file 'game.fxml'.";
        assert Board55 != null : "fx:id=\"Board55\" was not injected: check your FXML file 'game.fxml'.";
        assert Board56 != null : "fx:id=\"Board56\" was not injected: check your FXML file 'game.fxml'.";
        assert Board57 != null : "fx:id=\"Board57\" was not injected: check your FXML file 'game.fxml'.";
        assert Board58 != null : "fx:id=\"Board58\" was not injected: check your FXML file 'game.fxml'.";
        assert Board60 != null : "fx:id=\"Board60\" was not injected: check your FXML file 'game.fxml'.";
        assert Board61 != null : "fx:id=\"Board61\" was not injected: check your FXML file 'game.fxml'.";
        assert Board62 != null : "fx:id=\"Board62\" was not injected: check your FXML file 'game.fxml'.";
        assert Board63 != null : "fx:id=\"Board63\" was not injected: check your FXML file 'game.fxml'.";
        assert Board64 != null : "fx:id=\"Board64\" was not injected: check your FXML file 'game.fxml'.";
        assert Board65 != null : "fx:id=\"Board65\" was not injected: check your FXML file 'game.fxml'.";
        assert Board66 != null : "fx:id=\"Board66\" was not injected: check your FXML file 'game.fxml'.";
        assert Board67 != null : "fx:id=\"Board67\" was not injected: check your FXML file 'game.fxml'.";
        assert Board68 != null : "fx:id=\"Board68\" was not injected: check your FXML file 'game.fxml'.";
        assert Board70 != null : "fx:id=\"Board70\" was not injected: check your FXML file 'game.fxml'.";
        assert Board71 != null : "fx:id=\"Board71\" was not injected: check your FXML file 'game.fxml'.";
        assert Board72 != null : "fx:id=\"Board72\" was not injected: check your FXML file 'game.fxml'.";
        assert Board73 != null : "fx:id=\"Board73\" was not injected: check your FXML file 'game.fxml'.";
        assert Board74 != null : "fx:id=\"Board74\" was not injected: check your FXML file 'game.fxml'.";
        assert Board75 != null : "fx:id=\"Board75\" was not injected: check your FXML file 'game.fxml'.";
        assert Board76 != null : "fx:id=\"Board76\" was not injected: check your FXML file 'game.fxml'.";
        assert Board77 != null : "fx:id=\"Board77\" was not injected: check your FXML file 'game.fxml'.";
        assert Board78 != null : "fx:id=\"Board78\" was not injected: check your FXML file 'game.fxml'.";
        assert Board80 != null : "fx:id=\"Board80\" was not injected: check your FXML file 'game.fxml'.";
        assert Board81 != null : "fx:id=\"Board81\" was not injected: check your FXML file 'game.fxml'.";
        assert Board82 != null : "fx:id=\"Board82\" was not injected: check your FXML file 'game.fxml'.";
        assert Board83 != null : "fx:id=\"Board83\" was not injected: check your FXML file 'game.fxml'.";
        assert Board84 != null : "fx:id=\"Board84\" was not injected: check your FXML file 'game.fxml'.";
        assert Board85 != null : "fx:id=\"Board85\" was not injected: check your FXML file 'game.fxml'.";
        assert Board86 != null : "fx:id=\"Board86\" was not injected: check your FXML file 'game.fxml'.";
        assert Board87 != null : "fx:id=\"Board87\" was not injected: check your FXML file 'game.fxml'.";
        assert Board88 != null : "fx:id=\"Board88\" was not injected: check your FXML file 'game.fxml'.";
        assert Chat != null : "fx:id=\"Chat\" was not injected: check your FXML file 'game.fxml'.";
        assert CommonGoalCard1 != null : "fx:id=\"CommonGoalCard1\" was not injected: check your FXML file 'game.fxml'.";
        assert CommonGoalCard2 != null : "fx:id=\"CommonGoalCard2\" was not injected: check your FXML file 'game.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'game.fxml'.";
        assert PersonalGoalCard != null : "fx:id=\"PersonalGoalCard\" was not injected: check your FXML file 'game.fxml'.";
        assert Player1Name != null : "fx:id=\"Player1Name\" was not injected: check your FXML file 'game.fxml'.";
        assert Player2Name != null : "fx:id=\"Player2Name\" was not injected: check your FXML file 'game.fxml'.";
        assert Player3Name != null : "fx:id=\"Player3Name\" was not injected: check your FXML file 'game.fxml'.";
        assert Player4Name != null : "fx:id=\"Player4Name\" was not injected: check your FXML file 'game.fxml'.";
        assert gridPane != null : "fx:id=\"gridPane\" was not injected: check your FXML file 'game.fxml'.";

    }

    public void updateBoardContent(BoardCell[][] boardContent) {
        ImageView[][] cellImageViews = new ImageView[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellImageViews[i][j] = new ImageView();
            }
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9 ; j++){
                if(!boardContent[i][j].isFree()) {
                    ItemTileType itemTileType = boardContent[i][j].getItemTile().getItemTileType();
                    Image image = null;
                    switch (itemTileType) {
                        case GREEN -> image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/item tiles/Gatti1.1.png")));
                        case WHITE -> image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/item tiles/Libri1.1.png")));
                        case YELLOW -> image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/item tiles/Giochi1.2.png")));
                        case BLUE -> image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/item tiles/Cornici1.3.png")));
                        case LIGHTBLUE -> image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/item tiles/Trofei1.3.png")));
                        case PINK -> image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/item tiles/Piante1.1.png")));
                        default -> {
                        }
                    }
                    cellImageViews[i][j].setImage(image);
                }
            }
        }
        Board03.setImage(cellImageViews[0][3].getImage());
        Board04.setImage(cellImageViews[0][4].getImage());
        Board13.setImage(cellImageViews[1][3].getImage());
        Board14.setImage(cellImageViews[1][4].getImage());
        Board15.setImage(cellImageViews[1][5].getImage());
        Board22.setImage(cellImageViews[2][2].getImage());
        Board23.setImage(cellImageViews[2][3].getImage());
        Board24.setImage(cellImageViews[2][4].getImage());
        Board25.setImage(cellImageViews[2][5].getImage());
        Board26.setImage(cellImageViews[2][6].getImage());
        Board31.setImage(cellImageViews[3][1].getImage());
        Board32.setImage(cellImageViews[3][2].getImage());
        Board33.setImage(cellImageViews[3][3].getImage());
        Board34.setImage(cellImageViews[3][4].getImage());
        Board35.setImage(cellImageViews[3][5].getImage());
        Board36.setImage(cellImageViews[3][6].getImage());
        Board37.setImage(cellImageViews[3][7].getImage());
        Board38.setImage(cellImageViews[3][8].getImage());
        Board40.setImage(cellImageViews[4][0].getImage());
        Board41.setImage(cellImageViews[4][1].getImage());
        Board42.setImage(cellImageViews[4][2].getImage());
        Board43.setImage(cellImageViews[4][3].getImage());
        Board44.setImage(cellImageViews[4][4].getImage());
        Board45.setImage(cellImageViews[4][5].getImage());
        Board46.setImage(cellImageViews[4][6].getImage());
        Board47.setImage(cellImageViews[4][7].getImage());
        Board48.setImage(cellImageViews[4][8].getImage());
        Board50.setImage(cellImageViews[5][0].getImage());
        Board51.setImage(cellImageViews[5][1].getImage());
        Board52.setImage(cellImageViews[5][2].getImage());
        Board53.setImage(cellImageViews[5][3].getImage());
        Board54.setImage(cellImageViews[5][4].getImage());
        Board55.setImage(cellImageViews[5][5].getImage());
        Board56.setImage(cellImageViews[5][6].getImage());
        Board57.setImage(cellImageViews[5][7].getImage());
        Board62.setImage(cellImageViews[6][2].getImage());
        Board63.setImage(cellImageViews[6][3].getImage());
        Board64.setImage(cellImageViews[6][4].getImage());
        Board65.setImage(cellImageViews[6][5].getImage());
        Board66.setImage(cellImageViews[6][6].getImage());
        Board73.setImage(cellImageViews[7][3].getImage());
        Board74.setImage(cellImageViews[7][4].getImage());
        Board75.setImage(cellImageViews[7][5].getImage());
        Board84.setImage(cellImageViews[8][4].getImage());
        Board85.setImage(cellImageViews[8][5].getImage());
    }

    public void updateShelfContent(ShelfCell[][] shelfContent, String nickname) {

    }

    public void updatePersonalGoalCard(PersonalGoalCard personalGoalCard) {
        Image image = null;
        switch (personalGoalCard.getNumber()) {
            case 1 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals.png")));
            case 2 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals2.png")));
            case 3 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals3.png")));
            case 4 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals4.png")));
            case 5 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals5.png")));
            case 6 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals6.png")));
            case 7 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals7.png")));
            case 8 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals8.png")));
            case 9 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals9.png")));
            case 10 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals10.png")));
            case 11 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals11.png")));
            case 12 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals12.png")));
            default -> {
            }
        }
        PersonalGoalCard.setImage(image);
    }

    public void updateCommonGoalCard(CommonGoalCard commonGoalCard) {
        Image image = null;
        List<ScoringToken> tokens = commonGoalCard.getScoringTokens();
        switch (commonGoalCard.getNumber()) {
            case 1 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/1.jpg")));
            case 2 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/2.jpg")));
            case 3 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/3.jpg")));
            case 4 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/4.jpg")));
            case 5 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/5.jpg")));
            case 6 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/6.jpg")));
            case 7 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/7.jpg")));
            case 8 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/8.jpg")));
            case 9 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/9.jpg")));
            case 10 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/10.jpg")));
            case 11 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/11.jpg")));
            case 12 ->
                    image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/12.jpg")));
            default -> {
            }
        }
        CommonGoalCard1.setImage(image);
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }



}
