package showdown;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import templete.AbstractGame;
import templete.Deck;

public class ShowdownGame extends AbstractGame<ShowdownPlayer, ShowdownCard> {

  public static final int NUM_OF_ROUNDS = 13;

  Map<ShowdownPlayer, ShowdownCard> cardsInRound = new HashMap<>() {
  };//在回合中每位玩家出的牌

  public ShowdownGame(Deck deck) {
    super(deck);
  }

  @Override
  protected void onGameBegins() {
    int currentRound = 1;
    do {
      System.out.println("=======開始回合 Round " + currentRound + "=======");
      startRound(getPlayersInGame());//開始回合
    } while (!isGameOver(currentRound++));
  }

  public void startRound(List<ShowdownPlayer> players) {
    playInRound(players);

  }


  @Override
  protected void onRoundEnd() {
    //显示每个玩家出的牌
    for (Entry<ShowdownPlayer, ShowdownCard> entry : cardsInRound.entrySet()) {
      ShowdownPlayer player = entry.getKey();
      ShowdownCard card = entry.getValue();
      System.out.println(player.getName() + " 出了 " + card.toString());
    }
    determineWinnerInRound(cardsInRound);
    cardsInRound.clear();
  }

  @Override
  protected int getInitialHandSize() {
    return 13;
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

  @Override
  protected boolean isGameOver(int currentRound) {
    return currentRound >= NUM_OF_ROUNDS;
  }

  public void playInRound(List<ShowdownPlayer> players) {

    //每个玩家出一张牌
    for (ShowdownPlayer currentPlayer : players) {
      ShowdownPlayer choiceExchangee = getExchangePlayer(players, currentPlayer);
      //隨機選擇一個玩家交換手牌
      currentPlayer.checkExchangeHandCard(choiceExchangee);
      //當下的玩家出牌
      takeTurn(currentPlayer);
    }

  }

  @Override
  protected void takeTurn(ShowdownPlayer currentPlayer) {
    ShowdownCard playerShowCard = currentPlayer.showCard();
    if (playerShowCard != null) {
      cardsInRound.put(currentPlayer, playerShowCard);
    } else {
      System.out.println(currentPlayer.getName() + " 沒有牌了 不參與分勝負");
    }
  }

  private void determineWinnerInRound(Map<ShowdownPlayer, ShowdownCard> cardsInRound) {
    ShowdownPlayer winner = null;//在回合中赢家
    //确定回合中的赢家
    ShowdownCard maxCard = null;
    for (Entry<ShowdownPlayer, ShowdownCard> entry : cardsInRound.entrySet()) {
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
    System.out.println(winner.getName() + " 為  赢家");
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


  @Override
  protected void determineTheLastWinner() {
    ShowdownPlayer lastWinner = getPlayersInGame().get(0);
    for (ShowdownPlayer player : getPlayersInGame()) {
      if (player.getPoints() > lastWinner.getPoints()) {
        lastWinner = player;
      }
    }
    System.out.println("The  last winner is: " + lastWinner.getName());
  }
}
