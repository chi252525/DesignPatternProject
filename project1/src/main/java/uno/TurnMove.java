package uno;

public class TurnMove {
  private final UnoPlayer player;
  private final boolean pass;
  private final UnoCard unoCard;

  private TurnMove(UnoPlayer player, boolean pass, UnoCard unoCard) {
    this.player = player;
    this.pass = pass;
    this.unoCard = unoCard;
  }

  public static TurnMove pass(UnoPlayer player) {
    return new TurnMove( player, true, null);
  }

  public static TurnMove play(UnoPlayer player, UnoCard unoCard) {
    return new TurnMove(player, false, unoCard);
  }

  public UnoCard getCard() {
    return unoCard;
  }

  public boolean isPass() {
    return pass;
  }

  public UnoPlayer getPlayer() {
    return player;
  }

  public void undo() {
    player.addHandCard(unoCard);
  }
}
