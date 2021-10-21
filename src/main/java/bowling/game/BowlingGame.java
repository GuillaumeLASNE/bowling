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
    for (char c:game.toCharArray()) {
      if(c == '-') {
        knockedPins.add(0);
      }
    }
    return new BowlingGame(knockedPins);
  }

  public int score() {
    return 0;
  }

  public List<Integer> getKnockedPins() {
    return knockedPins;
  }
}
