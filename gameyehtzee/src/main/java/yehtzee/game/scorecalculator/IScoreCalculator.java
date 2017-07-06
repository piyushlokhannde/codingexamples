package yehtzee.game.scorecalculator;

import yehtzee.game.scorecalculator.scorerules.IScoreRule;

/**
 * Created by devil jin on 6/12/2017.
 */
public interface IScoreCalculator {

    int findScore(int[] diceScore);

    void addScoreRules(IScoreRule scoreRule);
}
