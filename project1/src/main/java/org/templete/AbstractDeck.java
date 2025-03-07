package org.templete;

import java.util.ArrayList;
import java.util.List;


public class AbstractDeck<Card> {

  private final List<Card> standardCards = new ArrayList<>();

  public List<Card> getStandardCards() {
    return standardCards;
  }

  public Card drawCard() {
    if (!standardCards.isEmpty()) {
      return standardCards.remove(0);  // Removes the first card
    }
    return null;
  }
}
