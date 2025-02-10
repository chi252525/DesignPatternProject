package org.example;

import java.util.List;
import org.example.strategy.MatchmakingStrategy;

public class MatchingSystem {
  private MatchmakingStrategy matchmakingStrategy;

  public MatchingSystem(MatchmakingStrategy matchmakingStrategy) {
    this.matchmakingStrategy = matchmakingStrategy;
  }


  public void setStrategy(MatchmakingStrategy strategy) {
    this.matchmakingStrategy = strategy;
  }


  public Individual findMatch(Individual individual, List<Individual> candidates) {
    return matchmakingStrategy.match(individual, candidates);
  }
}
