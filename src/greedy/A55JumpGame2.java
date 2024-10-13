package greedy;

import java.util.Arrays;

public class A55JumpGame2 {
  public boolean canJump(int[] nums) {
    int [] memo = new int[nums.length];
    Arrays.fill(memo, -1);

    return canJump(nums, nums.length - 1, memo);
  }

  // memo[i]: is i reachable from 0
  // 1 can reach
  // 0 can't
  // -1 unknown
  private boolean canJump(int[] nums, int target, int[] memo) {
    if(target == 0) return true;
    if(memo[target] != -1) return memo[target] == 1;

    for (int i = 0; i < target; i++) {
      if(i+ nums[i] >= target && canJump(nums, i, memo)) {
        memo[target] = 1;
        return true;
      }
    }

    memo[target] = 0;
    return false;
  }

  public static void main(String[] args) {
    int[] testcase = {2,3,1,1,4};
    var res = new A55JumpGame2().canJump(testcase);
    System.err.println(res);
  }
}
