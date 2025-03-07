package org.project2;

import org.templete.AbstractGame;

public class UnoGame extends AbstractGame<UnoPlayer, UnoCard> {



  @Override
  protected void onGameBegins() {
    // hook
  }

  @Override
  public UnoPlayer createRandomPlayer(String name) {
    return new AIPlayer(name);
  }

  @Override
  protected void showTheLastWinner() {
    // hook
  }

  @Override
  protected void drawHands() {
    // hook
  }
}