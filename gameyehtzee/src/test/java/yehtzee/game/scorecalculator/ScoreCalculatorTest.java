package yehtzee.game.scorecalculator;

import org.junit.Before;
import org.junit.Test;
import yehtzee.game.scorecalculator.scorerules.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by devil jin on 6/13/2017.
 */
public class ScoreCalculatorTest {

    private ScoreCalculator scoreCalculator;
    private IScoreRule  yahtzeeRule;
    private IScoreRule  chanceRule;
    private IScoreRule  sumOneRule;
    private IScoreRule  sumTwoRule;
    private IScoreRule  sumThreeRule;
    private IScoreRule  sumFourRule;
    private IScoreRule  sumFiveRule;
    private IScoreRule  sumSixRule;
    private IScoreRule  pairRule;
    private IScoreRule twoParRule;
    private IScoreRule threeOfKindRule;
    private IScoreRule fourOfKindRule;
    private IScoreRule smallStraighRule;
    private IScoreRule largeStraighRule;
    private IScoreRule fullHouseRule;


    @Before
    public void init() {
        scoreCalculator = new ScoreCalculator();
        yahtzeeRule= new YahtzeeRule();
        chanceRule = new ChanceRule();
        sumOneRule = new SumOfDiceNumber(1);
        sumTwoRule = new SumOfDiceNumber(2);
        sumThreeRule = new SumOfDiceNumber(3);
        sumFourRule = new SumOfDiceNumber(4);
        sumFiveRule = new SumOfDiceNumber(5);
        sumSixRule = new SumOfDiceNumber(6);
        pairRule =new NKindOfRule(2);
        twoParRule = new TwoPairRule();
        threeOfKindRule = new NKindOfRule(3);
        fourOfKindRule = new NKindOfRule(4);
        smallStraighRule =  new StraightRule(StraightRuleEnum.SMALL_STRAIGHT);
        largeStraighRule = new StraightRule(StraightRuleEnum.LARGE_STRAIGHT);
        this.fullHouseRule = new FullHouseRule();

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
    }

    @Test
    public void testScoreCalc_Yahtzee() {
        int[] diceScore = new int[] {1,1,1,1,1};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(50)));
        assertThat(true, is(equalTo(yahtzeeRule.isRuleUsed())));
    }

    @Test
    public void testScoreCalc_Chance() {
        int[] diceScore = new int[] {1,2,3,4,5};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(15)));
        assertThat(true, is(equalTo(chanceRule.isRuleUsed())));
    }

    @Test
    public void testScoreCalc_SumOfOne() {
        this.chanceRule.setRuleUsed(true);
        this.yahtzeeRule.setRuleUsed(true);
        int[] diceScore = new int[] {1,1,2,1,1};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(4)));
        assertThat(true, is(equalTo(sumOneRule.isRuleUsed())));
    }

    @Test
    public void testScoreCalc_SumOfFive() {
        this.chanceRule.setRuleUsed(true);
        int[] diceScore = new int[] {5,5,2,5,5};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(20)));
        assertThat(true, is(equalTo(sumFiveRule.isRuleUsed())));
    }

    @Test
    public void testScoreCalc_SumOfSix() {
        this.chanceRule.setRuleUsed(true);
        int[] diceScore = new int[] {6,6,2,6,6};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(24)));
        assertThat(true, is(equalTo(sumSixRule.isRuleUsed())));
    }

    @Test
    public void testScoreCalc_SumOfPair() {
        this.chanceRule.setRuleUsed(true);
        this.sumThreeRule.setRuleUsed(true);
        this.sumFourRule.setRuleUsed(true);
        this.threeOfKindRule.setRuleUsed(true);
        this.fullHouseRule.setRuleUsed(true);
        int[] diceScore = new int[] {3,3,3,4,4};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(8)));
        assertThat(true, is(equalTo(pairRule.isRuleUsed())));
    }


    @Test
    public void testScoreCalcIfAllRuleUsed(){
        ScoreCalculator  localCalculator = new ScoreCalculator();
        IScoreRule localYahtzeeRule = new YahtzeeRule();
        localCalculator.addScoreRules(localYahtzeeRule);
        localYahtzeeRule.setRuleUsed(true);
        int[] diceScore = new int[] {3,3,3,4,4};
        int score = localCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(0)));
    }

    @Test
    public void testScoreIfNoRuleUsed(){
        ScoreCalculator  localCalculator = new ScoreCalculator();
        int[] diceScore = new int[] {3,3,3,4,4};
        int score = localCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(0)));
    }

    @Test
    public void testScoreForTwoPair(){
        this.chanceRule.setRuleUsed(true);
        this.sumThreeRule.setRuleUsed(true);
        this.sumFourRule.setRuleUsed(true);
        this.sumThreeRule.setRuleUsed(true);
        int[] diceScore = new int[] {1,1,2,3,3};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(8)));
        assertThat(true, is(equalTo(twoParRule.isRuleUsed())));

    }


    @Test
    public void testScoreForThreeOfKind() {
        this.chanceRule.setRuleUsed(true);
        this.sumThreeRule.setRuleUsed(true);
        this.sumFourRule.setRuleUsed(true);
        int[] diceScore = new int[] {3,3,3,4,5};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(9)));
        assertThat(true, is(equalTo(threeOfKindRule.isRuleUsed())));
    }

    @Test
    public void testScoreForFourOfKind() {
        this.chanceRule.setRuleUsed(true);
        this.sumThreeRule.setRuleUsed(true);
        this.sumFourRule.setRuleUsed(true);
        this.sumTwoRule.setRuleUsed(true);
        int[] diceScore = new int[] {2,2,2,2,5};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(8)));
        assertThat(true, is(equalTo(fourOfKindRule.isRuleUsed())));

    }


    @Test
    public void testScoreSmallStraight() {
        this.chanceRule.setRuleUsed(true);
        int[] diceScore = new int[] {1,2,3,4,5};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(15)));
        assertThat(true, is(equalTo(smallStraighRule.isRuleUsed())));
    }

    @Test
    public void testScoreLargeStraight() {
        this.chanceRule.setRuleUsed(true);
        this.sumSixRule.setRuleUsed(true);
        int[] diceScore = new int[] {2,3,4,5,6};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(20)));
        assertThat(true, is(equalTo(largeStraighRule.isRuleUsed())));
    }


    @Test
    public void testScoreWhenFullHouse() {
        this.chanceRule.setRuleUsed(true);
        int[] diceScore = new int[] {1,1,2,2,2};
        int score = scoreCalculator.findScore(diceScore);
        assertThat(score, is(equalTo(8)));
        assertThat(true, is(equalTo(fullHouseRule.isRuleUsed())));

    }


















}
