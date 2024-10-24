package dp;

import java.util.Arrays;

/**
 * A377CombSum4
 */
public class A377CombSum4 {
  public int combinationSum4(int[] nums, int target) {
    int[] memo = new int[target];
    Arrays.fill(memo, -1);

    return combSum(nums, target, memo);
      
  }

  // how many possible ways to formulate target
  private int combSum(int[] nums, int target, int [] memo) {
    if(target < 0) return 0;
    if(target == 0) return 1; // only the empty set
    if(memo[target] != -1) return memo[target];
    
    var res = 0;
    for (int i = 0; i < nums.length; i++) {
      res += combSum(nums, target - nums[i], memo);
    }

    memo[target] = res;
    return res;
  } 
}