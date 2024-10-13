package greedy;

import java.util.Arrays;

public class A45MinJump {
  public int jump(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);

    return jump(nums, nums.length - 1, memo);
  }

  // memo[i] is the min steps from 0 to i
  // -1 for uninitialized
  private int jump(int[] nums, int target, int[] memo) {
    if(target == 0) return 0;
    if(memo[target] != -1) {
      System.err.println("Memo Hit");
      return memo[target];
    };
    
    var minStep = Integer.MAX_VALUE;
    for(var i = 0; i < target; i ++) {
      if(nums[i] + i >= target) {
        minStep = jump(nums, i, memo) + 1;
        break;
      }
    }

    // The test cases are generated such that you can reach nums[n - 1].
    if(minStep == Integer.MAX_VALUE) {
      throw new RuntimeException("Unreachable Step");
    }
    
    memo[target] = minStep;
    return minStep;
  }

  public static void main(String[] args) {
    int [] nums = {2,3,1,4,6,3,2,4,2,2,5,2,2,5,1,4};
    var it = new A45MinJump().jump(nums);
    System.err.println(it);
  }
}
