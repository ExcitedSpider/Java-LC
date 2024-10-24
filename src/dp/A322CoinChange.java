package dp;

import java.util.Arrays;

public class A322CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[] memo = new int[amount + 1];
    Arrays.fill(memo, -2);
    return coinChange(coins, amount, memo);
  }

  public int coinChange(int[] coins, int amount, int[] memo) {
    if (amount < 0)
      return -1;
    if (amount == 0)
      return 0;
    if (memo[amount] != -2)
      return memo[amount];

    var res = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      var numOfCoins = coinChange(coins, amount - coins[i], memo);
      if (numOfCoins == -1) {
        continue;
      } else {
        res = Math.min(res, numOfCoins + 1);
      }
    }
    res = res == Integer.MAX_VALUE ? -1 : res;
    memo[amount] = res;
    return res;
  }

  public static void main(String[] args) {
    var solver = new A322CoinChange();
    var res = solver.coinChange(new int[] { 1 }, 1);
    System.out.println(res);
  }
}
