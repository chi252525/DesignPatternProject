package org.project1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.templete.AbstractGame;
import org.templete.AbstractPlayer;

public class ShowdownGame extends AbstractGame<ShowdownPlayer, ShowdownCard> {


  @Override
  protected void drawHands() {
    do {
      for (AbstractPlayer player : playersInGame) {
        ShowdownCard card = (ShowdownCard) this.deck.drawCard();   //發牌
        player.gainCard(card);
      }
    } while (!deck.getStandardCards().isEmpty());

    for (AbstractPlayer player : playersInGame) {
      player.showCardsInHand(); //發牌
    }
  }

  @Override
  protected void onGameBegins() {
    for (int i = 1; i <= 13; i++) {
      System.out.println("=======開始回合 Round " + i + "=======");
      takeTurns();//開始回合
    }
  }

  @Override
  public ShowdownPlayer createRandomPlayer(String name) {
    Random random = new Random();
    if (random.nextBoolean()) {
      return new HumanPlayer(name);
    } else {
      return new AIPlayer(name);
    }
  }


  private void takeTurns() {
    Map<ShowdownPlayer, ShowdownCard> cardsInRound = new HashMap<>() {
    };
    playInRound(playersInGame);
    showCardsInRound(cardsInRound);
    determineWinner(cardsInRound);
  }

  public void playInRound(List<ShowdownPlayer> players) {
    //每个玩家出一张牌
    Map<ShowdownPlayer, ShowdownCard> cardsInRound = new HashMap<>() {
    };//在回合中出的牌
    for (ShowdownPlayer currentPlayer : players) {

      ShowdownPlayer choiceExchangee = getExchangePlayer(players, currentPlayer);
      //隨機選擇一個玩家交換手牌
      currentPlayer.checkExchangeHandCard(choiceExchangee);
      ShowdownCard playerShowCard = currentPlayer.showCard();
      if (playerShowCard != null) {
        cardsInRound.put(currentPlayer, playerShowCard);
      } else {
        System.out.println(currentPlayer.getName() + " 沒有牌了 不參與分勝負");
      }

    }

  }

  private ShowdownPlayer getExchangePlayer(List<ShowdownPlayer> players,
      ShowdownPlayer currentPlayer) {
    Random random = new Random();
    ShowdownPlayer exchangee;

    do {
      int index = random.nextInt(players.size());
      exchangee = players.get(index);
    } while (exchangee.equals(currentPlayer)); // 如果选到自己，再次选择
    System.out.println(currentPlayer.getName() + " 選擇和 " + exchangee.getName() + " 交換手牌");
    return exchangee;
  }


  private void showCardsInRound(Map<ShowdownPlayer, ShowdownCard> cardsInRound) {
    //显示每个玩家出的牌
    for (Map.Entry<ShowdownPlayer, ShowdownCard> entry : cardsInRound.entrySet()) {
      ShowdownPlayer player = entry.getKey();
      ShowdownCard card = entry.getValue();
      System.out.println(player.getName() + " 出了 " + card.toString());
    }
  }

  private void determineWinner(Map<ShowdownPlayer, ShowdownCard> cardsInRound) {
    //确定赢家
    ShowdownPlayer winner = null;
    ShowdownCard maxCard = null;
    for (Map.Entry<ShowdownPlayer, ShowdownCard> entry : cardsInRound.entrySet()) {
      ShowdownPlayer player = entry.getKey();
      if (winner == null) {
        winner = player;
        maxCard = entry.getValue();
      }
      ShowdownCard card = entry.getValue();
      int compare = card.compareTo(maxCard);
      if (compare > 0) {
        winner = player;
        maxCard = card;
      }
    }
    ShowdownCard winnerCard = cardsInRound.get(winner);
    System.out.println(winner.getName() + " 贏家出的牌為： " + winnerCard.toString());
    winner.gainPoints(1);
    //显示赢家
    System.out.println(winner.getName() + " 為  赢家");
  }

  @Override
  protected void showTheLastWinner() {
    ShowdownPlayer lastWinner = playersInGame.get(0);
    for (ShowdownPlayer player : playersInGame) {
      if (player.getPoints() > lastWinner.getPoints()) {
        lastWinner = player;
      }
    }
    System.out.println("The  last winner is: " + lastWinner.getName());
  }
}
