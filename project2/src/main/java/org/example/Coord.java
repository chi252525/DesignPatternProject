package org.example;

public class Coord {
  private double x;  // X軸座標
  private double y;  // Y軸座標


  public Coord(double x, double y) {
    this.x = x;
    this.y = y;
  }


  public double getX() {
    return x;
  }


  public double getY() {
    return y;
  }


  @Override
  public String toString() {
    return "Coord{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }

  public double distanceTo(Coord other) {
    double dx = this.x - other.x;
    double dy = this.y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }
}
