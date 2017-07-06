package yehtzee.game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import yehtzee.game.scorecalculator.IScoreCalculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by devil jin on 6/9/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameYehtzeeTest {
    @Mock
    IScoreCalculator scoreCalculator;
    @InjectMocks
    private  GameYehtzee game;
    private   ScoreSet scoreSet;


    @Before
    public void  setup() {

        scoreSet = new ScoreSet();
    }

    @Test
    public void testFindTotalScoreForGame() {
        int score = game.getTotalScore(scoreSet);
        assertThat(score, is(equalTo(0)));
    }

    @Test
    public void testScoreWhenDicePatternChance() {
        when(scoreCalculator.findScore(any(int[].class))).thenReturn(18);
        scoreSet.addDicePattern(new int[]{ 1,6,4,2,5});
        int score = game.getTotalScore(scoreSet);
        assertThat(score, is(equalTo(18)));
    }


    @Test
    public void testScoreWhenDicePatternYahtzee() {
        when(scoreCalculator.findScore(eq(new int[]{ 1,1,1,1,1}))).thenReturn(50);
        when(scoreCalculator.findScore(eq(new int[]{ 1,6,4,2,5}))).thenReturn(18);
        scoreSet.addDicePattern(new int[]{ 1,1,1,1,1});
        scoreSet.addDicePattern(new int[]{ 1,6,4,2,5});
        int score = game.getTotalScore(scoreSet);
        assertThat(score, is(equalTo(68)));

    }















}
