package org.project1;

public enum Rank {

  A("A",14),
  K("K",13),
  Q("Q",12),
  J("J",11),
  T("T",10),
  NINE("9",9),
  EIGHT("8",8),
  SEVEN("7",7),
  SIX("6",6),
  FIVE("5",5),
  FOUR("4",4),
  THREE("3",3),
  TWO("2",2);

  private String name;
  private int order;

  Rank(String name, int order) {
    this.name = name;
    this.order = order;
  }

  public int getOrder() {
    return order;
  }

  @Override
  public String toString() {
    return name;
  }
}

