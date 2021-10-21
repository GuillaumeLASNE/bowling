package bowling.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class BowlingGameTest {
  @Test
  void the_score_of_a_game_with_only_miss_pins_is_zero() {
    String gameWithOnlyMiss = "--|--|--|--|--|--|--|--|--|--||";
    BowlingGame bowlingGame = BowlingGame.of(gameWithOnlyMiss);
    int score = bowlingGame.score();
    assertThat(score).isZero();
  }

  @Test
  void the_score_of_a_game_with_one_knocked_pins_is_zero() {
    String game = "1-|--|--|--|--|--|--|--|--|--||";
    BowlingGame bowlingGame = BowlingGame.of(game);
    int score = bowlingGame.score();
    assertThat(score).isOne();
  }
}
