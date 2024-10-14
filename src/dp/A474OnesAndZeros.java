package dp;

import java.util.Arrays;
import java.util.function.Function;

public class A474OnesAndZeros {
  private int[] numOf0s; 
  private Function<String, Integer> getNumOf0s = str -> (int) str.chars().filter(c -> c == '0').count();

  public int findMaxForm(String[] strs, int m, int n) {
    int[][][] memo = new int[m + 1][n + 1][strs.length];
    for (int[][] is : memo) {
      for (int[] is2 : is) {
        Arrays.fill(is2, -1);
      }
    }

    numOf0s = new int[strs.length];
    for (int i = 0; i < strs.length; i++) {
      numOf0s[i] = getNumOf0s.apply(strs[i]);
    }

    return lambda(strs, m, n, strs.length - 1, memo);
  }

  // λ := the max of the subset with at most m 0s and n 1s
  // by picking from strs with range [0, pos]
  // λ m n (pos + 1) = max (1 + λ (m - num0s strs[pos]) λ (n - num1s strs[pos]))
  // (λ m n pos)
  // memo[m][n][pos]
  public int lambda(String[] strs, int m, int n, int pos, int[][][] memo) {
    if (pos < 0) return 0;
    if (memo[m][n][pos] != -1) return memo[m][n][pos] ;

    var num0s = numOf0s[pos];
    var num1s = strs[pos].length() - num0s;

    if (m - num0s >= 0 && n - num1s >= 0) {
      memo[m][n][pos] = Math.max(
          1 + lambda(strs, m - num0s, n - num1s, pos - 1, memo),
          lambda(strs, m, n, pos - 1, memo));
    }else {
      memo[m][n][pos] = lambda(strs, m, n, pos - 1, memo);
    }
    return memo[m][n][pos];
  }
}
