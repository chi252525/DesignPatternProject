package showdown;

import java.util.List;
import java.util.Scanner;
import javax.smartcardio.Card;

public class HumanPlayer extends ShowdownPlayer {

  public HumanPlayer(String name) {
    super(name + " (HumanPlayer)");
  }

  @Override
  public ShowdownCard showCard() {
    if (getCardsInHand().isEmpty()) { // 手牌为空
      return null;
    }

    System.out.println("請選擇要出的牌:");

    // 玩家手牌
    List<ShowdownCard> cardsInHand = getCardsInHand();
    for (int i = 0; i < cardsInHand.size(); i++) {
      System.out.println((i + 1) + ". " + cardsInHand.get(i) + "card: " + cardsInHand.get(i)
          .toString()); // 输出手牌和对应的索引
    }

    Scanner scanner = new Scanner(System.in);
    int choice = -1;
    while (choice < 1 || choice > cardsInHand.size()) {
      System.out.print("请输入牌的编号（1 - " + cardsInHand.size() + "）: ");
      if (scanner.hasNextInt()) {
        choice = scanner.nextInt();
        if (choice < 1 || choice > cardsInHand.size()) {
          System.out.println("無效的選擇，请重新输入！");
        }
      } else {
        System.out.println("请输入一个有效的数字！");
        scanner.next();
      }
    }

    return cardsInHand.get(choice - 1); // 因为用户输入是从1开始的，所以减1
  }
}
