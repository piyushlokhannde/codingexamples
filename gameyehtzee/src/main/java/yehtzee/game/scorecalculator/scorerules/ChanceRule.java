package yehtzee.game.scorecalculator.scorerules;

/**
 * Created by devil jin on 6/14/2017.
 */
public class ChanceRule extends ScoreRule {

    @Override
    public int findScore(int[] dicesScore) {
        int sum = 0;
        for(int num: dicesScore) {
            sum +=num;
        }
        return sum;
    }
}
