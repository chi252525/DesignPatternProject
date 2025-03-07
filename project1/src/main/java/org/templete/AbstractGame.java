package org.templete;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame<Player extends AbstractPlayer<Card>, Card> {

  public List<Player> playersInGame = new ArrayList<>();

  protected AbstractDeck deck = new AbstractDeck();

  public void start() {
    nameThemselves();
    drawHands();//抽手牌
    onGameBegins();
    showTheLastWinner();
  }

  protected void showTheLastWinner() {
    // hook
  }

  protected void drawHands() {
    // hook
  }

  protected void onGameBegins() {
    // hook
  }

  private void nameThemselves() {
    for (int i = 1; i <= 4; i++) {
      initPlayer(createRandomPlayer("P" + i));
    }
  }

  private void initPlayer(Player player) {
    playersInGame.add(player);
  }

  public abstract Player createRandomPlayer(String name);

}
