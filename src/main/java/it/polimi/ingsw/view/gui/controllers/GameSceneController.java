package it.polimi.ingsw.view.gui.controllers;

import java.net.URL;
import java.util.*;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.ClientManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This class is the controller class for the {@code GameScene}. It contains all the methods to update the board representation,
 * all the player's shelf, the goal cards and other elements. Indeed, it ensures to choose the tiles to pick up from the board
 * when it's the active player turn.
 */
public class GameSceneController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    /** Reference to the {@code ClientManager} instance of the client. */
    private ClientManager clientManager;
    /** {@code true} if it is the turn of the current player, {@code false otherwise}. */
    private boolean pickUpEnabled = true;
    /** {@code List} of the chosen positions on the board. */
    List<Position> positions = new ArrayList<>();
    /** {@code List} of the images on the chosen positions on the board. */
    List<Image> tilesImages = new ArrayList<>();
    /** {@code List} of the selected nodes on the chosen positions on the board. */
    List<Node> blurredNodes = new ArrayList<>();

    @FXML
    private ImageView Common1Token1;

    @FXML
    private ImageView Common1Token2;

    @FXML
    private ImageView Common1Token3;

    @FXML
    private ImageView Common1Token4;

    @FXML
    private ImageView Common2Token1;

    @FXML
    private ImageView Common2Token2;

    @FXML
    private ImageView Common2Token3;

    @FXML
    private ImageView Common2Token4;

    @FXML
    private ImageView CompleteShelfToken;

    @FXML
    private ImageView P1Common1Token;

    @FXML
    private ImageView P1Common2Token;

    @FXML
    private ImageView P1CompleteShelfToken;

    @FXML
    private ImageView P2Common1Token;

    @FXML
    private ImageView P2Common2Token;

    @FXML
    private ImageView P2CompleteShelfToken;

    @FXML
    private ImageView P3Common1Token;

    @FXML
    private ImageView P3Common2Token;

    @FXML
    private ImageView P3CompleteShelfToken;

    @FXML
    private ImageView P4Common1Token;

    @FXML
    private ImageView P4Common2Token;

    @FXML
    private ImageView P4CompleteShelfToken;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

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
    private GridPane P1Shelf;

    @FXML
    private ImageView P1shelf00;

    @FXML
    private ImageView P1shelf01;

    @FXML
    private ImageView P1shelf02;

    @FXML
    private ImageView P1shelf03;

    @FXML
    private ImageView P1shelf04;

    @FXML
    private ImageView P1shelf10;

    @FXML
    private ImageView P1shelf11;

    @FXML
    private ImageView P1shelf12;

    @FXML
    private ImageView P1shelf13;

    @FXML
    private ImageView P1shelf14;

    @FXML
    private ImageView P1shelf20;

    @FXML
    private ImageView P1shelf21;

    @FXML
    private ImageView P1shelf22;

    @FXML
    private ImageView P1shelf23;

    @FXML
    private ImageView P1shelf24;

    @FXML
    private ImageView P1shelf30;

    @FXML
    private ImageView P1shelf31;

    @FXML
    private ImageView P1shelf32;

    @FXML
    private ImageView P1shelf33;

    @FXML
    private ImageView P1shelf34;

    @FXML
    private ImageView P1shelf40;

    @FXML
    private ImageView P1shelf41;

    @FXML
    private ImageView P1shelf42;

    @FXML
    private ImageView P1shelf43;

    @FXML
    private ImageView P1shelf44;

    @FXML
    private ImageView P1shelf50;

    @FXML
    private ImageView P1shelf51;

    @FXML
    private ImageView P1shelf52;

    @FXML
    private ImageView P1shelf53;

    @FXML
    private ImageView P1shelf54;

    @FXML
    private GridPane P2Shelf;

    @FXML
    private ImageView P2shelf00;

    @FXML
    private ImageView P2shelf01;

    @FXML
    private ImageView P2shelf02;

    @FXML
    private ImageView P2shelf03;

    @FXML
    private ImageView P2shelf04;

    @FXML
    private ImageView P2shelf10;

    @FXML
    private ImageView P2shelf11;

    @FXML
    private ImageView P2shelf12;

    @FXML
    private ImageView P2shelf13;

    @FXML
    private ImageView P2shelf14;

    @FXML
    private ImageView P2shelf20;

    @FXML
    private ImageView P2shelf21;

    @FXML
    private ImageView P2shelf22;

    @FXML
    private ImageView P2shelf23;

    @FXML
    private ImageView P2shelf24;

    @FXML
    private ImageView P2shelf30;

    @FXML
    private ImageView P2shelf31;

    @FXML
    private ImageView P2shelf32;

    @FXML
    private ImageView P2shelf33;

    @FXML
    private ImageView P2shelf34;

    @FXML
    private ImageView P2shelf40;

    @FXML
    private ImageView P2shelf41;

    @FXML
    private ImageView P2shelf42;

    @FXML
    private ImageView P2shelf43;

    @FXML
    private ImageView P2shelf44;

    @FXML
    private ImageView P2shelf50;

    @FXML
    private ImageView P2shelf51;

    @FXML
    private ImageView P2shelf52;

    @FXML
    private ImageView P2shelf53;

    @FXML
    private ImageView P2shelf54;

    @FXML
    private GridPane P3Shelf;

    @FXML
    private ImageView P3shelf00;

    @FXML
    private ImageView P3shelf01;

    @FXML
    private ImageView P3shelf02;

    @FXML
    private ImageView P3shelf03;

    @FXML
    private ImageView P3shelf04;

    @FXML
    private ImageView P3shelf10;

    @FXML
    private ImageView P3shelf11;

    @FXML
    private ImageView P3shelf12;

    @FXML
    private ImageView P3shelf13;

    @FXML
    private ImageView P3shelf14;

    @FXML
    private ImageView P3shelf20;

    @FXML
    private ImageView P3shelf21;

    @FXML
    private ImageView P3shelf22;

    @FXML
    private ImageView P3shelf23;

    @FXML
    private ImageView P3shelf24;

    @FXML
    private ImageView P3shelf30;

    @FXML
    private ImageView P3shelf31;

    @FXML
    private ImageView P3shelf32;

    @FXML
    private ImageView P3shelf33;

    @FXML
    private ImageView P3shelf34;

    @FXML
    private ImageView P3shelf40;

    @FXML
    private ImageView P3shelf41;

    @FXML
    private ImageView P3shelf42;

    @FXML
    private ImageView P3shelf43;

    @FXML
    private ImageView P3shelf44;

    @FXML
    private ImageView P3shelf50;

    @FXML
    private ImageView P3shelf51;

    @FXML
    private ImageView P3shelf52;

    @FXML
    private ImageView P3shelf53;

    @FXML
    private ImageView P3shelf54;

    @FXML
    private GridPane P4Shelf;

    @FXML
    private ImageView P4shelf00;

    @FXML
    private ImageView P4shelf01;

    @FXML
    private ImageView P4shelf02;

    @FXML
    private ImageView P4shelf03;

    @FXML
    private ImageView P4shelf04;

    @FXML
    private ImageView P4shelf10;

    @FXML
    private ImageView P4shelf11;

    @FXML
    private ImageView P4shelf12;

    @FXML
    private ImageView P4shelf13;

    @FXML
    private ImageView P4shelf14;

    @FXML
    private ImageView P4shelf20;

    @FXML
    private ImageView P4shelf21;

    @FXML
    private ImageView P4shelf22;

    @FXML
    private ImageView P4shelf23;

    @FXML
    private ImageView P4shelf24;

    @FXML
    private ImageView P4shelf30;

    @FXML
    private ImageView P4shelf31;

    @FXML
    private ImageView P4shelf32;

    @FXML
    private ImageView P4shelf33;

    @FXML
    private ImageView P4shelf34;

    @FXML
    private ImageView P4shelf40;

    @FXML
    private ImageView P4shelf41;

    @FXML
    private ImageView P4shelf42;

    @FXML
    private ImageView P4shelf43;

    @FXML
    private ImageView P4shelf44;

    @FXML
    private ImageView P4shelf50;

    @FXML
    private ImageView P4shelf51;

    @FXML
    private ImageView P4shelf52;

    @FXML
    private ImageView P4shelf53;

    @FXML
    private ImageView P4shelf54;

    @FXML
    private Text messageBox;

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
    private StackPane stackPaneP3;

    @FXML
    private StackPane stackPaneP4;

    @FXML
    private Button resetTurnButton;

    @FXML
    void initialize() {
        assert Board00 != null : "fx:id=\"Board00\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board01 != null : "fx:id=\"Board01\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board02 != null : "fx:id=\"Board02\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board03 != null : "fx:id=\"Board03\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board04 != null : "fx:id=\"Board04\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board05 != null : "fx:id=\"Board05\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board06 != null : "fx:id=\"Board06\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board07 != null : "fx:id=\"Board07\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board08 != null : "fx:id=\"Board08\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board10 != null : "fx:id=\"Board10\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board11 != null : "fx:id=\"Board11\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board12 != null : "fx:id=\"Board12\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board13 != null : "fx:id=\"Board13\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board14 != null : "fx:id=\"Board14\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board15 != null : "fx:id=\"Board15\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board16 != null : "fx:id=\"Board16\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board17 != null : "fx:id=\"Board17\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board18 != null : "fx:id=\"Board18\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board20 != null : "fx:id=\"Board20\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board21 != null : "fx:id=\"Board21\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board22 != null : "fx:id=\"Board22\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board23 != null : "fx:id=\"Board23\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board24 != null : "fx:id=\"Board24\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board25 != null : "fx:id=\"Board25\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board26 != null : "fx:id=\"Board26\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board27 != null : "fx:id=\"Board27\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board28 != null : "fx:id=\"Board28\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board30 != null : "fx:id=\"Board30\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board31 != null : "fx:id=\"Board31\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board32 != null : "fx:id=\"Board32\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board33 != null : "fx:id=\"Board33\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board34 != null : "fx:id=\"Board34\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board35 != null : "fx:id=\"Board35\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board36 != null : "fx:id=\"Board36\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board37 != null : "fx:id=\"Board37\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board38 != null : "fx:id=\"Board38\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board40 != null : "fx:id=\"Board40\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board41 != null : "fx:id=\"Board41\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board42 != null : "fx:id=\"Board42\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board43 != null : "fx:id=\"Board43\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board44 != null : "fx:id=\"Board44\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board45 != null : "fx:id=\"Board45\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board46 != null : "fx:id=\"Board46\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board47 != null : "fx:id=\"Board47\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board48 != null : "fx:id=\"Board48\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board50 != null : "fx:id=\"Board50\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board51 != null : "fx:id=\"Board51\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board52 != null : "fx:id=\"Board52\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board53 != null : "fx:id=\"Board53\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board54 != null : "fx:id=\"Board54\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board55 != null : "fx:id=\"Board55\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board56 != null : "fx:id=\"Board56\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board57 != null : "fx:id=\"Board57\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board58 != null : "fx:id=\"Board58\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board60 != null : "fx:id=\"Board60\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board61 != null : "fx:id=\"Board61\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board62 != null : "fx:id=\"Board62\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board63 != null : "fx:id=\"Board63\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board64 != null : "fx:id=\"Board64\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board65 != null : "fx:id=\"Board65\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board66 != null : "fx:id=\"Board66\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board67 != null : "fx:id=\"Board67\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board68 != null : "fx:id=\"Board68\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board70 != null : "fx:id=\"Board70\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board71 != null : "fx:id=\"Board71\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board72 != null : "fx:id=\"Board72\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board73 != null : "fx:id=\"Board73\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board74 != null : "fx:id=\"Board74\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board75 != null : "fx:id=\"Board75\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board76 != null : "fx:id=\"Board76\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board77 != null : "fx:id=\"Board77\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board78 != null : "fx:id=\"Board78\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board80 != null : "fx:id=\"Board80\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board81 != null : "fx:id=\"Board81\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board82 != null : "fx:id=\"Board82\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board83 != null : "fx:id=\"Board83\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board84 != null : "fx:id=\"Board84\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board85 != null : "fx:id=\"Board85\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board86 != null : "fx:id=\"Board86\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board87 != null : "fx:id=\"Board87\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Board88 != null : "fx:id=\"Board88\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert CommonGoalCard1 != null : "fx:id=\"CommonGoalCard1\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert CommonGoalCard2 != null : "fx:id=\"CommonGoalCard2\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert PersonalGoalCard != null : "fx:id=\"PersonalGoalCard\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Player1Name != null : "fx:id=\"Player1Name\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Player2Name != null : "fx:id=\"Player2Name\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Player3Name != null : "fx:id=\"Player3Name\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Player4Name != null : "fx:id=\"Player4Name\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert gridPane != null : "fx:id=\"gridPane\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P1Shelf != null : "fx:id=\"P1Shelf\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2Shelf != null : "fx:id=\"P2Shelf\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf00 != null : "fx:id=\"P2shelf00\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf01 != null : "fx:id=\"P2shelf01\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf02 != null : "fx:id=\"P2shelf02\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf03 != null : "fx:id=\"P2shelf03\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf04 != null : "fx:id=\"P2shelf04\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf10 != null : "fx:id=\"P2shelf10\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf11 != null : "fx:id=\"P2shelf11\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf12 != null : "fx:id=\"P2shelf12\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf13 != null : "fx:id=\"P2shelf13\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf14 != null : "fx:id=\"P2shelf14\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf20 != null : "fx:id=\"P2shelf20\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf21 != null : "fx:id=\"P2shelf21\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf22 != null : "fx:id=\"P2shelf22\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf23 != null : "fx:id=\"P2shelf23\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf24 != null : "fx:id=\"P2shelf24\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf30 != null : "fx:id=\"P2shelf30\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf31 != null : "fx:id=\"P2shelf31\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf32 != null : "fx:id=\"P2shelf32\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf33 != null : "fx:id=\"P2shelf33\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf34 != null : "fx:id=\"P2shelf34\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf40 != null : "fx:id=\"P2shelf40\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf41 != null : "fx:id=\"P2shelf41\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf42 != null : "fx:id=\"P2shelf42\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf43 != null : "fx:id=\"P2shelf43\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf44 != null : "fx:id=\"P2shelf44\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf50 != null : "fx:id=\"P2shelf50\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf51 != null : "fx:id=\"P2shelf51\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf52 != null : "fx:id=\"P2shelf52\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf53 != null : "fx:id=\"P2shelf53\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2shelf54 != null : "fx:id=\"P2shelf54\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert stackPaneP3 != null : "fx:id=\"stackPaneP3\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert stackPaneP4 != null : "fx:id=\"stackPaneP4\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3Shelf != null : "fx:id=\"P3Shelf\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf00 != null : "fx:id=\"P3shelf00\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf01 != null : "fx:id=\"P3shelf01\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf02 != null : "fx:id=\"P3shelf02\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf03 != null : "fx:id=\"P3shelf03\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf04 != null : "fx:id=\"P3shelf04\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf10 != null : "fx:id=\"P3shelf10\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf11 != null : "fx:id=\"P3shelf11\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf12 != null : "fx:id=\"P3shelf12\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf13 != null : "fx:id=\"P3shelf13\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf14 != null : "fx:id=\"P3shelf14\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf20 != null : "fx:id=\"P3shelf20\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf21 != null : "fx:id=\"P3shelf21\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf22 != null : "fx:id=\"P3shelf22\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf23 != null : "fx:id=\"P3shelf23\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf24 != null : "fx:id=\"P3shelf24\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf30 != null : "fx:id=\"P3shelf30\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf31 != null : "fx:id=\"P3shelf31\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf32 != null : "fx:id=\"P3shelf32\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf33 != null : "fx:id=\"P3shelf33\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf34 != null : "fx:id=\"P3shelf34\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf40 != null : "fx:id=\"P3shelf40\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf41 != null : "fx:id=\"P3shelf41\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf42 != null : "fx:id=\"P3shelf42\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf43 != null : "fx:id=\"P3shelf43\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf44 != null : "fx:id=\"P3shelf44\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf50 != null : "fx:id=\"P3shelf50\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf51 != null : "fx:id=\"P3shelf51\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf52 != null : "fx:id=\"P3shelf52\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf53 != null : "fx:id=\"P3shelf53\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3shelf54 != null : "fx:id=\"P3shelf54\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4Shelf != null : "fx:id=\"P4Shelf\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf00 != null : "fx:id=\"P4shelf00\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf01 != null : "fx:id=\"P4shelf01\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf02 != null : "fx:id=\"P4shelf02\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf03 != null : "fx:id=\"P4shelf03\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf04 != null : "fx:id=\"P4shelf04\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf10 != null : "fx:id=\"P4shelf10\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf11 != null : "fx:id=\"P4shelf11\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf12 != null : "fx:id=\"P4shelf12\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf13 != null : "fx:id=\"P4shelf13\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf14 != null : "fx:id=\"P4shelf14\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf20 != null : "fx:id=\"P4shelf20\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf21 != null : "fx:id=\"P4shelf21\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf22 != null : "fx:id=\"P4shelf22\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf23 != null : "fx:id=\"P4shelf23\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf24 != null : "fx:id=\"P4shelf24\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf30 != null : "fx:id=\"P4shelf30\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf31 != null : "fx:id=\"P4shelf31\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf32 != null : "fx:id=\"P4shelf32\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf33 != null : "fx:id=\"P4shelf33\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf34 != null : "fx:id=\"P4shelf34\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf40 != null : "fx:id=\"P4shelf40\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf41 != null : "fx:id=\"P4shelf41\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf42 != null : "fx:id=\"P4shelf42\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf43 != null : "fx:id=\"P4shelf43\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf44 != null : "fx:id=\"P4shelf44\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf50 != null : "fx:id=\"P4shelf50\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf51 != null : "fx:id=\"P4shelf51\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf52 != null : "fx:id=\"P4shelf52\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf53 != null : "fx:id=\"P4shelf53\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4shelf54 != null : "fx:id=\"P4shelf54\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert button4 != null : "fx:id=\"button4\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert button5 != null : "fx:id=\"button5\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common1Token1 != null : "fx:id=\"Common1Token1\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common1Token2 != null : "fx:id=\"Common1Token2\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common1Token3 != null : "fx:id=\"Common1Token3\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common1Token4 != null : "fx:id=\"Common1Token4\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common2Token1 != null : "fx:id=\"Common2Token1\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common2Token2 != null : "fx:id=\"Common2Token2\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common2Token3 != null : "fx:id=\"Common2Token3\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert Common2Token4 != null : "fx:id=\"Common2Token4\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert CompleteShelfToken != null : "fx:id=\"CompleteShelfToken\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P1Common1Token != null : "fx:id=\"P1Common1Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P1Common2Token != null : "fx:id=\"P1Common2Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P1CompleteShelfToken != null : "fx:id=\"P1CompleteShelfToken\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2Common1Token != null : "fx:id=\"P2Common1Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2Common2Token != null : "fx:id=\"P2Common2Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P2CompleteShelfToken != null : "fx:id=\"P2CompleteShelfToken\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3Common1Token != null : "fx:id=\"P3Common1Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3Common2Token != null : "fx:id=\"P3Common2Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P3CompleteShelfToken != null : "fx:id=\"P3CompleteShelfToken\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4Common1Token != null : "fx:id=\"P4Common1Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4Common2Token != null : "fx:id=\"P4Common2Token\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert P4CompleteShelfToken != null : "fx:id=\"P4CompleteShelfToken\" was not injected: check your FXML file 'GameScene.fxml'.";
    }

    /**
     * Update the board content.
     * @param boardContent Matrix of {@code BoardCell} representing the board content.
     */
    public void updateBoardContent(BoardCell[][] boardContent) {
        ImageView[][] cellImageViews = new ImageView[Board.MAX_ROWS][Board.MAX_COLUMNS];
        for (int i = 0; i < Board.MAX_ROWS; i++) {
            for (int j = 0; j < Board.MAX_COLUMNS; j++) {
                cellImageViews[i][j] = new ImageView();
            }
        }
        for (int i = 0; i < Board.MAX_ROWS; i++){
            for (int j = 0; j < Board.MAX_COLUMNS; j++){
                if (!boardContent[i][j].isFree()) {
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

    /**
     * Show the nickname of each shelf.
     * @param nicknameList List of the game's players' nicknames.
     */
    public void showShelfNicknames (List<String> nicknameList) {
        String firstPlayerName = clientManager.getNickname();
        Player1Name.setText(firstPlayerName);

        if (nicknameList.size() >= 2) {
            if (!nicknameList.get(0).equals(clientManager.getNickname())) {
                Player2Name.setText(nicknameList.get(0));
            } else {
                Player2Name.setText(nicknameList.get(1));
            }
        }

        if (nicknameList.size() >= 3) {
            if (!nicknameList.get(0).equals(clientManager.getNickname())) {
                Player2Name.setText(nicknameList.get(0));
                if (!nicknameList.get(1).equals(clientManager.getNickname())) {
                    Player3Name.setText(nicknameList.get(1));
                } else {
                    Player3Name.setText(nicknameList.get(2));
                }
            } else {
                Player2Name.setText(nicknameList.get(1));
                Player3Name.setText(nicknameList.get(2));
            }
        }

        if (nicknameList.size() >= 4) {
            if (!nicknameList.get(0).equals(clientManager.getNickname())) {
                Player2Name.setText(nicknameList.get(0));

                if (!nicknameList.get(1).equals(clientManager.getNickname())) {
                    Player3Name.setText(nicknameList.get(1));
                    if (!nicknameList.get(2).equals(clientManager.getNickname())) {
                        Player4Name.setText(nicknameList.get(2));
                    } else {
                        Player4Name.setText(nicknameList.get(3));
                    }
                } else {
                    Player3Name.setText(nicknameList.get(2));
                    Player4Name.setText(nicknameList.get(3));
                }
            } else {
                Player2Name.setText(nicknameList.get(1));
                Player3Name.setText(nicknameList.get(2));
                Player4Name.setText(nicknameList.get(3));
            }
        }
    }

    /**
     * Shows the information of each player in terms of nickname, shelf content, scoring token achieved and end game token.
     * The current player is shown on the right side of the board, while other players are shown under the board.
     * @param nickname The nickname of the player.
     * @param shelfContent Matrix of {@code ShelfCell} representing the shelf of the player.
     * @param cgc1 {@code ScoringToken} associated to the first {@code CommonGoalCard}.
     * @param cgc2 {@code ScoringToken} associated to the second {@code CommonGoalCard}.
     * @param egt Boolean representing if the player achieved the end game token.
     */
    public void updateShelfContent(String nickname, ShelfCell[][] shelfContent, ScoringToken cgc1, ScoringToken cgc2, boolean egt) {
        ImageView[][] cellImageViews = new ImageView[Shelf.ROWS][Shelf.COLUMNS];
        for (int i = 0; i < Shelf.ROWS; i++) {
            for (int j = 0; j < Shelf.COLUMNS; j++) {
                cellImageViews[i][j] = new ImageView();
            }
        }
        for(int i = 0; i < Shelf.ROWS; i++){
            for(int j = 0; j < Shelf.COLUMNS; j++){
                if(!shelfContent[i][j].isFree()) {
                    ItemTileType itemTileType = shelfContent[i][j].getTile().getItemTileType();
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

        if (nickname.equals(Player1Name.getText())){
            updateP1ShelfImages(cellImageViews);
            if (cgc1 != null)
                P1Common1Token.setImage(updateScoringTokenImage(cgc1));
            if (cgc2 != null)
                P1Common2Token.setImage(updateScoringTokenImage(cgc2));
            if (egt)
                P1CompleteShelfToken.setImage(new Image("/assets/scoring tokens/end game.jpg"));
        }
        if(nickname.equals(Player2Name.getText())){
            updateP2ShelfImages(cellImageViews);
            if (cgc1 != null)
                P2Common1Token.setImage(updateScoringTokenImage(cgc1));
            if (cgc2 != null)
                P2Common2Token.setImage(updateScoringTokenImage(cgc2));
            if (egt)
                P2CompleteShelfToken.setImage(new Image("/assets/scoring tokens/end game.jpg"));
        }
        if(nickname.equals(Player3Name.getText())){
            updateP3ShelfImages(cellImageViews);
            if (cgc1 != null)
                P3Common1Token.setImage(updateScoringTokenImage(cgc1));
            if (cgc2 != null)
                P3Common2Token.setImage(updateScoringTokenImage(cgc2));
            if (egt)
                P3CompleteShelfToken.setImage(new Image("/assets/scoring tokens/end game.jpg"));
        }
        if(nickname.equals(Player4Name.getText())){
            updateP4ShelfImages(cellImageViews);
            if (cgc1 != null)
                P4Common1Token.setImage(updateScoringTokenImage(cgc1));
            if (cgc2 != null)
                P4Common2Token.setImage(updateScoringTokenImage(cgc2));
            if (egt)
                P4CompleteShelfToken.setImage(new Image("/assets/scoring tokens/end game.jpg"));
        }
    }

    private void updateP1ShelfImages(ImageView[][] cellImageViews) {
        P1shelf00.setImage(cellImageViews[0][0].getImage());
        P1shelf01.setImage(cellImageViews[0][1].getImage());
        P1shelf02.setImage(cellImageViews[0][2].getImage());
        P1shelf03.setImage(cellImageViews[0][3].getImage());
        P1shelf04.setImage(cellImageViews[0][4].getImage());
        P1shelf10.setImage(cellImageViews[1][0].getImage());
        P1shelf11.setImage(cellImageViews[1][1].getImage());
        P1shelf12.setImage(cellImageViews[1][2].getImage());
        P1shelf13.setImage(cellImageViews[1][3].getImage());
        P1shelf14.setImage(cellImageViews[1][4].getImage());
        P1shelf20.setImage(cellImageViews[2][0].getImage());
        P1shelf21.setImage(cellImageViews[2][1].getImage());
        P1shelf22.setImage(cellImageViews[2][2].getImage());
        P1shelf23.setImage(cellImageViews[2][3].getImage());
        P1shelf24.setImage(cellImageViews[2][4].getImage());
        P1shelf30.setImage(cellImageViews[3][0].getImage());
        P1shelf31.setImage(cellImageViews[3][1].getImage());
        P1shelf32.setImage(cellImageViews[3][2].getImage());
        P1shelf33.setImage(cellImageViews[3][3].getImage());
        P1shelf34.setImage(cellImageViews[3][4].getImage());
        P1shelf40.setImage(cellImageViews[4][0].getImage());
        P1shelf41.setImage(cellImageViews[4][1].getImage());
        P1shelf42.setImage(cellImageViews[4][2].getImage());
        P1shelf43.setImage(cellImageViews[4][3].getImage());
        P1shelf44.setImage(cellImageViews[4][4].getImage());
        P1shelf50.setImage(cellImageViews[5][0].getImage());
        P1shelf51.setImage(cellImageViews[5][1].getImage());
        P1shelf52.setImage(cellImageViews[5][2].getImage());
        P1shelf53.setImage(cellImageViews[5][3].getImage());
        P1shelf54.setImage(cellImageViews[5][4].getImage());
    }

    private void updateP2ShelfImages(ImageView[][] cellImageViews) {
        P2shelf00.setImage(cellImageViews[0][0].getImage());
        P2shelf01.setImage(cellImageViews[0][1].getImage());
        P2shelf02.setImage(cellImageViews[0][2].getImage());
        P2shelf03.setImage(cellImageViews[0][3].getImage());
        P2shelf04.setImage(cellImageViews[0][4].getImage());
        P2shelf10.setImage(cellImageViews[1][0].getImage());
        P2shelf11.setImage(cellImageViews[1][1].getImage());
        P2shelf12.setImage(cellImageViews[1][2].getImage());
        P2shelf13.setImage(cellImageViews[1][3].getImage());
        P2shelf14.setImage(cellImageViews[1][4].getImage());
        P2shelf20.setImage(cellImageViews[2][0].getImage());
        P2shelf21.setImage(cellImageViews[2][1].getImage());
        P2shelf22.setImage(cellImageViews[2][2].getImage());
        P2shelf23.setImage(cellImageViews[2][3].getImage());
        P2shelf24.setImage(cellImageViews[2][4].getImage());
        P2shelf30.setImage(cellImageViews[3][0].getImage());
        P2shelf31.setImage(cellImageViews[3][1].getImage());
        P2shelf32.setImage(cellImageViews[3][2].getImage());
        P2shelf33.setImage(cellImageViews[3][3].getImage());
        P2shelf34.setImage(cellImageViews[3][4].getImage());
        P2shelf40.setImage(cellImageViews[4][0].getImage());
        P2shelf41.setImage(cellImageViews[4][1].getImage());
        P2shelf42.setImage(cellImageViews[4][2].getImage());
        P2shelf43.setImage(cellImageViews[4][3].getImage());
        P2shelf44.setImage(cellImageViews[4][4].getImage());
        P2shelf50.setImage(cellImageViews[5][0].getImage());
        P2shelf51.setImage(cellImageViews[5][1].getImage());
        P2shelf52.setImage(cellImageViews[5][2].getImage());
        P2shelf53.setImage(cellImageViews[5][3].getImage());
        P2shelf54.setImage(cellImageViews[5][4].getImage());
    }

    private void updateP3ShelfImages(ImageView[][] cellImageViews) {
        P3shelf00.setImage(cellImageViews[0][0].getImage());
        P3shelf01.setImage(cellImageViews[0][1].getImage());
        P3shelf02.setImage(cellImageViews[0][2].getImage());
        P3shelf03.setImage(cellImageViews[0][3].getImage());
        P3shelf04.setImage(cellImageViews[0][4].getImage());
        P3shelf10.setImage(cellImageViews[1][0].getImage());
        P3shelf11.setImage(cellImageViews[1][1].getImage());
        P3shelf12.setImage(cellImageViews[1][2].getImage());
        P3shelf13.setImage(cellImageViews[1][3].getImage());
        P3shelf14.setImage(cellImageViews[1][4].getImage());
        P3shelf20.setImage(cellImageViews[2][0].getImage());
        P3shelf21.setImage(cellImageViews[2][1].getImage());
        P3shelf22.setImage(cellImageViews[2][2].getImage());
        P3shelf23.setImage(cellImageViews[2][3].getImage());
        P3shelf24.setImage(cellImageViews[2][4].getImage());
        P3shelf30.setImage(cellImageViews[3][0].getImage());
        P3shelf31.setImage(cellImageViews[3][1].getImage());
        P3shelf32.setImage(cellImageViews[3][2].getImage());
        P3shelf33.setImage(cellImageViews[3][3].getImage());
        P3shelf34.setImage(cellImageViews[3][4].getImage());
        P3shelf40.setImage(cellImageViews[4][0].getImage());
        P3shelf41.setImage(cellImageViews[4][1].getImage());
        P3shelf42.setImage(cellImageViews[4][2].getImage());
        P3shelf43.setImage(cellImageViews[4][3].getImage());
        P3shelf44.setImage(cellImageViews[4][4].getImage());
        P3shelf50.setImage(cellImageViews[5][0].getImage());
        P3shelf51.setImage(cellImageViews[5][1].getImage());
        P3shelf52.setImage(cellImageViews[5][2].getImage());
        P3shelf53.setImage(cellImageViews[5][3].getImage());
        P3shelf54.setImage(cellImageViews[5][4].getImage());
    }

    private void updateP4ShelfImages(ImageView[][] cellImageViews) {
        P4shelf00.setImage(cellImageViews[0][0].getImage());
        P4shelf01.setImage(cellImageViews[0][1].getImage());
        P4shelf02.setImage(cellImageViews[0][2].getImage());
        P4shelf03.setImage(cellImageViews[0][3].getImage());
        P4shelf04.setImage(cellImageViews[0][4].getImage());
        P4shelf10.setImage(cellImageViews[1][0].getImage());
        P4shelf11.setImage(cellImageViews[1][1].getImage());
        P4shelf12.setImage(cellImageViews[1][2].getImage());
        P4shelf13.setImage(cellImageViews[1][3].getImage());
        P4shelf14.setImage(cellImageViews[1][4].getImage());
        P4shelf20.setImage(cellImageViews[2][0].getImage());
        P4shelf21.setImage(cellImageViews[2][1].getImage());
        P4shelf22.setImage(cellImageViews[2][2].getImage());
        P4shelf23.setImage(cellImageViews[2][3].getImage());
        P4shelf24.setImage(cellImageViews[2][4].getImage());
        P4shelf30.setImage(cellImageViews[3][0].getImage());
        P4shelf31.setImage(cellImageViews[3][1].getImage());
        P4shelf32.setImage(cellImageViews[3][2].getImage());
        P4shelf33.setImage(cellImageViews[3][3].getImage());
        P4shelf34.setImage(cellImageViews[3][4].getImage());
        P4shelf40.setImage(cellImageViews[4][0].getImage());
        P4shelf41.setImage(cellImageViews[4][1].getImage());
        P4shelf42.setImage(cellImageViews[4][2].getImage());
        P4shelf43.setImage(cellImageViews[4][3].getImage());
        P4shelf44.setImage(cellImageViews[4][4].getImage());
        P4shelf50.setImage(cellImageViews[5][0].getImage());
        P4shelf51.setImage(cellImageViews[5][1].getImage());
        P4shelf52.setImage(cellImageViews[5][2].getImage());
        P4shelf53.setImage(cellImageViews[5][3].getImage());
        P4shelf54.setImage(cellImageViews[5][4].getImage());
    }

    /**
     * Shows the correct {@code PersonalGoalCard} based on its serial number.
     * @param personalGoalCard The {@code PersonalGoalCard} to be shown.
     */
    public void updatePersonalGoalCard(PersonalGoalCard personalGoalCard) {
        Image image;
        if (personalGoalCard.getSerialNumber() == 1)
            image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals.png")));
        else
            image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/personal goal cards/Personal_Goals" + personalGoalCard.getSerialNumber() + ".png")));
        PersonalGoalCard.setImage(image);
    }

    /**
     * Shows the correct {@code CommonGoalCard} based on its serial number and the stack of {@code ScoringToken} contained.
     * @param commonGoalCard The {@code CommonGoalCard} to be shown.
     * @param progressiveCard A number representing the order of the {@code CommonGoalCard} in the game.
     */
    public void updateCommonGoalCard(CommonGoalCard commonGoalCard, Integer progressiveCard) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/common goal cards/" + commonGoalCard.getSerialNumber() + ".jpg")));
        List<ScoringToken> tokens = commonGoalCard.getScoringTokens();
        if (progressiveCard == 1) {
            CommonGoalCard1.setImage(image);
            Common1Token1.setImage(null);
            Common1Token2.setImage(null);
            Common1Token3.setImage(null);
            Common1Token4.setImage(null);
            if (tokens.size() >= 1)
                Common1Token1.setImage(updateScoringTokenImage(tokens.get(0)));
            if (tokens.size() >= 2)
                Common1Token2.setImage(updateScoringTokenImage(tokens.get(1)));
            if (tokens.size() >= 3)
                Common1Token3.setImage(updateScoringTokenImage(tokens.get(2)));
            if (tokens.size() >= 4)
                Common1Token4.setImage(updateScoringTokenImage(tokens.get(3)));
        } else {
            CommonGoalCard2.setImage(image);
            Common2Token1.setImage(null);
            Common2Token2.setImage(null);
            Common2Token3.setImage(null);
            Common2Token4.setImage(null);
            if (tokens.size() >= 1)
                Common2Token1.setImage(updateScoringTokenImage(tokens.get(0)));
            if (tokens.size() >= 2)
                Common2Token2.setImage(updateScoringTokenImage(tokens.get(1)));
            if (tokens.size() >= 3)
                Common2Token3.setImage(updateScoringTokenImage(tokens.get(2)));
            if (tokens.size() >= 4)
                Common2Token4.setImage(updateScoringTokenImage(tokens.get(3)));
        }
    }

    private Image updateScoringTokenImage (ScoringToken token) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/scoring tokens/scoring_" + token.score() + ".jpg")));
    }

    /**
     * @return The {@code ClientManager} associated with the client.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Sets the current manager to the current {@code ClientManager}.
     * @param clientManager The {@code ClientManager} associated with the client.
     */
    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @FXML
    void pickUpFromBoard (MouseEvent event) {
        if (pickUpEnabled && positions.size() < 3) {
            Node tile = (Node) event.getTarget();
            int row, column;
            try {
                row = GridPane.getRowIndex(tile);
            } catch (NullPointerException e) {
                row = 0;
            }
            try {
                column = GridPane.getColumnIndex(tile);
            } catch (NullPointerException e) {
                column = 0;
            }
            try {
                Position position = new Position(row, column);
                if (!position.equals(new Position(0, 0))) {
                    if (!positions.contains(position)) {
                        positions.add(position);
                        tile.setEffect(new InnerShadow(BlurType.THREE_PASS_BOX, new Color(0.4, 1, 0.36, 1), 10, 0.9, -1, 0));
                        blurredNodes.add(tile);
                        Image image = getImageFromGrid(gridPane, row, column);
                        if (image != null) {
                            tilesImages.add(image);
                        }
                    }
                }
            } catch (NullPointerException e) {
                updateMessageBox("Invalid position, please try again...");
            }
        }
    }

    /**
     * Enables the picking-up procedure of the tiles from the board.
     */
    public void enablePickingUp () {
        positions.clear();
        this.pickUpEnabled = true;
        blurredNodes.clear();
        this.resetTurnButton.setVisible(true);
    }

    private Image getImageFromGrid(GridPane grid, int row, int column) {
        for (Node node : grid.getChildren()) {
            if (GridPane.getRowIndex(node) != null &&
                    GridPane.getColumnIndex(node) != null &&
                    GridPane.getRowIndex(node) == row &&
                    GridPane.getColumnIndex(node) == column) {
                if (node instanceof ImageView imageView) {
                    return imageView.getImage();
                }
            }
        }
        return null;
    }

    /**
     * Restarts the turn of the current player when the "Reset Turn" button is clicked.
     * It clears the position's list so new positions can be chosen.
     */
    public void resetTurnButtonClicked () {
        for (Node tile : blurredNodes) {
            tile.setEffect(null);
        }
        blurredNodes.clear();
        positions.clear();
        pickUpEnabled = true;
        resetTurnButton.setVisible(true);
    }

    /**
     * Hides the unused shelf when the number of the player is lower than {@code Game.MAX_PLAYERS}.
     * @param numPlayers The number of the players in the game.
     */
    public void hideShelf (int numPlayers) {
        switch (numPlayers) {
            case 2 -> {
                Player3Name.setVisible(false);
                Player4Name.setVisible(false);
                stackPaneP3.setVisible(false);
                stackPaneP4.setVisible(false);
            }
            case 3 -> {
                Player4Name.setVisible(false);
                stackPaneP4.setVisible(false);
            }
        }
    }

    /**
     * Terminates the procedure of picking up tiles.
     */
    private void terminatePickingUp() {
        pickUpEnabled = false;
        for (Node tile : blurredNodes) {
            tile.setEffect(null);
        }
        blurredNodes.clear();
        resetTurnButton.setVisible(false);
    }

    @FXML
    void sendTilesToColumn0 (ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 0);
        terminatePickingUp();
    }

    @FXML
    void sendTilesToColumn1 (ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 1);
        terminatePickingUp();
    }

    @FXML
    void sendTilesToColumn2 (ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 2);
        terminatePickingUp();
    }

    @FXML
    void sendTilesToColumn3 (ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 3);
        terminatePickingUp();
    }

    @FXML
    void sendTilesToColumn4 (ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 4);
        terminatePickingUp();
    }

    /**
     * Updates the message box with the message passed as parameter.
     * @param message The message to show on the message box.
     */
    public void updateMessageBox (String message) {
        if (message.equalsIgnoreCase("Connection lost with the server.") ||
                message.equalsIgnoreCase("Game finished! Thanks for playing with us.") ||
                message.equalsIgnoreCase("Disconnecting from the server. You can close safely the program.") ) {
            messageBox.setText(messageBox.getText() + "\n" + message);
        } else {
            messageBox.setText(message);
        }
    }

    /**
     * Shows the final score board on the text area.
     * @param scoreBoardMap {@code Map} containing the final score board.
     */
    public void updateFinalScoreBoard (Map<String, Integer> scoreBoardMap) {
        StringBuilder scoreBoardMessage = new StringBuilder("FINAL SCOREBOARD\n");
        for (Map.Entry<String, Integer> entry : scoreBoardMap.entrySet()) {
            scoreBoardMessage.append(entry.getKey()).append(": ").append(entry.getValue()).append(" points\n");
        }
        updateMessageBox(scoreBoardMessage.toString());
    }
}
