package yehtzee.game.scorecalculator;


import yehtzee.game.scorecalculator.scorerules.IScoreRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by devil jin on 6/13/2017.
 */
public class ScoreCalculator implements  IScoreCalculator {

    List<IScoreRule> scoreRules = new ArrayList<>();

    @Override
    public int findScore(int[] diceScore) {
        Arrays.sort(diceScore);
        Optional<Integer> scoreFinal  = Optional.empty();
        Optional<IScoreRule> ruleUsed = Optional.empty();


    /*   Map<Integer, IScoreRule> scoreMap = scoreRules.parallelStream().
               filter(e -> !e.isRuleUsed())
               .collect(Collectors.toMap(e->e.findScore(diceScore.clone()),Function.identity(), (e1,e2)->{return e1;}));
       Integer score = scoreMap.entrySet().stream()
                .max((o1, o2) -> Integer.compare(o1.getKey(),o2.getKey())).get().getKey();
        IScoreRule rule = scoreMap.get(score);
        rule.setRuleUsed(true);*/

        Optional<Entry<Integer, IScoreRule>>  maxScore  = scoreRules.parallelStream().
                filter(e -> !e.isRuleUsed())
                .collect(Collectors
                        .toMap(e->e.findScore(diceScore.clone()),
                                Function.identity(), (e1,e2)->{return e1;}))
                .entrySet()
                .stream()
                .max((o1,o2)-> Integer.compare(o1.getKey(),o2.getKey()));



        if(maxScore.isPresent()) {
            maxScore.get().getValue().setRuleUsed(true);
            return maxScore.get().getKey();
        } else  {
            return  0;
        }





    }

    @Override
    public void addScoreRules(IScoreRule scoreRule) {
        this.scoreRules.add(scoreRule);
    }










}
