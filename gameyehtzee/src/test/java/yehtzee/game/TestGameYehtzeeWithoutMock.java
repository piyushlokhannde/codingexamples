package yehtzee.game;

import org.junit.Before;
import org.junit.Test;
import yehtzee.game.scorecalculator.IScoreCalculator;
import yehtzee.game.scorecalculator.ScoreCalculator;
import yehtzee.game.scorecalculator.scorerules.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by devil jin on 7/5/2017.
 */
public class TestGameYehtzeeWithoutMock {

    private GameYehtzee game;

    @Before
    public void init() {

        IScoreRule  yahtzeeRule= new YahtzeeRule();
        IScoreRule chanceRule = new ChanceRule();
        IScoreRule sumOneRule = new SumOfDiceNumber(1);
        IScoreRule sumTwoRule = new SumOfDiceNumber(2);
        IScoreRule sumThreeRule = new SumOfDiceNumber(3);
        IScoreRule  sumFourRule = new SumOfDiceNumber(4);
        IScoreRule  sumFiveRule = new SumOfDiceNumber(5);
        IScoreRule sumSixRule = new SumOfDiceNumber(6);
        IScoreRule pairRule =new NKindOfRule(2);
        IScoreRule  twoParRule = new TwoPairRule();
        IScoreRule threeOfKindRule = new NKindOfRule(3);
        IScoreRule fourOfKindRule = new NKindOfRule(4);
        IScoreRule smallStraighRule =  new StraightRule(StraightRuleEnum.SMALL_STRAIGHT);
        IScoreRule largeStraighRule = new StraightRule(StraightRuleEnum.LARGE_STRAIGHT);
        IScoreRule fullHouseRule = new FullHouseRule();

        IScoreCalculator scoreCalculator =  new ScoreCalculator();
        scoreCalculator.addScoreRules(yahtzeeRule);
        scoreCalculator.addScoreRules(chanceRule);
        scoreCalculator.addScoreRules(sumOneRule);
        scoreCalculator.addScoreRules(sumTwoRule);
        scoreCalculator.addScoreRules(sumThreeRule);
        scoreCalculator.addScoreRules(sumFourRule);
        scoreCalculator.addScoreRules(sumFiveRule);
        scoreCalculator.addScoreRules(sumSixRule);
        scoreCalculator.addScoreRules(pairRule);
        scoreCalculator.addScoreRules(twoParRule);
        scoreCalculator.addScoreRules(threeOfKindRule);
        scoreCalculator.addScoreRules(fourOfKindRule);
        scoreCalculator.addScoreRules(smallStraighRule);
        scoreCalculator.addScoreRules(largeStraighRule);
        scoreCalculator.addScoreRules(fullHouseRule);
        game  = new GameYehtzee(scoreCalculator);
    }


    @Test
    public void testGameWithTreeInput() {
        //chance:14,Sixes:6,Three of kind :10
        ScoreSet scoreSet = new ScoreSet();
        scoreSet.addDicePattern(new int[]{4,2,5,2,1});
        scoreSet.addDicePattern(new int[]{2,1,6,2,5});
        scoreSet.addDicePattern(new int[]{1,1,1,2,5});
        int score = game.getTotalScore(scoreSet);
        assertThat(score, is(equalTo(30)));
    }








}
