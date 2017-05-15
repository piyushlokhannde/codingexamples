package test.java.bowling.game;

import main.java.bowling.game.Game;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by devil jin on 4/19/2017.
 */
public class TestGame {



    @Test
    public void testGameScoreAfterFirstFrame() {
        Game game = new Game();
        if(game.hasNextRoll()) {
            game.setScoreForTheCurrentRoll(3);
        }
        if(game.hasNextRoll()) {
            game.setScoreForTheCurrentRoll(3);
        }
        assertThat(game.getGameScore(),is(equalTo(6)));
    }

    @Test
    public void testGameScoreAfterEachFrameHasScoreTen() {
        Game game = new Game();
        while(game.hasNextRoll()) {
            game.setScoreForTheCurrentRoll(10);
        }
        assertThat(game.getGameScore(),is(equalTo(300)));
    }

    @Test
    public void testGameScoreAfterEachFrameHasScoreAsTwo() {
        Game game = new Game();
        while(game.hasNextRoll()) {
            game.setScoreForTheCurrentRoll(2);
        }
        assertThat(game.getGameScore(),is(equalTo(40)));
    }

    @Test
    public void testGameScoreAfterEachFrameHasScoreAsZero() {
        Game game = new Game();
        while(game.hasNextRoll()) {
            game.setScoreForTheCurrentRoll(0);
        }
        assertThat(game.getGameScore(),is(equalTo(0)));
    }

    @Test
    public void testGameScoreAfterEachFrameHasScoreAsEvenAsTwoOddAsThree() {
        Game game = new Game();
       int i=1;
        while(game.hasNextRoll()) {
            if(i%2==0) {
                game.setScoreForTheCurrentRoll(2);
            } else {
                game.setScoreForTheCurrentRoll(3);
            }
          i++;
        }
        assertThat(game.getGameScore(),is(equalTo(50)));
    }
}





