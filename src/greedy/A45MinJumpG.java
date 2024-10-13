package greedy;

// G for greedy
public class A45MinJumpG {
  public int jump(int[] nums) {
    if(nums.length == 1) return 0;

    return jump(nums, 0, 0, 0);
  }

  // get next cover in [L, R] range 
  private int jump(int[] nums, int curRangeL, int curRangeR, int step) {
    if(curRangeR >= nums.length - 1) return step;

    var nextRange = curRangeR;
    for(var i = curRangeL; i <= curRangeR; i ++) {
      nextRange = Math.max(nextRange, nums[i] + i);
    }

    return jump(nums, curRangeR + 1, nextRange, step + 1);
  }

  public static void main(String[] args) {
    int[] nums = {2,3,1,1,4}; 
    new A45MinJumpG().jump(nums);
  }
}
