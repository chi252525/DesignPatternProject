package showdown;

import java.util.Random;

public class AIPlayer extends Player {

  public AIPlayer(String name) {
    super(name + " (AIPlayer)");
  }

  @Override
  public Card showCard() {
    if (getCardsInHand().isEmpty()) { // 手牌為空
      return null;
    }
    Random random = new Random();
    Card card = getCardsInHand().get(random.nextInt(getCardsInHand().size()));
    System.out.println(this.getName() + "出牌 " + card.toString());
    getCardsInHand().remove(card);
    return card;
  }
}
