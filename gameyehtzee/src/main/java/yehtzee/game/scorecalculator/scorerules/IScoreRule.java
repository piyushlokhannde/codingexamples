package yehtzee.game.scorecalculator.scorerules;

/**
 * Created by devil jin on 6/14/2017.
 */
public interface IScoreRule {
    int findScore(int[] dicesScore);

    boolean isRuleUsed();

    void setRuleUsed(boolean used);
}
