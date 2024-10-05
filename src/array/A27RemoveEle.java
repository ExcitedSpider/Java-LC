package array;

import java.util.Arrays;

public class A27RemoveEle {
  public static int removeElement(int[] nums, int val) {
    int slowPtr = 0;
    int fastPtr = 0;

    while(fastPtr != nums.length) {
      if(nums[fastPtr] == val) {
        fastPtr ++;
      }else {
        nums[slowPtr] = nums[fastPtr];
        slowPtr ++;
        fastPtr ++;
      }
    }

    return slowPtr;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,2,2,3,0,4,2};
    var k = removeElement(nums, 2);
    System.err.println(Arrays.toString(
      Arrays.copyOfRange(nums, 0, k)
    ));
  }
}
