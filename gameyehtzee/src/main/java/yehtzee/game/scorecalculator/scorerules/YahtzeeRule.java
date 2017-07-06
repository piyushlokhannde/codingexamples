package yehtzee.game.scorecalculator.scorerules;

/**
 * Created by devil jin on 6/14/2017.
 */
public class YahtzeeRule extends ScoreRule {
    @Override
    public int findScore(int[] dicesScore) {
        int firstNum = dicesScore[0];
        int sum =0;
        for(int num: dicesScore) {
            sum +=num;
        }
        if(sum == (firstNum*5)) {
            return 50;
        } else {
            return 0;
        }
    }
}
