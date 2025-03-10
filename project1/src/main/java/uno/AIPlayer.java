package uno;

import static java.util.stream.IntStream.range;
import static uno.TurnMove.pass;
import static uno.TurnMove.play;

import java.util.Random;

public class AIPlayer extends UnoPlayer {
  private static final Random random = new Random();

  public AIPlayer(String name) {
    nameHimself(name);
  }
  @Override
  public TurnMove takeTurn(UnoCard topUnoCard) {
    int[] legalCardIndices =
        topUnoCard == null ? range(0, hand.size()).toArray() : filterLegalCardIndices(topUnoCard);

    if (legalCardIndices.length == 0) {
      return pass(this);
    }
    int choice = legalCardIndices[random.nextInt(legalCardIndices.length)];
    return play(this, hand.play(choice));
  }

  private int[] filterLegalCardIndices(UnoCard topUnoCard) {
    return range(0, hand.size()).filter(i -> hand.get(i).getColor() == topUnoCard.getColor()
        || hand.get(i).getNumber() == topUnoCard.getNumber()).toArray();
  }
}
