package showdown;

public enum Suit {
  SPADES(4),
  HEARTS(3),
  DIAMONDS(2),
  CLUBS(1);

  private int order;

  Suit(int order) {
    this.order = order;
  }

  public int getOrder() {
    return order;
  }

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
