package bowling.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BowlingGameTest {

  @ParameterizedTest
  @MethodSource("scoredGames")
  void scoring(String game, int expectedScore) {
    BowlingGame bowlingGame = BowlingGame.of(game);
    assertThat(bowlingGame.score()).isEqualTo(expectedScore);
  }

  private static Stream<Arguments> scoredGames() {
    return Stream.of(
        Arguments.of("--|--|--|--|--|--|--|--|--|--||", 0),
        Arguments.of("1-|--|--|--|--|--|--|--|--|--||", 1),
        Arguments.of("X|X|X|X|X|X|X|X|X|X||XX", 300),
        Arguments.of("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||", 90),
        Arguments.of("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5", 150),
        Arguments.of("X|7/|9-|X|-8|8/|-6|X|X|X||81", 167));
  }


  @Test
  void display_score() {
    String game = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
    String printedGame = """
        __________________________________
        |X |7/|9-|X |-8|8/|-6|X |X |X ||81|
        |20|19| 9|18| 8|10| 6|30|28|19||  |
        -----------------------------------
        """;
    BowlingGame bowlingGame = BowlingGame.of(game);
    assertThat(bowlingGame.print()).isEqualTo(printedGame);
  }
}
