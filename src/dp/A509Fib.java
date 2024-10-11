package dp;

import java.util.HashMap;
import java.util.Map;

public class A509Fib {
  public int fib_plain(int n) {
      if(n <= 1) return n;
      int[] dp = new int[n + 1];
      dp[0] = 0;
      dp[1] = 1;

      for(int index = 2; index <= n; index ++) {
        dp[index] = dp[index - 1] + dp[index - 2];
      } 

      return dp[n];
  }

  public int fib(int n) {
    Map<Integer, Integer> memo = new HashMap<>();

    return fib_rec(n, memo);
  }

  public int fib_rec(int n, Map<Integer, Integer> memo) {
    if(n <= 1) return n;

    if(memo.containsKey(n)) {
      return memo.get(n);
    }

    int res = fib_rec(n - 1, memo) + fib_rec(n - 2, memo);
    memo.put(n, res);

    return res;
  }
}
