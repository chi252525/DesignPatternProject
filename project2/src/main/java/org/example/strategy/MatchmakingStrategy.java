package org.example.strategy;

import java.util.List;
import org.example.Individual;

public interface MatchmakingStrategy {
  Individual match(Individual individual, List<Individual> individuals);
}
