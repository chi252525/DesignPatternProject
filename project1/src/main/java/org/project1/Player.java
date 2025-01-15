package org.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {

  private String name;
  private List<Card> cardsInHand = new ArrayList<>();
  private int points = 0;

  private Exchange exchange = new Exchange(this);

  public Player(String name) {
    nameHimself(name);
  }

  public String getName() {
    return name;
  }

  public List<Card> getCardsInHand() {
    return cardsInHand;
  }

  public void setCardsInHand(List<Card> cardsInHand) {
    this.cardsInHand = cardsInHand;
  }

  private void nameHimself(String name) {
    this.name = name;
    System.out.println(" name :" + name);
  }

  public void gainCard(Card card) {
    cardsInHand.add(card);
  }

  public void gainPoints(int points) {
    this.points += points;
  }

  public int getPoints() {
    return points;
  }


  public void checkExchangeHandCard(Player exchangee) {
    if (exchange.isExchange()
        && exchange.getExchangee() != null) {
      System.out.println(this.getName() + "和" + exchange.getExchangee().getName() + "手牌交換中");
      exchange.countDown();

    } else {
      //手牌 還沒交換 決定要不要交換
      makeDecision(exchangee);
    }
  }

  private void makeDecision(Player exchangee) {
    Random random = new Random();
    if (random.nextBoolean() && !exchange.isExchange()) {
      System.out.println(this.name + "決定和" + exchangee.getName() + "交換手牌");
      exchange.exchangeHandCards(this, exchangee);
    }
  }

  public abstract Card showCard() ;

  public void showCardsInHand() {
    System.out.println(this.name + "手上的牌:");
    for (Card card : cardsInHand) {
      System.out.println(card.toString());
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Player) {
      Player player = (Player) obj;
      return this.name.equals(player.getName());
    }
    return false;
  }

}
