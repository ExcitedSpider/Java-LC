package greedy;

public class A53MaxSubarray {
  public int maxSubArray(int[] nums) {
      return maxSubArray(nums, 0, 0, Integer.MIN_VALUE);
  }

  public int maxSubArray(int[] nums, int pos, int preSum, int maxSum) {
      if(pos == nums.length) {
        return maxSum;
      } else {
        var sum = preSum + nums[pos];
        if(sum > maxSum) {
          maxSum = sum;
        } 
        if(sum <= 0) {
          return maxSubArray(nums, pos+1, 0, maxSum);
        } else {
          return maxSubArray(nums, pos+1, sum, maxSum);
        }
      }
  }
}
