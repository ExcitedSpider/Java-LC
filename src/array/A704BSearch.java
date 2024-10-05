package array;

public class A704BSearch {
  public static int search(int[] nums, int target) {
    var length = nums.length;
    
    if(nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }
    if (target > nums[length -1] || target < nums[0]) {
      return -1;
    } 
    
    var left = 0;
    var right = nums.length - 1;

    while(left <= right) {
      // a trick to avoid some cases of integer overflow
      // equivalent to (left + right) / 2
      var mid = (left + (right - left) / 2);
      // lemma1: |len([:mid - 1]) - len([mid + 1:])| <= 1

      if(target == nums[mid]) {
        return mid;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {-1,0,3,5,9,12};
    System.err.println(search(nums, 9));
  }
}
