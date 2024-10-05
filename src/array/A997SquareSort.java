package array;

import java.util.Arrays;

public class A997SquareSort {
  public static int[] sortedSquares(int[] nums) {
    var left = 0;
    var right = nums.length - 1;

    int[] res = new int[nums.length];
    var index = res.length - 1;

    while(left <= right) {
      if(Math.abs(nums[left]) > Math.abs(nums[right])) {
        res[index] = nums[left] * nums[left];
        left ++;
      } else {
        res[index] = nums[right] * nums[right];
        right --;
      }

      index --;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] testcase1 = {-7,-3,2,3,11};
    System.err.println(Arrays.toString(sortedSquares(testcase1)));
  }
}
