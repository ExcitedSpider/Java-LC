package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class A518CoinChange2 {
  public int change(int amount, int[] coins) {
    int[][] memo = new int[coins.length][amount + 1];
    for (int[] is : memo) {
      Arrays.fill(is, -1);
    }
    return change0(coins, amount, 0, memo);
  }

  // number of ways to make up the amount
  public int change0(int[] coins, int amount, int start, int[][] memo) {
    if (amount == 0)
      return 1;
    if (memo[start][amount] != -1)
      return memo[start][amount];

    var res = IntStream.range(start, coins.length)
        .filter(idx -> coins[idx] <= amount)
        .map(idx -> change0(coins, amount - coins[idx], idx, memo))
        .sum();

    memo[start][amount] = res;
    return memo[start][amount];
  }

  static A518CoinChange2 instance = new A518CoinChange2();

  public static void main(String[] args) {
    int[] coins = {1,2,5};
    System.err.println(instance.change(5, coins));
  }
}
