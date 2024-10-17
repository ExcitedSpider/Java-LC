package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * A135Candy
 */
public class A135Candy {
  public int candy(int[] ratings) {
    int[] candies = new int[ratings.length];

    if (ratings.length <= 1) {
      Arrays.fill(candies, 1);
      return sum(candies);
    }

    int[] leftScan = new int[ratings.length];
    Arrays.fill(leftScan, 1);

    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        leftScan[i] = leftScan[i - 1] + 1;
      }
    }

    int[] rightScan = new int[ratings.length];
    Arrays.fill(rightScan, 1);

    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        rightScan[i] = rightScan[i + 1] + 1;
      }
    }

    for (int i = 0; i < rightScan.length; i++) {
      candies[i] = Math.max(rightScan[i], leftScan[i]);
    }

    return sum(candies);
  }

  private int sum(int[] candies) {
    return IntStream.of(candies).sum();
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, 2};
    System.err.println(new A135Candy().candy(arr));
  }

}