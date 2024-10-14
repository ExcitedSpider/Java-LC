package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class A416EqualPartition {
  public boolean canPartition(int[] nums) {
      var sum = IntStream.of(nums).sum();
      if(sum % 2 != 0) return false;
      var cap = sum / 2;
      int[][] memo = new int[nums.length][cap + 1];

      for (var is : memo) {
        Arrays.fill(is, -1);
      }

      var weight = maxWeight(nums, nums.length - 1, cap, memo);
      return weight == cap; // can fill all
  }
  
  private int maxWeight(int[] nums, int pos, int capacity, int[][]memo) {
    if(capacity <= 0 || pos < 0) return 0;
    else if(memo[pos][capacity] != -1) return memo[pos][capacity];
    
    int weight;
    
    if(nums[pos] <= capacity) {
      weight = Math.max( 
        maxWeight(nums, pos - 1, capacity, memo),
        nums[pos] + maxWeight(nums, pos - 1, capacity - nums[pos], memo)
      );
    } else {
      weight = maxWeight(nums, pos - 1, capacity ,memo);
    }

    memo[pos][capacity] = weight;
    return weight;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,5};
    System.err.println(
      new A416EqualPartition().canPartition(nums)
    );
  }
}
