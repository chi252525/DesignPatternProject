package showdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowdownDeck {

  private List<Card> standardCards = new ArrayList<>();

  public ShowdownDeck() {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        standardCards.add(new Card(suit, rank));
      }
    }
    Collections.shuffle(standardCards);
    System.out.println("洗牌完成" + standardCards.size() + "張牌");

  }

  public List<Card> getStandardCards() {
    return standardCards;
  }

  public void drawCard(Player player) {
    if (!standardCards.isEmpty()) {
      Card card = standardCards.remove(0);  // Removes the first card
      player.gainCard(card);
    }
  }
}


