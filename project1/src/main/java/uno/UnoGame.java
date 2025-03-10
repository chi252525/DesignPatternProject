package uno;


import templete.AbstractGame;
import templete.Deck;

public class UnoGame extends AbstractGame<UnoPlayer, UnoCard> {

  private final Deck discards = new Deck();
  private UnoCard topUnoCard;

  public UnoGame(Deck<UnoCard> deck) {
    super(deck);
  }

  @Override
  protected void takeTurn(UnoPlayer nextPlayer) {
    TurnMove turnMove = nextPlayer.takeTurn(topUnoCard);
    if (turnMove.isPass()) {
      pass(nextPlayer);
    } else {
      if (isValidMove(turnMove)) {
        playCard(nextPlayer, turnMove);
      } else {
        turnMove.undo();
      }
    }
  }

  private boolean isValidMove(TurnMove turnMove) {
    UnoCard unoCard = turnMove.getCard();
    return topUnoCard.getColor() == unoCard.getColor()
        || topUnoCard.getNumber() == unoCard.getNumber();
  }

  private void pass(UnoPlayer player) {
    System.out.printf("Player %s pass so he has to draw a card from the deck.\n", player.getName());
    reshuffleDeckIfEmpty();
    player.addHandCard(deck.drawCard());
  }

  private void playCard(UnoPlayer player, TurnMove turnMove) {
    if (topUnoCard != null) {
      discards.push(topUnoCard);
    }
    topUnoCard = turnMove.getCard();
    System.out.printf("Player %s plays a %s.\n", player.getName(), topUnoCard);
  }

  private void reshuffleDeckIfEmpty() {
    if (deck.isEmpty()) {
      System.out.println("The deck is empty, reshuffling the deck.");
      deck.push(discards);
      discards.clear();
      deck.shuffle();
    }
  }

  @Override
  protected int getInitialHandSize() {
    return 5;
  }

  @Override
  public UnoPlayer createRandomPlayer(String s) {
    return new AIPlayer();
  }

  @Override
  protected boolean isGameOver(int currentRound) {
    return turnPlayer.getCardsInHand().isEmpty();
  }

  @Override
  protected void determineTheLastWinner() {
    System.out.println(turnPlayer.getName() + " 為  赢家");
  }
}
