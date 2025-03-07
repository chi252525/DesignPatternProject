package org.answer1;

import static java.util.Arrays.asList;
import static org.answer1.Deck.standard52Cards;

import java.util.List;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {

  public static void main(String[] args) {
    List<Player> players = asList(new HumanPlayer(), new AI(), new AI(), new AI());
    org.answer1.Showdown showdown = new org.answer1.Showdown(
        standard52Cards(), players);
    showdown.start();
  }
}
