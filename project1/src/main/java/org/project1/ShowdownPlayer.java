package org.project1;

import java.util.Random;

public abstract class ShowdownPlayer extends org.templete.AbstractPlayer<ShowdownCard> {


  private int points = 0;

  private Exchange exchange = new Exchange(this);

  public ShowdownPlayer(String name) {
    super(name);
  }

  public void gainPoints(int points) {
    this.points += points;
  }

  public int getPoints() {
    return points;
  }


  public void checkExchangeHandCard(ShowdownPlayer exchangee) {
    if (exchange.isExchange()
        && exchange.getExchangee() != null) {
      System.out.println(this.getName() + "和" + exchange.getExchangee().getName() + "手牌交換中");
      exchange.countDown();

    } else {
      //手牌 還沒交換 決定要不要交換
      makeDecision(exchangee);
    }
  }

  private void makeDecision(ShowdownPlayer exchangee) {
    Random random = new Random();
    if (random.nextBoolean() && !exchange.isExchange()) {
      System.out.println(this.getName() + "決定和" + exchangee.getName() + "交換手牌");
      exchange.exchangeHandCards(this, exchangee);
    }
  }

  public abstract ShowdownCard showCard();

}
