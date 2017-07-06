package yehtzee.game.scorecalculator.scorerules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devil jin on 7/3/2017.
 */
public class FullHouseRule extends ScoreRule {
    @Override
    public int findScore(int[] dicesScore) {

        Map<Integer, Integer> summaryMap  = new HashMap<>();
        for(int number : dicesScore) {
            summaryMap.computeIfPresent(number,(key, value)-> value+1);
            summaryMap.computeIfAbsent(number, value -> 1);

        }
        Integer threeValue = summaryMap.entrySet().stream().filter(e -> e.getValue() == 3)
                .map(x->x.getKey()*3).findAny().orElse(Integer.valueOf(0));

        Integer twoValue = null;
        if(threeValue !=0) {
            twoValue = summaryMap.entrySet().stream().filter(e -> e.getValue() == 2)
                    .map(x->x.getKey()*2).findAny().orElse(Integer.valueOf(0));
            if(twoValue !=null) {
                return twoValue+threeValue;
            }
        }
        return 0;
    }
}
