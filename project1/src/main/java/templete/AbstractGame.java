package templete;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame<Player extends AbstractPlayer<Card>, Card> {

  private List<Player> playersInGame = new ArrayList<>();
  private Player lastWinner;
  protected Player turnPlayer;
  protected int turn = 0;
  protected int round = 0;
  protected Deck<Card> deck;

  public AbstractGame(Deck<Card> deck) {
    this.deck = deck;
  }

  public List<Player> getPlayersInGame() {
    return playersInGame;
  }

  public void start() {
    nameThemselves();
    drawHands();
    onGameBegins();
    nextTurn();
  }

  private void drawHands() {
    int initialHandSize = getInitialHandSize();
    for (int i = 0; i < initialHandSize; i++) {
      for (Player player : playersInGame) {
        Card card = deck.drawCard();   //發牌
        player.gainCard(card);
      }
    }

    for (Player player : playersInGame) {
      player.showCardsInHand();
      //player 手上的手牌
    }
  }

  private void nameThemselves() {
    for (int i = 1; i <= 4; i++) {
      initPlayer(createRandomPlayer("P" + i));
    }
  }

  protected void onGameBegins() {
    // hook
  }

  protected void onRoundEnd() {
    //hook 只有showdown會用到
  }

  protected void nextTurn() {
    turnPlayer = playersInGame.get(turn % playersInGame.size());
    takeTurn(turnPlayer);
    turn++;
    if (turn % playersInGame.size() == 0) {
      round++;
      onRoundEnd();
    }
    if (isGameOver(round)) {
      gameOver();
    } else {
      nextTurn();
    }
  }

  private void gameOver() {
    determineTheLastWinner();
  }


  protected abstract void takeTurn(Player nextPlayer);

  protected abstract int getInitialHandSize();

  public abstract Player createRandomPlayer(String s);


  private void initPlayer(Player player) {
    playersInGame.add(player);
  }

  protected abstract boolean isGameOver(int currentRound);

  protected abstract void determineTheLastWinner();
}
