package showdown;

import static showdown.ShowdownDeck.standard52Cards;

public class Main {

  public static void main(String[] args) {
    ShowdownGame game = new ShowdownGame(standard52Cards());
    game.start();
    System.out.println("game end!");
  }

}