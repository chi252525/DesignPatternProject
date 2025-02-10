package org.example.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.example.Individual;

public class ReverseMatchmakingStrategy implements MatchmakingStrategy {

  private MatchmakingStrategy originalStrategy;

  // 建構子，傳入原始的配對策略
  public ReverseMatchmakingStrategy(MatchmakingStrategy originalStrategy) {
    this.originalStrategy = originalStrategy;
  }

  @Override
  public Individual match(Individual individual, List<Individual> candidates) {
    // 如果原始策略是距離先決，則反向邏輯：選擇距離最遠的
    if (originalStrategy instanceof DistanceBasedMatchmakingStrategy) {
      return findFarthest(individual, candidates);
    }
    // 如果原始策略是興趣先決，則反向邏輯：選擇交集最小的
    else if (originalStrategy instanceof HabitBasedMatchmakingStrategy) {
      return findLeastOverlap(individual, candidates);
    }
    // 若有其他策略，根據需要擴展
    return null;
  }

  // 找出距離最遠的個體
  private Individual findFarthest(Individual individual, List<Individual> candidates) {
    Individual farthest = null;
    double maxDistance = -1;
    for (Individual candidate : candidates) {
      double distance = individual.getCoord().distanceTo(candidate.getCoord());
      if (farthest == null || distance > maxDistance) {
        farthest = candidate;
        maxDistance = distance;
      }
    }
    return farthest;
  }

  // 找出興趣交集最少的個體
  private Individual findLeastOverlap(Individual individual, List<Individual> candidates) {
    Individual leastOverlap = null;
    int minOverlapCount = Integer.MAX_VALUE;
    for (Individual candidate : candidates) {
      int overlapCount = calculateOverlap(individual, candidate);
      if (leastOverlap == null || overlapCount < minOverlapCount) {
        leastOverlap = candidate;
        minOverlapCount = overlapCount;
      }
    }
    return leastOverlap;
  }

  // 計算興趣交集的數量
  private int calculateOverlap(Individual individual, Individual candidate) {
    Set<String> individualHabits = new HashSet<>(Arrays.asList(individual.getHabits().split(", ")));
    Set<String> candidateHabits = new HashSet<>(Arrays.asList(candidate.getHabits().split(", ")));
    individualHabits.retainAll(candidateHabits);
    return individualHabits.size();
  }

}
