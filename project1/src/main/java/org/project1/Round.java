package org.project1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Round {

  private Map<Player, Card> cardsInRound = new HashMap<>() {
  };//在回合中出的牌

  private Player winner;//在回合中赢家

  public Round() {
  }

  public void startRound(List<Player> players) {
    playInRound(players);
    showCardsInRound();
    determineWinner();
    showTheWinnerInRound();
  }

  public Player getWinner() {
    return winner;
  }

  public void playInRound(List<Player> players) {
    //每个玩家出一张牌
    for (Player currentPlayer : players) {

      Player choiceExchangee = getExchangePlayer(players, currentPlayer);
      //隨機選擇一個玩家交換手牌
      currentPlayer.checkExchangeHandCard(choiceExchangee);
      Card playerShowCard = currentPlayer.showCard();
      if (playerShowCard != null) {
        cardsInRound.put(currentPlayer, playerShowCard);
      } else {
        System.out.println(currentPlayer.getName() + " 沒有牌了 不參與分勝負");
      }

    }

  }

  private Player getExchangePlayer(List<Player> players, Player currentPlayer) {
    Random random = new Random();
    Player exchangee;

    do {
      int index = random.nextInt(players.size());
      exchangee = players.get(index);
    } while (exchangee.equals(currentPlayer)); // 如果选到自己，再次选择
    System.out.println(currentPlayer.getName() + " 選擇和 " + exchangee.getName() + " 交換手牌");
    return exchangee;
  }

  private void showCardsInRound() {
    //显示每个玩家出的牌

    for (Map.Entry<Player, Card> entry : cardsInRound.entrySet()) {
      Player player = entry.getKey();
      Card card = entry.getValue();

      System.out.println(player.getName() + " 出了 " + card.toString());
    }
    cardsInRound.get(winner);
  }

  private void determineWinner() {
    //确定赢家
    winner = null;
    Card maxCard = null;
    for (Map.Entry<Player, Card> entry : cardsInRound.entrySet()) {
      Player player = entry.getKey();
      if (winner == null) {
        winner = player;
        maxCard = entry.getValue();
      }
      Card card = entry.getValue();
      int compare = card.compareTo(maxCard);
      if (compare > 0) {
        winner = player;
        maxCard = card;
      }
    }
    Card winnerCard = cardsInRound.get(winner);
    System.out.println(winner.getName() + " 贏家出的牌為： " + winnerCard.toString());
    winner.gainPoints(1);
  }

  public void showTheWinnerInRound() {
    //显示赢家
    System.out.println(winner.getName() + " 為  赢家");
  }

}
