package project1;

import java.util.Objects;

public class Individual {

  private int id;             // 編號
  private Gender gender;      // 性別: "MALE" 或 "FEMALE"
  private int age;            // 年齡
  private String intro;       // 自我介紹
  private String habits;      // 興趣
  private Coord coord;        // 座標

  public enum Gender {
    FEMALE, MALE
  }

  public Individual(int id, Gender gender, int age, String intro, String habits, Coord coord) {
    this.id = id;
    this.gender = gender;
    if (age < 18) {
      throw new IllegalArgumentException("Age should be greater than 18");
    }
    this.age = age;
    this.intro = intro;
    if (intro.length() > 200) {
      throw new IllegalArgumentException("intro should be less than 200");
    }
    this.habits = habits;
    this.coord = coord;
  }

  public int getId() {
    return id;
  }


  public Gender getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }


  public String getIntro() {
    return intro;
  }


  public String getHabits() {
    return habits;
  }


  public Coord getCoord() {
    return coord;
  }


  public void setCoord(Coord coord) {
    this.coord = coord;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Individual that = (Individual) o;
    return id == that.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  // ToString 方法，便于输出对象信息
  @Override
  public String toString() {
    return "Individual{" +
        "id=" + id +
        ", gender='" + gender + '\'' +
        ", age=" + age +
        ", intro='" + intro + '\'' +
        ", habits='" + habits + '\'' +
        ", coord=" + coord +
        '}';
  }
}
