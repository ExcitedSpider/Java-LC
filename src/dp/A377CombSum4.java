package dp;

import java.util.Arrays;

/**
 * A377CombSum4
 */
public class A377CombSum4 {
  public int combinationSum4(int[] nums, int target) {
    int[] memo = new int[target + 1];
    Arrays.fill(memo, -1);

    return combSum(nums, target, memo);
      
  }

  // combSum(nums, target): how many possible ways to get the sum target 
  // by combination of nums
  private int combSum(int[] nums, int target, int [] memo) {
    if(target < 0) return 0;
    if(target == 0) return 1; // only the empty set
    if(memo[target] != -1) return memo[target];

    var res = Arrays
              .stream(nums)
              .map(val -> combSum(nums, target - val, memo))
              .sum();

    memo[target] = res;
    return res;
  } 
}