package greedy;

public class A122Stock2 {
  public int maxProfit(int[] prices) {
    if(prices.length <= 1) return 0;
    // whether buy on day 1
    if(prices[0] < prices[1]) {
      return maxProfit(prices, 1, prices[1] - prices[0], prices[0], true);
    } else {
      return maxProfit(prices, 1, prices[1] - prices[0], 0, false);
    }
  }

  private int maxProfit(int[] prices, int pos, int preDiff, int sum, boolean hold) {
    if (!hold) {
      // last day
      if (pos == prices.length - 1) {
        return sum;
      } else {
        var diff = prices[pos + 1] - prices[pos];
        if (diff > 0 && preDiff <= 0) {
          // buy it
          return maxProfit(prices, pos + 1, diff, sum - prices[pos], true);
        } else {
          // wait
          return maxProfit(prices, pos + 1, diff, sum, false);
        }
      }
    } else {
      if (pos == prices.length - 1) {
        return sum + prices[prices.length - 1];
      } else {
        var diff = prices[pos + 1] - prices[pos];
        if (diff < 0 && preDiff >= 0) {
          // sell it
          return maxProfit(prices, pos + 1, diff, sum + prices[pos], false);
        } else {
          // wait
          return maxProfit(prices, pos + 1, diff, sum, true);
        }
      }
    }
  }
}
