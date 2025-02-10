package project1;

import java.util.Arrays;
import java.util.List;
import project1.Individual.Gender;
import project1.strategy.DistanceBasedMatchmakingStrategy;
import project1.strategy.ReverseMatchmakingStrategy;

public class Main {

  public static void main(String[] args) {

    Individual user1 = new Individual(1, Gender.MALE, 25, "I love sports", "basketball, soccer",
        new Coord(1, 1));
    Individual user2 = new Individual(2, Gender.FEMALE, 23, "I enjoy cooking", "cooking, reading",
        new Coord(3, 3));
    Individual user3 = new Individual(3, Gender.MALE, 27, "Tech enthusiast", "programming, gaming",
        new Coord(10, 10));
    Individual user4 = new Individual(4, Gender.FEMALE, 26, "Fitness lover", "yoga, basketball",
        new Coord(5, 5));


    List<Individual> candidates = Arrays.asList(user2, user3, user4);


    MatchingSystem matchingSystem = new MatchingSystem(new DistanceBasedMatchmakingStrategy());


    Individual bestMatch = matchingSystem.findMatch(user1, candidates);
    System.out.println("Best match (Distance-based): " + bestMatch.getId());


    matchingSystem.setStrategy(
        new ReverseMatchmakingStrategy(new DistanceBasedMatchmakingStrategy()));
    Individual reverseMatch = matchingSystem.findMatch(user1, candidates);
    System.out.println("Best match (Reverse Distance-based): " + reverseMatch.getId());
  }
}