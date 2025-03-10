package showdown;

import java.util.Collections;
import templete.Deck;

public class ShowdownDeck extends Deck<ShowdownCard> {


  public static ShowdownDeck standard52Cards() {
    ShowdownDeck deck = new ShowdownDeck();
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        deck.push(new ShowdownCard(suit, rank));
      }
    }
    Collections.shuffle(deck.getStandardCards());
    return deck;
  }

}


