package bowling.game;

public class BowlingGame {

  private BowlingGame() {

  }

  public static BowlingGame of(String game) {
    return new BowlingGame();
  }

  public int score() {
    return 0;
  }
}
