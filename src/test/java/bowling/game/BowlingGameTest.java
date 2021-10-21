package bowling.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BowlingGameTest {
  @Test
  void the_score_of_a_game_with_no_knocked_pins_is_zero() {
    String game = "--|--|--|--|--|--|--|--|--|--||";
    BowlingGame bowlingGame = BowlingGame.of(game);
    int score = bowlingGame.score();
    assertThat(score).isZero();
  }
}
