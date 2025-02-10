package project1;

import java.util.List;
import project1.strategy.MatchmakingStrategy;

public class MatchingSystem {
  private MatchmakingStrategy matchmakingStrategy;

  public MatchingSystem(MatchmakingStrategy matchmakingStrategy) {
    this.matchmakingStrategy = matchmakingStrategy;
  }


  // 設置新的策略
  public void setStrategy(MatchmakingStrategy strategy) {
    this.matchmakingStrategy = strategy;
  }


  public Individual findMatch(Individual individual, List<Individual> candidates) {
    return matchmakingStrategy.match(individual, candidates);
  }
}
