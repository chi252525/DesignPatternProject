package org.example.strategy;

import java.util.List;
import org.example.Coord;
import org.example.Individual;

public class DistanceBasedMatchmakingStrategy implements MatchmakingStrategy{
  @Override
  public Individual match(Individual individual, List<Individual> candidates) {
    Individual closestMatch = null;
    double closestDistance = Double.MAX_VALUE;

    for (Individual candidate : candidates) {
      if (candidate.equals(individual)) continue;  // 跳過自己

      double distance = calculateDistance(individual.getCoord(), candidate.getCoord());
      if (distance < closestDistance || (distance == closestDistance && candidate.getId() < closestMatch.getId())) {
        closestDistance = distance;
        closestMatch = candidate;
      }
    }

    return closestMatch;
  }

  // 計算兩個座標之間的距離
  private double calculateDistance(Coord coord1, Coord coord2) {
    double dx = coord1.getX() - coord2.getX();
    double dy = coord1.getY() - coord2.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

}
