package org.project2;

import java.util.Collections;


public class UnoDeck extends org.templete.AbstractDeck<UnoCard> {

  public UnoDeck() {
    for (int num = 0; num <= 9; num++) {
      for (UnoCard.Color color : UnoCard.Color.values()) {
        this.getStandardCards().add(new UnoCard(num, color));
      }
    }
    Collections.shuffle(this.getStandardCards());
    System.out.println("洗牌完成" + this.getStandardCards().size() + "張牌");
  }


}
