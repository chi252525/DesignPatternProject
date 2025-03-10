package templete;

import java.util.Collections;
import java.util.Stack;

public class Deck<Card> {

  private final Stack<Card> standardCards = new Stack<>();

  public Stack<Card> getStandardCards() {
    return standardCards;
  }

  public Card drawCard() {
    return standardCards.pop();  // Removes the first card
  }

  public void push(Deck<Card> deck) {
    standardCards.addAll(deck.standardCards);
  }

  public void push(Card card) {
    standardCards.push(card);
  }
  public void shuffle() {
    Collections.shuffle(standardCards);
  }

  public boolean isEmpty() {
    return standardCards.isEmpty();
  }

  public void clear() {
    standardCards.clear();
  }
}
