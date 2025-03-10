package uno;

import java.util.Collections;
import templete.Deck;

public class UnoDeck extends Deck<UnoCard> {


  public static UnoDeck standardUnoCards() {
    UnoDeck deck = new UnoDeck();
    for (int num = 0; num <= 9; num++) {
      for (UnoCard.Color color : UnoCard.Color.values()) {
        deck.push(new UnoCard(num, color));
      }
    }
    Collections.shuffle(deck.getStandardCards());
    return deck;
  }


}
