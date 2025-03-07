package org.project1;

import java.util.Collections;

public class Deck extends org.templete.AbstractDeck<ShowdownCard>  {


  public Deck() {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        this.getStandardCards().add(new ShowdownCard(suit, rank));
      }
    }
    Collections.shuffle(this.getStandardCards());
    System.out.println("洗牌完成" + this.getStandardCards().size() + "張牌");

  }


}


