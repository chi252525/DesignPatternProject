package showdown;

import java.util.Random;
import javax.smartcardio.Card;

public class AIPlayer extends ShowdownPlayer {

  public AIPlayer(String name) {
    super(name + " (AIPlayer)");
  }

  @Override
  public ShowdownCard showCard() {
    if (getCardsInHand().isEmpty()) { // 手牌為空
      return null;
    }
    Random random = new Random();
    ShowdownCard card = getCardsInHand().get(random.nextInt(getCardsInHand().size()));
    System.out.println(this.getName() + "出牌 " + card.toString());
    getCardsInHand().remove(card);
    return card;
  }
}
