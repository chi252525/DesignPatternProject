package org.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

  private List<Player> playersInGame = new ArrayList<>();
  private Player lastWinner;

  public void startGame() {
    Deck deck = new Deck();
    for (int i = 1; i <= 4; i++) {
      initPlayer(createRandomPlayer("P" + i));
    }

    do {
      for (Player player : playersInGame) {
        deck.drawCard(player);   //發牌
      }
    } while (!deck.getStandardCards().isEmpty());

    for (Player player : playersInGame) {
      player.showCardsInHand();
      //發牌
    }

    for (int i = 1; i <= 13; i++) {
      Round round = new Round();
      System.out.println("=======開始回合 Round " + i + "=======");
      takeTurns(round);//開始回合
    }
    showTheLastWinner();
  }

  private Player createRandomPlayer(String name) {
    Random random = new Random();
    if (random.nextBoolean()) {
      return new HumanPlayer(name);
    } else {
      return new AIPlayer(name);
    }
  }

  private void initPlayer(Player player) {
    playersInGame.add(player);
  }

  private void takeTurns(Round round) {
    round.startRound(playersInGame);
  }

  private void showTheLastWinner() {
    lastWinner = playersInGame.get(0);
    for (Player player : playersInGame) {
      if (player.getPoints() > lastWinner.getPoints()) {
        lastWinner = player;
      }
    }
    System.out.println("The  last winner is: " + lastWinner.getName());
  }
}
