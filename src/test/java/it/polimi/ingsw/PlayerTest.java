package it.polimi.ingsw;


import it.polimi.ingsw.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class PlayerTest {

    Player player;

    @BeforeEach
    void setUp(){
        this.player= new Player("ambrogio");
    }

    @Test
    @DisplayName("Is first player true")
    void IsFirstPlayerTest(){
        player.setFirstPlayer();
        Assertions.assertTrue(player.isFirstPlayer());
    }

    @Test
    void IsNotFirstPlayerTest(){
        Assertions.assertFalse(player.isFirstPlayer());
    }

    @Test
    void hasEndGameTokenTest(){
        player.setEndGameToken();
        Assertions.assertTrue(player.hasEndGameToken());
    }

    @Test
    void hasNotEndGameTokenTest(){
        Assertions.assertFalse(player.hasEndGameToken());
    }

    @Test
    void addFiveToScoreTest(){
        player.addScore(5);
        Assertions.assertEquals(5, player.getScore());
        System.out.println("score: " + player.getScore());
    }
}
