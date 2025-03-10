package templete;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer<Card> {
  protected Hand<Card> hand = new Hand<>();
  private String name;
  private List<Card> cardsInHand = new ArrayList<>();

  public String getName() {
    return name;
  }

  public List<Card> getCardsInHand() {
    return cardsInHand;
  }

  public void setCardsInHand(List<Card> cardsInHand) {
    this.cardsInHand = cardsInHand;
  }

  public void nameHimself(String name) {
    this.name = name;
    System.out.println(" name :" + name);
  }

  public void addHandCard(Card card) {
    this.hand.addCard(card);
  }
  public void showCardsInHand() {
    System.out.println(this.getName() + "手上的牌:");
    for (Card card : this.getCardsInHand()) {
      System.out.println(card.toString());
    }
  }

  public void gainCard(Card card) {
    cardsInHand.add(card);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AbstractPlayer) {
      AbstractPlayer player = (AbstractPlayer) obj;
      return this.getName().equals(player.getName());
    }
    return false;
  }
}
