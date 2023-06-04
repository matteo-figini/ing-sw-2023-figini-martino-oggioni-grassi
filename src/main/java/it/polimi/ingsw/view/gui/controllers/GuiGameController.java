package it.polimi.ingsw.view.gui.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.commongoals.CommonGoalCard;
import it.polimi.ingsw.model.personalgoals.PersonalGoalCard;
import it.polimi.ingsw.network.ClientManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GuiGameController {
    private ClientManager clientManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    int numOfPositions=0;

    private int indexP1 = -1;
    private int cont = 0;
    private int P2done = 0;
    private int P3done = 0;

    List<Position> positions = new ArrayList<>();
    List<Image> tilesImages = new ArrayList<>();

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
    private StackPane stackPaneP3;

    @FXML
    private StackPane stackPaneP4;

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
        assert P1Shelf != null : "fx:id=\"P1Shelf\" was not injected: check your FXML file 'game.fxml'.";
        assert P2Shelf != null : "fx:id=\"P2Shelf\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf00 != null : "fx:id=\"P2shelf00\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf01 != null : "fx:id=\"P2shelf01\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf02 != null : "fx:id=\"P2shelf02\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf03 != null : "fx:id=\"P2shelf03\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf04 != null : "fx:id=\"P2shelf04\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf10 != null : "fx:id=\"P2shelf10\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf11 != null : "fx:id=\"P2shelf11\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf12 != null : "fx:id=\"P2shelf12\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf13 != null : "fx:id=\"P2shelf13\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf14 != null : "fx:id=\"P2shelf14\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf20 != null : "fx:id=\"P2shelf20\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf21 != null : "fx:id=\"P2shelf21\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf22 != null : "fx:id=\"P2shelf22\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf23 != null : "fx:id=\"P2shelf23\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf24 != null : "fx:id=\"P2shelf24\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf30 != null : "fx:id=\"P2shelf30\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf31 != null : "fx:id=\"P2shelf31\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf32 != null : "fx:id=\"P2shelf32\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf33 != null : "fx:id=\"P2shelf33\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf34 != null : "fx:id=\"P2shelf34\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf40 != null : "fx:id=\"P2shelf40\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf41 != null : "fx:id=\"P2shelf41\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf42 != null : "fx:id=\"P2shelf42\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf43 != null : "fx:id=\"P2shelf43\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf44 != null : "fx:id=\"P2shelf44\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf50 != null : "fx:id=\"P2shelf50\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf51 != null : "fx:id=\"P2shelf51\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf52 != null : "fx:id=\"P2shelf52\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf53 != null : "fx:id=\"P2shelf53\" was not injected: check your FXML file 'game.fxml'.";
        assert P2shelf54 != null : "fx:id=\"P2shelf54\" was not injected: check your FXML file 'game.fxml'.";
        assert stackPaneP3 != null : "fx:id=\"stackPaneP3\" was not injected: check your FXML file 'game.fxml'.";
        assert stackPaneP4 != null : "fx:id=\"stackPaneP4\" was not injected: check your FXML file 'game.fxml'.";
        assert P3Shelf != null : "fx:id=\"P3Shelf\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf00 != null : "fx:id=\"P3shelf00\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf01 != null : "fx:id=\"P3shelf01\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf02 != null : "fx:id=\"P3shelf02\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf03 != null : "fx:id=\"P3shelf03\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf04 != null : "fx:id=\"P3shelf04\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf10 != null : "fx:id=\"P3shelf10\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf11 != null : "fx:id=\"P3shelf11\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf12 != null : "fx:id=\"P3shelf12\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf13 != null : "fx:id=\"P3shelf13\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf14 != null : "fx:id=\"P3shelf14\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf20 != null : "fx:id=\"P3shelf20\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf21 != null : "fx:id=\"P3shelf21\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf22 != null : "fx:id=\"P3shelf22\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf23 != null : "fx:id=\"P3shelf23\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf24 != null : "fx:id=\"P3shelf24\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf30 != null : "fx:id=\"P3shelf30\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf31 != null : "fx:id=\"P3shelf31\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf32 != null : "fx:id=\"P3shelf32\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf33 != null : "fx:id=\"P3shelf33\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf34 != null : "fx:id=\"P3shelf34\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf40 != null : "fx:id=\"P3shelf40\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf41 != null : "fx:id=\"P3shelf41\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf42 != null : "fx:id=\"P3shelf42\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf43 != null : "fx:id=\"P3shelf43\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf44 != null : "fx:id=\"P3shelf44\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf50 != null : "fx:id=\"P3shelf50\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf51 != null : "fx:id=\"P3shelf51\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf52 != null : "fx:id=\"P3shelf52\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf53 != null : "fx:id=\"P3shelf53\" was not injected: check your FXML file 'game.fxml'.";
        assert P3shelf54 != null : "fx:id=\"P3shelf54\" was not injected: check your FXML file 'game.fxml'.";
        assert P4Shelf != null : "fx:id=\"P4Shelf\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf00 != null : "fx:id=\"P4shelf00\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf01 != null : "fx:id=\"P4shelf01\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf02 != null : "fx:id=\"P4shelf02\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf03 != null : "fx:id=\"P4shelf03\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf04 != null : "fx:id=\"P4shelf04\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf10 != null : "fx:id=\"P4shelf10\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf11 != null : "fx:id=\"P4shelf11\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf12 != null : "fx:id=\"P4shelf12\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf13 != null : "fx:id=\"P4shelf13\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf14 != null : "fx:id=\"P4shelf14\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf20 != null : "fx:id=\"P4shelf20\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf21 != null : "fx:id=\"P4shelf21\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf22 != null : "fx:id=\"P4shelf22\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf23 != null : "fx:id=\"P4shelf23\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf24 != null : "fx:id=\"P4shelf24\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf30 != null : "fx:id=\"P4shelf30\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf31 != null : "fx:id=\"P4shelf31\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf32 != null : "fx:id=\"P4shelf32\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf33 != null : "fx:id=\"P4shelf33\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf34 != null : "fx:id=\"P4shelf34\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf40 != null : "fx:id=\"P4shelf40\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf41 != null : "fx:id=\"P4shelf41\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf42 != null : "fx:id=\"P4shelf42\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf43 != null : "fx:id=\"P4shelf43\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf44 != null : "fx:id=\"P4shelf44\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf50 != null : "fx:id=\"P4shelf50\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf51 != null : "fx:id=\"P4shelf51\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf52 != null : "fx:id=\"P4shelf52\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf53 != null : "fx:id=\"P4shelf53\" was not injected: check your FXML file 'game.fxml'.";
        assert P4shelf54 != null : "fx:id=\"P4shelf54\" was not injected: check your FXML file 'game.fxml'.";
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'game.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'game.fxml'.";
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'game.fxml'.";
        assert button4 != null : "fx:id=\"button4\" was not injected: check your FXML file 'game.fxml'.";
        assert button5 != null : "fx:id=\"button5\" was not injected: check your FXML file 'game.fxml'.";
    }

    public void updateBoardContent(BoardCell[][] boardContent) {
        ImageView[][] cellImageViews = new ImageView[9][9];
        Image image;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellImageViews[i][j] = new ImageView();
            }
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9 ; j++){
                if(!boardContent[i][j].isFree()) {
                    ItemTileType itemTileType = boardContent[i][j].getItemTile().getItemTileType();
                    image = null;
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

        for (Position position : positions) {
            int row = position.getX();
            int col = position.getY();
            cellImageViews[row][col].setImage(null);
        }

        positions.clear();
        tilesImages.clear();
        numOfPositions = 0;

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

    public void showShelfNicknames(List<String> nicknameList) {
        String nomePrimoGiocatore = clientManager.getNickname();
        Player1Name.setText(nomePrimoGiocatore);

        if (nicknameList.size() >= 2) {
            if (!nicknameList.get(0).equals(clientManager.getNickname())) {
                String nomeSecondoGiocatore = nicknameList.get(0);
                Player2Name.setText(nomeSecondoGiocatore);
            } else {
                String nomeSecondoGiocatore = nicknameList.get(1);
                Player2Name.setText(nomeSecondoGiocatore);
            }
        }

        if (nicknameList.size() >= 3) {
            if (!nicknameList.get(0).equals(clientManager.getNickname())) {
                String nomeSecondoGiocatore = nicknameList.get(0);
                Player2Name.setText(nomeSecondoGiocatore);

                if (!nicknameList.get(1).equals(clientManager.getNickname())) {
                    String nomeTerzoGiocatore = nicknameList.get(1);
                    Player3Name.setText(nomeTerzoGiocatore);
                } else {
                    String nomeTerzoGiocatore = nicknameList.get(2);
                    Player3Name.setText(nomeTerzoGiocatore);
                }
            } else {
                String nomeSecondoGiocatore = nicknameList.get(1);
                Player2Name.setText(nomeSecondoGiocatore);

                String nomeTerzoGiocatore = nicknameList.get(2);
                Player3Name.setText(nomeTerzoGiocatore);
            }
        }

        if (nicknameList.size() >= 4) {
            if (!nicknameList.get(0).equals(clientManager.getNickname())) {
                String nomeSecondoGiocatore = nicknameList.get(0);
                Player2Name.setText(nomeSecondoGiocatore);

                if (!nicknameList.get(1).equals(clientManager.getNickname())) {
                    String nomeTerzoGiocatore = nicknameList.get(1);
                    Player3Name.setText(nomeTerzoGiocatore);

                    if (!nicknameList.get(2).equals(clientManager.getNickname())) {
                        String nomeQuartoGiocatore = nicknameList.get(2);
                        Player4Name.setText(nomeQuartoGiocatore);
                    } else {
                        String nomeQuartoGiocatore = nicknameList.get(3);
                        Player4Name.setText(nomeQuartoGiocatore);
                    }
                } else {
                    String nomeTerzoGiocatore = nicknameList.get(2);
                    Player3Name.setText(nomeTerzoGiocatore);

                    String nomeQuartoGiocatore = nicknameList.get(3);
                    Player4Name.setText(nomeQuartoGiocatore);
                }
            } else {
                String nomeSecondoGiocatore = nicknameList.get(1);
                Player2Name.setText(nomeSecondoGiocatore);

                String nomeTerzoGiocatore = nicknameList.get(2);
                Player3Name.setText(nomeTerzoGiocatore);

                String nomeQuartoGiocatore = nicknameList.get(3);
                Player4Name.setText(nomeQuartoGiocatore);
            }
        }
    }

    public void updateShelfContent(ShelfCell[][] shelfContent, String nickname) {
        ImageView[][] cellImageViews = new ImageView[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                cellImageViews[i][j] = new ImageView();
            }
        }
        for(int i=0; i<6; i++){
            for(int j=0; j<5 ; j++){
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

        if(nickname.equals(Player1Name.getText())){
            updateP1ShelfImages(cellImageViews);
        }
        if(nickname.equals(Player2Name.getText())){
            updateP2ShelfImages(cellImageViews);
        }
        if(nickname.equals(Player3Name.getText())){
            updateP3ShelfImages(cellImageViews);
        }
        if(nickname.equals(Player4Name.getText())){
            updateP4ShelfImages(cellImageViews);
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

    private int getPlayerShelfIndex(String nickname, List<String> nicknameList) {
        for (int i = 0; i < nicknameList.size(); i++) {
            if (nicknameList.get(i).equals(nickname)) {
                return i;  // Restituisce l'indice della griglia corrispondente al giocatore
            }
        }
        return -1;  // Giocatore non trovato
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

    public void updateCommonGoalCard(CommonGoalCard commonGoalCard, Integer progressiveCard) {
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
        if(progressiveCard == 1){
            CommonGoalCard1.setImage(image);
        }
        if(progressiveCard == 2){
            CommonGoalCard2.setImage(image);
        }
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @FXML
    void PickUpFromBoard(MouseEvent event) {
        if(numOfPositions < 5) {
            Node tile = (Node) event.getTarget();
            int row = GridPane.getRowIndex(tile);
            int column = GridPane.getColumnIndex(tile);
            positions.add(new Position(row, column));
            tile.setEffect(new InnerShadow(BlurType.THREE_PASS_BOX, new Color(0.4, 1, 0.36, 1), 10, 0.9, -1, 0));
            Image image = getImageFromGrid(gridPane, row, column);
            if (image != null) {
                tilesImages.add(image);
            }
            numOfPositions++;
        }
    }

    private Image getImageFromGrid(GridPane grid, int row, int column) {
        for (Node node : grid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                if (node instanceof ImageView imageView) {
                    return imageView.getImage();
                }
            }
        }
        return null;
    }

    public void hideShelf(int numPlayers){
        if(numPlayers == 2){
            Player3Name.setVisible(false);
            Player4Name.setVisible(false);
            stackPaneP3.setVisible(false);
            stackPaneP4.setVisible(false);
        }
        if(numPlayers == 3){
            Player4Name.setVisible(false);
            stackPaneP4.setVisible(false);
        }
    }

    @FXML
    void SendTiles1(ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 0);
    }

    @FXML
    void SendTiles2(ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 1);
    }

    @FXML
    void SendTiles3(ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 2);
    }

    @FXML
    void SendTiles4(ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 3);
    }

    @FXML
    void SendTiles5(ActionEvent event) {
        clientManager.onUpdateColumnAndPosition(positions, 4);
    }
}
