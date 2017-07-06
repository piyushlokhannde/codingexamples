package yehtzee.game.scorecalculator.scorerules;

/**
 * Created by devil jin on 6/16/2017.
 */
public class SumOfDiceNumber extends ScoreRule {

    int numberToSum =0;

    public SumOfDiceNumber(int numberToSum) {
        this.numberToSum = numberToSum;
    }

    @Override
    public int findScore(int[] dicesScore) {
        int score = 0;
        for(int diceNumber: dicesScore) {
            if(numberToSum ==diceNumber) {
                score +=numberToSum;
            }
        }
        return score;
    }

}
