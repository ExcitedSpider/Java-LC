package dp;

import java.util.HashMap;
import java.util.Map;

public class A79Stairs {
  public int climbStairs(int n) {
      Map<Integer, Integer> memo = new HashMap<>();

      return climbStairs(n, memo);
  }

  public int climbStairs(int n, Map<Integer, Integer> memo) {
      if(n <= 2) return n;
      
      if(memo.containsKey(n)) {
        return memo.get(n);
      }

      int res = climbStairs(n - 1, memo) + climbStairs(n- 2, memo);
      memo.put(n, res);

      return res;
  }

}
