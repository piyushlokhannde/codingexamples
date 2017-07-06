package yehtzee.game.scorecalculator.scorerules;

/**
 * Created by devil jin on 6/27/2017.
 */
public class StraightRule extends  ScoreRule{

    private StraightRuleEnum straightRuleEnum;


    public StraightRule(StraightRuleEnum straightRuleEnum) {
        this.straightRuleEnum = straightRuleEnum;
    }


    @Override
    public int findScore(int[] dicesScore) {
        int compareScore = straightRuleEnum.getStartInt();
        for(int score:dicesScore) {
            if(score != compareScore) {
                return 0;
            }
            compareScore++;
        }

        if(StraightRuleEnum.LARGE_STRAIGHT.equals(straightRuleEnum)) {
            return 20;
        } else  {
            return 15;
        }

    }
}
