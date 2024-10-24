package dp;

import java.util.Arrays;

public class A279PerfectSquares {
  public int numSquares(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -2);

    return numSquares0(n, memo);
  }

  private int numSquares0(int n, int[] memo) {
    if(n < 0) return -1;
    if(n == 0) return 0;
    if(memo[n] != -2) return memo[n];

    int res = Integer.MAX_VALUE;

    for (int i = 1, square = 1; square <= n; i++, square = i * i) {
      var subsolution = numSquares0(n - square, memo);
      if(subsolution == -1) continue;
      res = Math.min(res, subsolution + 1);
    }

    memo[n] = res == Integer.MAX_VALUE ? -1 : res;
    return memo[n];
  }
}
