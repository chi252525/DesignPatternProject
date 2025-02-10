package project1.strategy;

import java.util.List;
import project1.Individual;

public interface MatchmakingStrategy {
  Individual match(Individual individual, List<Individual> individuals);
}
