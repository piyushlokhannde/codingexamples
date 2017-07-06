package yehtzee.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by devil jin on 6/9/2017.
 */
public class ScoreSet {

   private List<int[]> diceSetScore = new ArrayList();

    public void addDicePattern(int[] diceScores) {
        this.diceSetScore.add(diceScores);
    }

    public ScoreSetIterator getScoreSetIterator() {
        return new ScoreSetIterator();
    }

    public class ScoreSetIterator {

        Iterator<int[]> iterator = diceSetScore.iterator();

        public boolean hashNextDiceScore(){
           return  iterator.hasNext();
        }

        public int[] getNextDiceScore() {
            return iterator.next();
        }

    }

}
