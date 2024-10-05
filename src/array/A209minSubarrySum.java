package array;

import java.util.function.BiFunction;

public class A209minSubarrySum {
  // this works but slow
  public static int minSubArrayLen(int target, int[] nums) {
    var minLength = nums.length;

    // get sum of [left, right)
    // this can be 
    BiFunction<Integer, Integer, Integer> getSum = (left, right) -> {
      var res = 0;
      while (left < right) {
        res += nums[left];
        left ++;
      }
      return res;
    };

    for (int sum = 0, left = 0, right = 0; right <= nums.length || sum >= target;) {
      sum = getSum.apply(left, right);
      if(sum < target) {
        right ++;
      } else {
        minLength = Math.min(right - left, minLength); 
        left ++;
      }
    }

    if(minLength < nums.length) {
      return minLength;
    }else {
      return getSum.apply(0, nums.length) >= target ? minLength : 0;
    }
  }

  // speed up version
  // need to keep track of sum 
  public static int minSubArrayLen0(int target, int[] nums) {
    var minLength = nums.length;
    var sum = 0;
    int left = 0, right = 0;

    while (right < nums.length) {
      if(sum < target) {
        sum += nums[right];
        right ++;
      } else {
        minLength = Math.min(right - left, minLength); 
        sum -= nums[left];
        left ++;
      }
    }

    while (sum >= target) {
        minLength = Math.min(right - left, minLength); 
        sum -= nums[left];
        left ++;
    }

    if(left == 0 && right == nums.length && sum < target) {
      return 0;
    }
    return minLength;
  }

  public static void main(String[] args) {
    int[] testCase1 = {2,3,1,2,4,3};
    System.err.println(minSubArrayLen0(7, testCase1));

    // int[] testCase2 = {1,4,4};
    // System.err.printf("You get %d \n", minSubArrayLen(4, testCase2));
  }
}