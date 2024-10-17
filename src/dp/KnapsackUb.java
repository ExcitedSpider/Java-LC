package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

// The Unbounded knapsack
// https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
public class KnapsackUb {
  public int maxProfit(int[] values, int[] weights, int capacity) {
    int[] memo = new int[capacity + 1];
    Arrays.fill(memo, -1);

    return maxProfit0(values, weights, capacity, memo);
  }

  // the max profit of using a bag with capacity `cap` choosing from n items
  // "Unbounded" means one item can be selected any times
  public int maxProfit0(int[] values, int[] weights, int cap, int[] memo) {
    if (cap <= 0) return 0;
    if (memo[cap] != -1) return memo[cap];
    var len = values.length;

    // Check each item and find the most profitable one
    int res = IntStream.range(0, len)
        .filter(idx -> cap >= weights[idx])
        .map(idx -> values[idx] + maxProfit0(values, weights, cap - weights[idx], memo))
        .max()
        .orElse(0);

    memo[cap] = res;
    return res;
  }

  static KnapsackUb instance = new KnapsackUb();

  public static void main(String[] args) {
    testcase1();
    testcase2();
    testcase3();
    testcase4();
    testcase5();
  }

  static void testcase1() {
    int[] values = { 2, 4, 4, 5 };
    int[] weights = { 1, 2, 3, 4 };

    var outcome = instance.maxProfit(values, weights, 5);
    assert outcome == 10 : "Test case 1 failed";
  }

  static void testcase2() {
    int[] values = { 1, 3, 4 };
    int[] weights = { 1, 2, 3 };

    var outcome = instance.maxProfit(values, weights, 2);
    assert outcome == 3 : "Test case 2 failed";
  }

  static void testcase3() {
    int[] values = { 6, 10, 12 };
    int[] weights = { 1, 2, 3 };

    var outcome = instance.maxProfit(values, weights, 5);
    assert outcome == 30 : "Test case 3 failed";
  }

  static void testcase4() {
    int[] values = { 1, 2, 3 };
    int[] weights = { 1, 3, 4 };

    var outcome = instance.maxProfit(values, weights, 3);
    assert outcome == 3 : "Test case 4 failed";
  }

  static void testcase5() {
    int[] values = { 10, 40, 50, 70 };
    int[] weights = { 1, 3, 4, 5 };

    var outcome = instance.maxProfit(values, weights, 8);
    assert outcome == 110 : "Test case 5 failed";
  }
}
