package yehtzee.game.scorecalculator.scorerules;

/**
 * Created by devil jin on 6/14/2017.
 */
public abstract  class ScoreRule implements IScoreRule {

    private boolean ruleUsed;

    @Override
    public boolean isRuleUsed() {
        return ruleUsed;
    }

    @Override
    public void setRuleUsed(boolean ruleUsed) {
        this.ruleUsed = ruleUsed;
    }
}
