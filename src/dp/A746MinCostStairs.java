package dp;

import java.util.HashMap;
import java.util.Map;

public class A746MinCostStairs {
  public int minCostClimbingStairs(int[] cost) {
    Map<Integer, Integer> memo = new HashMap<>();

    return minCostClimbingStairs(cost.length, cost, memo);

  }

  public int minCostClimbingStairs(int n, int[] cost, Map<Integer, Integer> memo) {
    if (n <= 1)
      return 0;
    if(memo.containsKey(n)){
      return memo.get(n);
    }

    var sumOfCost = Math.min(
        cost[n - 1] + minCostClimbingStairs(n - 1, cost, memo),
        cost[n - 2] + minCostClimbingStairs(n - 2, cost, memo));

    memo.put(n, sumOfCost);

    return sumOfCost;
  }
}
