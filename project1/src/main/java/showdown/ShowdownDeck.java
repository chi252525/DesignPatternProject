package showdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.smartcardio.Card;

public class ShowdownDeck {

  private List<ShowdownCard> standardCards = new ArrayList<>();

  public ShowdownDeck() {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        standardCards.add(new ShowdownCard(suit, rank));
      }
    }
    Collections.shuffle(standardCards);
    System.out.println("洗牌完成" + standardCards.size() + "張牌");

  }

  public List<ShowdownCard> getStandardCards() {
    return standardCards;
  }

  public void drawCard(ShowdownPlayer player) {
    if (!standardCards.isEmpty()) {
      ShowdownCard card = standardCards.remove(0);  // Removes the first card
      player.gainCard(card);
    }
  }
}


