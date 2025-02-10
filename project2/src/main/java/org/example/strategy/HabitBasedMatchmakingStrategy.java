package org.example.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.example.Individual;

public class HabitBasedMatchmakingStrategy implements MatchmakingStrategy{
  @Override
  public Individual match(Individual individual, List<Individual> candidates) {
    Individual bestMatch = null;
    int maxCommonInterests = -1;

    for (Individual candidate : candidates) {
      if (candidate.equals(individual)) continue;  // 跳過自己

      int commonInterests = calculateCommonInterests(individual.getHabits(), candidate.getHabits());
      if (commonInterests > maxCommonInterests || (commonInterests == maxCommonInterests && candidate.getId() < bestMatch.getId())) {
        maxCommonInterests = commonInterests;
        bestMatch = candidate;
      }
    }

    return bestMatch;
  }

  // 計算兩個興趣列表的交集數量
  private int calculateCommonInterests(String habits1, String habits2) {
    String[] interests1 = habits1.split(", ");
    String[] interests2 = habits2.split(", ");
    Set<String> set1 = new HashSet<>(Arrays.asList(interests1));
    Set<String> set2 = new HashSet<>(Arrays.asList(interests2));

    set1.retainAll(set2);  // 保留交集
    return set1.size();
  }
}
