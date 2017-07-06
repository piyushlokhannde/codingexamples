package yehtzee.game;

import yehtzee.game.scorecalculator.IScoreCalculator;

/**
 * Created by devil jin on 6/9/2017.
 */
public class GameYehtzee {


    private IScoreCalculator scoreCalculator;

    private int totalScore;

    public GameYehtzee(IScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public int getTotalScore(ScoreSet scoreSet) {
        ScoreSet.ScoreSetIterator iterator = scoreSet.getScoreSetIterator();
        while(iterator.hashNextDiceScore()) {
            int[] diceScore = iterator.getNextDiceScore();
            totalScore  += scoreCalculator.findScore(diceScore);
        }
        return totalScore;
    }
}
