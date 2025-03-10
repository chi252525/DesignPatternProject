package showdown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.smartcardio.Card;

public class ShowdownGame {

  private List<ShowdownPlayer> playersInGame = new ArrayList<>();
  private ShowdownPlayer lastWinner;

  private ShowdownPlayer winner;//在回合中赢家

  public void start() {
    ShowdownDeck deck = new ShowdownDeck();
    for (int i = 1; i <= 4; i++) {
      initPlayer(createRandomPlayer("P" + i));
    }

    do {
      for (ShowdownPlayer player : playersInGame) {
        deck.drawCard(player);   //發牌
      }
    } while (!deck.getStandardCards().isEmpty());

    for (ShowdownPlayer player : playersInGame) {
      player.showCardsInHand();
      //發牌
    }

    for (int i = 1; i <= 13; i++) {
      System.out.println("=======開始回合 Round " + i + "=======");
      startRound(playersInGame);//開始回合
    }
    showTheLastWinner();
  }

  private ShowdownPlayer createRandomPlayer(String name) {
    Random random = new Random();
    if (random.nextBoolean()) {
      return new HumanPlayer(name);
    } else {
      return new AIPlayer(name);
    }
  }

  private void initPlayer(ShowdownPlayer player) {
    playersInGame.add(player);
  }


  public void startRound(List<ShowdownPlayer> players) {
    playInRound(players);
    showTheWinnerInRound();
  }


  public void playInRound(List<ShowdownPlayer> players) {
    Map<ShowdownPlayer, ShowdownCard> cardsInRound = new HashMap<>() {
    };//在回合中出的牌

    //每个玩家出一张牌
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
    //显示每个玩家出的牌

    for (Map.Entry<ShowdownPlayer, ShowdownCard> entry : cardsInRound.entrySet()) {
      ShowdownPlayer player = entry.getKey();
      ShowdownCard card = entry.getValue();
      System.out.println(player.getName() + " 出了 " + card.toString());
    }

    //确定赢家
    winner = null;
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
  }

  private ShowdownPlayer getExchangePlayer(List<ShowdownPlayer> players, ShowdownPlayer currentPlayer) {
    Random random = new Random();
    ShowdownPlayer exchangee;

    do {
      int index = random.nextInt(players.size());
      exchangee = players.get(index);
    } while (exchangee.equals(currentPlayer)); // 如果选到自己，再次选择
    System.out.println(currentPlayer.getName() + " 選擇和 " + exchangee.getName() + " 交換手牌");
    return exchangee;
  }

  public void showTheWinnerInRound() {
    //显示赢家
    System.out.println(winner.getName() + " 為  赢家");
  }

  private void showTheLastWinner() {
    lastWinner = playersInGame.get(0);
    for (ShowdownPlayer player : playersInGame) {
      if (player.getPoints() > lastWinner.getPoints()) {
        lastWinner = player;
      }
    }
    System.out.println("The  last winner is: " + lastWinner.getName());
  }
}
