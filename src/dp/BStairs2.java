// Suppose you are climbing a staircase. It takes n steps to reach the top.
// Each time, you can climb at most m (1 <= m < n) steps. How many different ways can you climb to the top?
// Note: The given n is a positive integer
// https://kamacoder.com/problempage.php?pid=1067

package dp;

import java.util.Arrays;
import java.util.Scanner;

public class BStairs2 {
  int waysOfClimbing(int m, int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return countWays(m, n, memo);
  }

  int countWays(int range, int target, int[] memo) {
    if(target < 0) return 0;
    if(target == 0) return 1;
    if(memo[target] != -1) return memo[target];

    int res = 0;
    for (int i = 1; i <= range; i++) {
      res += countWays(range, target - i, memo);
    }
    memo[target] = res;
    return res;
  } 

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var n = scanner.nextInt();
    var m = scanner.nextInt();

    var solver = new BStairs2();
    System.out.println(solver.waysOfClimbing(m, n));
  }
}
