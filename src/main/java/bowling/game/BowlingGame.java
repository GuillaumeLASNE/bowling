package bowling.game;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

  private final List<Integer> knockedPins;

  private BowlingGame(List<Integer> knockedPins) {
    this.knockedPins = knockedPins;
  }

  public static BowlingGame of(String game) {
    List<Integer> knockedPins = new ArrayList<>();
    for (char c : game.toCharArray()) {
      switch (c) {
        case '|':
          break;
        case '-':
          knockedPins.add(0);
          break;
        default:
          knockedPins.add(Integer.parseInt(String.valueOf(c)));
          break;
      }
    }
    return new BowlingGame(knockedPins);
  }

  public int score() {
    return knockedPins.stream().reduce(0, Integer::sum);
  }
}
