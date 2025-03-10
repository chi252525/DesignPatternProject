package showdown;

import javax.smartcardio.Card;

public class ShowdownCard implements Comparable<ShowdownCard> {

  private Suit suit;
  private Rank rank;

  public ShowdownCard(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank + " of " + suit;
  }

  @Override
  public int compareTo(ShowdownCard other) {
    if (rank.getOrder() == other.rank.getOrder()) {
      return suit.getOrder() - other.suit.getOrder();
    }
    return rank.getOrder() - other.rank.getOrder();
  }
}
