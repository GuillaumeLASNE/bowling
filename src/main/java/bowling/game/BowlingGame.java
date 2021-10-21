package bowling.game;

import java.util.Arrays;

public class BowlingGame {

  public static final int NUMBER_OF_FRAMES = 10;
  public static final char MISS = '-';
  public static final char SPARE = '/';
  public static final char STRIKE = 'X';
  public static final String FRAME_SEPARATOR = "|";
  private final char[] throwArray;
  private final String game;

  private BowlingGame(String game, char[] throwArray) {
    this.game = game;
    this.throwArray = throwArray;
  }

  public static BowlingGame of(String game) {
    char[] throwArray = game.replace(FRAME_SEPARATOR, "").concat("--").toCharArray();
    return new BowlingGame(game, throwArray);
  }

  public int score() {
    int[] frameScore = getFrameScore();
    return Arrays.stream(frameScore).sum();
  }

  private int[] getFrameScore() {
    int[] frameScore = new int[NUMBER_OF_FRAMES];
    int throwIndex = 0;
    for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
      int firstThrow = throwIndex;
      int secondThrow = throwIndex + 1;
      int thirdThrow = throwIndex + 2;

      if (throwArray[firstThrow] == STRIKE) {
        frameScore[i] = 10 + scoreThrow(secondThrow) + scoreThrow(thirdThrow);
        throwIndex++;
      } else if (throwArray[secondThrow] == SPARE) {
        frameScore[i] = 10 + scoreThrow(thirdThrow);
        throwIndex += 2;
      } else {
        frameScore[i] = scoreThrow(firstThrow) + scoreThrow(secondThrow);
        throwIndex += 2;
      }
    }
    return frameScore;
  }

  private int scoreThrow(int throwIndex) {
    return switch (throwArray[throwIndex]) {
      case STRIKE -> 10;
      case SPARE -> 10 - scoreThrow(throwIndex - 1);
      case MISS -> 0;
      default -> parseInt(throwArray[throwIndex]);
    };
  }

  private int parseInt(char anInt) {
    return Integer.parseInt(String.valueOf(anInt));
  }
}
