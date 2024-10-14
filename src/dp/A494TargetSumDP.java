package dp;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class A494TargetSumDP {
  public int findTargetSumWays(int[] nums, int target) {
    var sum = IntStream.of(nums).sum();
    // by math, we know there is not solution
    if (Math.abs(target) > sum || (sum + target) % 2 != 0)
      return 0;

    var targetSubsetSum = (sum + target) / 2;
    int[][] memo = new int[nums.length][targetSubsetSum + 1];
    for (int[] is : memo) {
      Arrays.fill(is, -1);
    }

    return lambda(nums, nums.length - 1, targetSubsetSum, memo);
  }

  // λ(pos, target) := the number of subsets with sum `target`
  // from the first `pos` elements
  // λ(n + 1, target) = λ(n, target - nums[pos]) + λ(n, target)
  // λ(n, 0) = 2^(number of 0s in the first n elements)
  // λ(0, target) = nums[0] == target ? 1 : 0;
  private int lambda(int[] num, int pos, int target, int[][] memo) {
    if (target == 0)
      return (int) Math.pow(2, countZeros.apply(num, pos));
    if (pos < 0 || target < 0) // Prevent accessing negative indices
      return 0;
    if (memo[pos][target] != -1)
      return memo[pos][target];

    memo[pos][target] = lambda(num, pos - 1, target - num[pos], memo) + lambda(num, pos - 1, target, memo);

    return memo[pos][target];
  }

  private BiFunction<int[], Integer, Integer> countZeros = (ls, pos) -> 
    (int) IntStream.rangeClosed(0, pos).filter(idx -> ls[idx] == 0).count();
}
