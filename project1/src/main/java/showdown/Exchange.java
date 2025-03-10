package showdown;

import java.util.List;

public class Exchange {

  private int currentCount = 3;//当前交换次数
  private Player self;
  private Player exchangee;
  private boolean isExchange = false;

  public Exchange(Player self) {
    this.self = self;
  }

  public void exchangeHandCards(Player self, Player exchangee) {
    if (!isExchange) {
      List<Card> exchangeeCards = exchangee.getCardsInHand();
      List<Card> selfCards = self.getCardsInHand();

      self.setCardsInHand(exchangeeCards);
      exchangee.setCardsInHand(selfCards);
    }
    this.exchangee = exchangee;
    isExchange = true;
    System.out.println(self.getName() + "和" + exchangee.getName() + "手牌交換完成");
    self.showCardsInHand();
    exchangee.showCardsInHand();
  }

  public void countDown() {
    if (currentCount == 0) {
      System.out.println(
          self.getName() + "和" + exchangee.getName() + "剩餘次數為 0 :" + currentCount);
      exchangeHandCards(exchangee, self);//交换回來手牌
      System.out.println(self.getName() + "和" + exchangee.getName() + "換回手牌");
      return;
    }
    currentCount--;
    System.out.println(
        self.getName() + "和" + exchangee.getName() + "交換中 剩餘次數" + currentCount);
  }

  public boolean isExchange() {
    return isExchange;
  }

  public int getCurrentCount() {
    return currentCount;
  }

  public Player getExchangee() {
    return exchangee;
  }
}
