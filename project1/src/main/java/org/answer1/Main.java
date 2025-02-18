package org.answer1;

import java.util.List;

import static java.util.Arrays.asList;
import static tw.waterballsa.designpattern.c1m1h1.Deck.standard52Cards;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {
    public static void main(String[] args) {
        List<Player> players = asList(new HumanPlayer(), new AI(), new AI(), new AI());
        tw.waterballsa.designpattern.c1m1h1.Showdown showdown = new tw.waterballsa.designpattern.c1m1h1.Showdown(standard52Cards(), players);
        showdown.start();
    }
}
