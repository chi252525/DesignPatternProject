package uno;

import static uno.UnoDeck.standardUnoCards;

public class Main {

  public static void main(String[] args) {
    UnoGame uno = new UnoGame(standardUnoCards());
    uno.start();
  }
}
