package bowling.game;

import java.util.Arrays;

public class BowlingGame {

  public static final int NUMBER_OF_FRAMES = 10;
  public static final char MISS = '-';
  public static final char SPARE = '/';
  public static final char STRIKE = 'X';
  public static final String FRAME_SEPARATOR = "|";
  private final int[] framesScores;
  private final String game;

  private BowlingGame(String game, int[] framesScores) {
    this.game = game;
    this.framesScores = framesScores;
  }

  public static BowlingGame of(String game) {
    char[] throwArray = game.replace(FRAME_SEPARATOR, "").concat("--").toCharArray();
    int[] frameScore = new int[NUMBER_OF_FRAMES];
    int throwIndex = 0;
    for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
      char firstThrow = throwArray[throwIndex];
      char secondThrow = throwArray[throwIndex + 1];
      char thirdThrow = throwArray[throwIndex + 2];

      if (firstThrow == STRIKE) {
        frameScore[i] = 10 + scoreThrow(secondThrow) + scoreThrow(thirdThrow);
        throwIndex++;
      } else if (secondThrow == SPARE) {
        frameScore[i] = 10 + scoreThrow(thirdThrow);
        throwIndex += 2;
      } else {
        frameScore[i] = scoreThrow(firstThrow) + scoreThrow(secondThrow);
        throwIndex += 2;
      }
    }
    return new BowlingGame(game, frameScore);
  }

  private static int scoreThrow(char aThrow) {
    return switch (aThrow) {
      case STRIKE -> 10;
      case MISS -> 0;
      default -> Integer.parseInt(String.valueOf(aThrow));
    };
  }

  public int score() {
    return Arrays.stream(framesScores).sum();
  }
}
