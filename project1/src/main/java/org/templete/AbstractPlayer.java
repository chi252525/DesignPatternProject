package org.templete;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractPlayer<Card> {

  private String name;

  private List<Card> cardsInHand = new ArrayList<>();

  public String getName() {
    return name;
  }

  public AbstractPlayer(String name) {
    nameHimself(name);
  }


  private void nameHimself(String name) {
    this.name = name;
    System.out.println(" name :" + name);
  }


  public List<Card> getCardsInHand() {
    return cardsInHand;
  }

  public void setCardsInHand(List<Card> cardsInHand) {
    this.cardsInHand = cardsInHand;
  }

  public void gainCard(Card card) {
    cardsInHand.add(card);
  }

  public abstract Card showCard();


  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AbstractPlayer) {
      AbstractPlayer player = (AbstractPlayer) obj;
      return this.name.equals(player.getName());
    }
    return false;
  }


}
