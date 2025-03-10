package uno;

import templete.AbstractPlayer;

public abstract class UnoPlayer extends AbstractPlayer<UnoCard> {

  public abstract TurnMove takeTurn(UnoCard topUnoCard);
}
