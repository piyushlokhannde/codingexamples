package yehtzee.game.scorecalculator.scorerules;

/**
 * Created by devil jin on 6/27/2017.
 */
public enum StraightRuleEnum {
    SMALL_STRAIGHT(1),LARGE_STRAIGHT(2);

    public int getStartInt() {
        return startInt;
    }

    public void setStartInt(int startInt) {
        this.startInt = startInt;
    }

    private int startInt;

    StraightRuleEnum(int startInt) {
        this.startInt =startInt;
    }
}
