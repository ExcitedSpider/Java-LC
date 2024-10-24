package greedy;

import java.util.Arrays;

/**
 * A738MonoIncDigits
 */
public class A738MonoIncDigits {
  int posOf9;

  public int monotoneIncreasingDigits(int n) {
    int[] digits = Integer.toString(n).chars().map(c -> c - '0').toArray();
    posOf9 = digits.length;

    iterator(digits, digits.length - 1);
    for (int i = posOf9; i < digits.length; i++) {
      digits[i] = 9;
    }

    return Arrays.stream(digits).reduce(0, (acc, cur) -> acc * 10 + cur);
  }

  private void iterator(int[] digits, int pos) {
    if (pos <= 0)
      return;

    if (digits[pos] < digits[pos - 1]) {
      posOf9 = pos;
      digits[pos] = 9;
      digits[pos - 1]--;
    }

    iterator(digits, pos - 1);
  }
}