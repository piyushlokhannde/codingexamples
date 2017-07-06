package yehtzee.game.scorecalculator.scorerules;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by devil jin on 6/22/2017.
 */
public class TwoPairRule extends ScoreRule {
    @Override
    public int findScore(int[] dicesScore) {

        Map<Integer, Integer> summaryMap  = new HashMap<>();
        for(int number : dicesScore) {
            summaryMap.computeIfPresent(number,(key, value)-> value+1);
            summaryMap.computeIfAbsent(number, value -> 1);

        }
        Optional<Integer> score = Optional.ofNullable(summaryMap.entrySet().stream()
                .filter(e -> e.getValue()==2))
                .map(entryStream ->
                        entryStream.map(integerIntegerEntry ->
                                integerIntegerEntry.getKey()*2).reduce(Integer::sum))
                .orElse(Optional.of(Integer.valueOf(0)));

        return  score.orElse(Integer.valueOf(0));
    }
}
